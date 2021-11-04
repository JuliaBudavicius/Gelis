package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseModel {

    String url = "jdbc:sqlserver://srvgelis.database.windows.net;"
            + "database=Gelis;"
            + "user=gelis;"
            + "password=#Gfgrupo6;";
    // String user = "root";
    // String password = "bandtec";

    public void initializer() {
        try {
            System.out.println("Conectado ao banco");
        } catch (Exception ex) {
            Logger.getLogger(DataBaseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void makeUpdateQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url); Statement statement = connection.createStatement();) {
            statement.executeUpdate(query);
            System.out.println("Update realizado.");
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void makeInsertQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url); Statement statement = connection.createStatement();) {
            statement.execute(query);
            System.out.println("Insert realizado.");
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Map makeSelectQuery(String query) {
        Map<String, String> map = new HashMap<>();
        try (Connection connection = DriverManager.getConnection(url); Statement statement = connection.createStatement();) {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                map.put("idMaquina", rs.getString(1));
                map.put("Hostname", rs.getString(2));
            }
            return map;
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return map;
    }
}
