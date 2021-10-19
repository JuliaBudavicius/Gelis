package controller;

import Models.DataBaseModel;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.util.Conversor;
import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Gpu;
import com.profesorfalken.jsensors.model.sensors.Temperature;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class ViewController {

    private String fkMaquina;
    private final Looca looca = new Looca();
    private final DataBaseModel db = new DataBaseModel();
    Components components = JSensors.get.components();
    List<Gpu> gpus = components.gpus;
    Memoria memRam = looca.getMemoria();
    Double gpuTemp;

    public Map login(String login, String senha) {
        String query = String.format("select idMaquinas, hostname,modCPU,modGPU,qntRAM,fkEmpresa from Maquinas where loginMaquina ='%s' and senhaMaquina = '%s';", login, senha);
        Map map = db.makeSelectQuery(query);
        if (map.isEmpty()) {
            return map;
        } else {
            return map;
        }
    }

    public void Insere(String modCPU, String modGPU, String qntRAM, String idMaquina) {
        String query = String.format("update Maquinas set modCPU = '%s', modGPU='%s', qntRAM = %s where idMaquinas = %s;", modCPU, modGPU, qntRAM, idMaquina);
        db.makeUpdateQuery(query);
    }

    public void init() {
        db.initializer();
    }

    Timer timer = new Timer();
    private final TimerTask task = new TimerTask() {

        @Override
        public void run() {
            List<Gpu> gpus = JSensors.get.components().gpus;
            if (gpus.size() > 0) {
                Gpu gpu = gpus.get(0);
                if (gpu.sensors.temperatures != null && gpu.sensors.temperatures.size() > 0) {
                    for (Temperature temp : gpu.sensors.temperatures) {
                        if (temp.value != null) {
                            gpuTemp = temp.value;
                        }
                    }
                }
            }

            String qntMem = Conversor.formatarBytes(memRam.getEmUso());
            String nova = qntMem.replace(" GiB", "");
            String nova2 = nova.replace(",", ".");
            qntMem = nova2;
            String tempCPU1 = looca.getTemperatura().toString().replace("Temperatura: ", "");
            String tempCPU = tempCPU1.replace(",", ".");
            String query = String.format("INSERT INTO dadosMaquinas values (null,%s,'%s','%s','%s',now());",
                    fkMaquina,
                    tempCPU,
                    gpuTemp,
                    qntMem);
            db.initializer();
            db.makeInsertQuery(query);

        }
    };

    public void tempoInsert(int segundos) {
        timer.schedule(task, 0, segundos * 1000L);
    }

    public void startInsert(String fkMaquina) {
        setFkMaquina(fkMaquina);
        tempoInsert(15);
    }

    public void setFkMaquina(String fkMaquina) {
        this.fkMaquina = fkMaquina;
    }

}
