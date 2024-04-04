package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RaceCRUD implements CRUD {

    public ArrayList<Race> getRaces() {
        Connection connection = DBMaster.getConnection();
        ArrayList<Race> races = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery( "select * from path");

            while (resultSet.next()) {
                Race race = new Race();
                var id = resultSet.getInt("race_id");
                var raceNumber = resultSet.getInt("race_number");
                var departureDate = resultSet.getDate("departure_date");
                var departureTime = resultSet.getDate("departure_time");
                var raceStatus = resultSet.getByte("race_status");
                var pathId = resultSet.getInt("path_id");

                race.setRaceId(id);
                race.setRaceNumber(raceNumber);
                race.setDepartureDate(departureDate);
                race.setDepartureTime(departureTime);
                race.setRaceStatus(raceStatus);
                race.setRaceId(pathId);

                races.add(race);
            }

        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }

        DBMaster.closeConnection();
        return races;
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
}