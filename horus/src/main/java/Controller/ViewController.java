package controller;

import Models.DataBaseModel;
import com.sun.jna.platform.win32.WinBase;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class ViewController {

    private final DataBaseModel db = new DataBaseModel();

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
}
