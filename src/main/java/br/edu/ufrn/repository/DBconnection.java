package br.edu.ufrn.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private static final String USER = "postgres";
    private static final String PASSWORD = "pharmacy";
    private static final String URL_DB = "jdbc:postgresql://localhost:5432/postgres";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DBconnection.URL_DB, DBconnection.USER, DBconnection.PASSWORD); // server password
            if (conn != null) {
                System.out.println("Connected to database #1");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return conn;
    }
}