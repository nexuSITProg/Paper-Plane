package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Year;
import java.util.ArrayList;

public class PlaneCRUD implements CRUD {

    public ArrayList<Plane> getPlanes() {
        Connection connection = DBMaster.getConnection();
        ArrayList<Plane> planes = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery( "select * from path");

            while (resultSet.next()) {
                Plane plane = new Plane();
                var id = resultSet.getInt("plane_id");
                var planeModel = resultSet.getString("plane_model");
                var manufactureDate = resultSet.getDate("manufacture_date");
                var exploitationTime = resultSet.getTime("exploitation_time");
                var readyToFlight = resultSet.getByte("ready_to_flight");
                var raceId = resultSet.getInt("race_id");

                plane.setPlaneId(id);
                plane.setPlaneModel(planeModel);
                plane.setManufactureDate(manufactureDate);
                plane.setExploitationTime(exploitationTime);
                plane.setReadyToFlight(readyToFlight);
                plane.setRaceId(raceId);

                planes.add(plane);
            }

        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }

        DBMaster.closeConnection();
        return planes;
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
