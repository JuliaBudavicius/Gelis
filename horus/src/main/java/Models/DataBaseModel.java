package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseModel {

    String url = "jdbc:mysql://localhost:3306/Gelis";
    String user = "root";
    String password = "bandtec";

    public void initializer() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Conectado no banco " + url);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataBaseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void makeUpdateQuery(String query){
        try (Connection connection = DriverManager.getConnection(url, user, password); Statement statement = connection.createStatement();){
            statement.executeUpdate(query);
            System.out.println("Update realizado.");
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Map makeSelectQuery(String query) {
        Map<String, String> map = new HashMap<>();
        try (Connection connection = DriverManager.getConnection(url, user, password); Statement statement = connection.createStatement();) {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                map.put("label1", rs.getString(1));
                map.put("label2", rs.getString(2));
                map.put("label3", rs.getString(3));
                map.put("label4", rs.getString(4));
                map.put("label5", rs.getString(5));
            }
            return map;
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return map;
    }
}
