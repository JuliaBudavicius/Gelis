package controller;

import Models.DataBaseModel;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class ViewController {

    private final DataBaseModel db = new DataBaseModel();

    public Boolean login(String login, String senha) {
        String query = String.format("select hostname,modCPU,modGPU,qntRAM,fkEmpresa from Maquinas where loginMaquina ='%s' and senhaMaquina = '%s';", login, senha);
        String valida = db.makeSelectQuery(query);
        if(valida == null){
            return false;
        }else{
            return true;
        }
    }

    public void init() {
        db.initializer();
    }
}
