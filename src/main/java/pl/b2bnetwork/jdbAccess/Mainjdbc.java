package pl.b2bnetwork.jdbAccess;

import java.sql.*;

public class Mainjdbc {


    private static final String ROOT = "root";
    private static final String PASSWORD = "tajne";
    private static final String URL = "jdbc:mysql://localhost:3306/8thmay";

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, ROOT, PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select p.name, p.engine_id, e.name from part p, engine e");

        while (resultSet.next()){
            String string = resultSet.getString("year_producion");
            System.out.println(string);
        }
    }
}



