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
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado no banco " + url);
            String query = "INSERT INTO empresa values (null, 'Empresa You', '12.332.112/3321-33', '12345678', 'SP','São Paulo', 'Rua', 'gustavo@asda.com', '123321', '12345678901');";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataBaseModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String makeSelectQuery(String query) {
        String valida = null;
        try (Connection connection = DriverManager.getConnection(url, user, password); Statement statement = connection.createStatement();) {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                valida = rs.getString(1);
                System.out.println(rs.getString(1));
                /* map.put("label1", rs.getString(1));
                map.put("label2", rs.getString(2));
                map.put("label3", rs.getString(3));
                map.put("label3", rs.getString(3));
                map.put("label3", rs.getString(3));
                 */
            }
            return valida;
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return valida;
    }
}
