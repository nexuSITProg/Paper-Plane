package db;

import java.sql.*;

public class DBMaster {
    // Поля класса описывающие пользователя бд и её тип
    private static final String URL = "jdbc:mysql://localhost:3306/flight_db";
    private static final String USER = "root";
    private static final String PASSWORD = "as12ASd41lwqm13";

    // Поля класса для подключения к базе данных
    private static Connection connection;

    // Метод устанавливающий соединение к базе данных
    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection online");
            return connection;
        } catch (Exception exception) { System.out.println(exception); }
        return null;
    }

    // Метод закрывающий соединение к базе данных
    public static void closeConnection() {
        try {
            connection.close();
            if (connection.isClosed()) { System.out.println("Connection is closed"); }
        } catch (SQLException sqlException) { System.out.println(sqlException); }
    }
}