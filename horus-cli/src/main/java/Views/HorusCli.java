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
        String login = "";
        String senha = "";
        Memoria memRam = looca.getMemoria();
        List<Gpu> gpus = components.gpus;
        String modGpu = "";
        String modCPU = "";
        Scanner leitor = new Scanner(System.in);
        Double cpuTemp = temperatura.getTemperatura();

        vc.init();
        System.out.println("\nDigite seu login:");
        login = leitor.nextLine();
        System.out.println("\nDigite sua senha:");
        senha = leitor.nextLine();
        Map map = vc.login(login, senha);
        if (!map.isEmpty()) {
            System.out.println("\n(!) Login Realizado com sucesso!\n");
            System.out.println("Sistema Operacional:");
            System.out.println(sistema.getSistemaOperacional());
            System.out.println("Processador:");
            System.out.println(processador.getNome());
            System.out.println("Quantidade de memória RAM:");
            System.out.println(memRam.getTotal());
            System.out.println("Sua máquina está sendo verificada!");
            String idMaquina = map.get("idMaquina").toString();
            if (gpus != null) {
                for (final Gpu gpu : gpus) {
                    modGpu = gpu.name;
                }
            }
            String qntMem = Conversor.formatarBytes(memRam.getTotal());
            qntMem = qntMem.replace(" MiB", "");
            qntMem = qntMem.replace(",", ".");
            modCPU = processador.getNome();
            vc.Insere(modCPU, modGpu, qntMem, idMaquina);
            vc.startInsert(idMaquina);

        } else {
            System.out.println("\n(!) Login ou senha incorretos!");
        }
    }

}
