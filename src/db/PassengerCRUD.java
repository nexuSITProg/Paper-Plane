package db;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PassengerCRUD implements CRUD {
    private ArrayList<Passenger> passengers = getPassengers();
    public ArrayList<Passenger> getPassengers() {
        Connection connection = DBMaster.getConnection();
        ArrayList<Passenger> passengers = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery( "select * from passenger");

            while (resultSet.next()) {
                var id = resultSet.getInt("passenger_id");
                var passportSeries = resultSet.getInt("passport_series");
                var passportNumber = resultSet.getInt("passport_number");
                var secondName = resultSet.getString("second_name");
                var firstName = resultSet.getString("first_name");
                var lastName = resultSet.getString("last_name");
                var address = resultSet.getString("address");
                var phone = resultSet.getString("phone");
                var race_id = resultSet.getInt("race_id");

                Passenger passenger = new Passenger();
                passenger.setId(id);
                passenger.setPassportSeries(passportSeries);
                passenger.setPassportNumber(passportNumber);
                passenger.setSecondName(secondName);
                passenger.setFirstName(firstName);
                passenger.setLastName(lastName);
                passenger.setAddress(address);
                passenger.setPhone(phone);
                passenger.setRaceId(race_id);

                passengers.add(passenger);
            }

        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }

        DBMaster.closeConnection();
        return passengers;
    }

    @Override
    public void create(String tableName, String columnName, String values) {
        Connection connection = DBMaster.getConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(Queries.sqlInsertInto(tableName, columnName, values));
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String tableName, String condition) {
        Connection connection = DBMaster.getConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(Queries.sqlDelete(tableName, condition));
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String tableName, String modify, String condition) {
        Connection connection = DBMaster.getConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(Queries.sqlUpdate(tableName, modify, condition));
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printPassengersToConsole() {
        for (int i = 0; i < passengers.size(); i++) {
            System.out.println(passengers.get(i).toString() + "\n");
        }
    }
}
