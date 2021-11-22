package Views;

import Controller.ViewController;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import com.github.britooo.looca.api.util.Conversor;
import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Gpu;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HorusCli {

    public static void main(String[] args) {
        // Looca
        Looca looca = new Looca();
        Sistema sistema = new Sistema();
        Processador processador = new Processador();
        Temperatura temperatura = looca.getTemperatura();
        Memoria mem = new Memoria();
        Components components = JSensors.get.components();
        DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
        ViewController vc = new ViewController();
        // Variaveis
        Integer menu = 0;
        String login = "";
        String senha = "";
        Memoria memRam = looca.getMemoria();
        List<Gpu> gpus = components.gpus;
        String modGpu = "";
        String modCPU = "";
        Scanner leitor = new Scanner(System.in);
        Double cpuTemp = temperatura.getTemperatura();

        // Estrutura
        do {
            vc.init();
            System.out.println("\nDigite seu login:");
            login = leitor.nextLine();
            System.out.println("\nDigite sua senha:");
            senha = leitor.nextLine();
            Map map = vc.login(login, senha);
            if (!map.isEmpty()) {
                System.out.println("\n(!) Login Realizado com sucesso!\n");
                do {
                    System.out.println("Sua máquina está sendo verificada!");
                    String idMaquina = map.get(0).toString();
                    modCPU = processador.getNome();
                    if (gpus != null) {
                        for (final Gpu gpu : gpus) {
                            modGpu = gpu.name;
                        }
                    }
                    String qntMem = Conversor.formatarBytes(memRam.getTotal());
                    qntMem = qntMem.replace(" GiB", "");
                    qntMem = qntMem.replace(",", ".");
                    modCPU = processador.getNome();
                    vc.Insere(modCPU, modGpu, qntMem, idMaquina);
                    vc.startInsert(idMaquina);
                    System.out.println("\nEscolha o que deseja verificar:\n"
                            + "\n1 - Sistema Operacional"
                            + "\n2 - Processador"
                            + "\n3 - Mémoria RAM"
                            + "\n4 - Disco"
                            + "\n5 - Placa de vídeo"
                            + "\n\n0 - Sair");

                    menu = leitor.nextInt();

                    switch (menu) {
                        case 1:
                            System.out.println(String.format("\n- Seu Sistema Operacional: %s", sistema.getSistemaOperacional()));
                            break;
                        case 2:
                            System.out.println(String.format("\n- Seu processador: %s", processador.getNome()));
                            System.out.println(String.format("Temperatura do processador: %.1fºC", cpuTemp));
                            break;
                        case 3:
                            System.out.println(String.format("\n- Quantidade de Memória RAM: %s", Conversor.formatarBytes(mem.getTotal())));
                            break;
                        case 4:
                            List<Disco> discos = grupoDeDiscos.getDiscos();
                            for (Disco disco : discos) {
                                System.out.println(disco);
                            }
                            break;
                        case 5:
                            System.out.println("\n(!) Você não possui placa de vídeo");
                            break;
                        case 0:
                            System.out.println("\n(!) Você se desconectou, até logo!");
                            return;
                        default:
                            break;
                    }
                } while (menu != 0);
            } else {
                System.out.println("\n(!) Login ou senha incorretos!");
            }
        } while (!login.equals("admin") || !senha.equals("admin"));
    }

}
