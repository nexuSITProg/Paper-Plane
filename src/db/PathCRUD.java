package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PathCRUD implements CRUD {

    private ArrayList<Path> paths = getPaths();

    public ArrayList<Path> getPaths() {
        Connection connection = DBMaster.getConnection();
        ArrayList<Path> paths = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery( "select * from path");

            while (resultSet.next()) {
                Path path = new Path();
                var id = resultSet.getInt("path_id");
                var pathNumber = resultSet.getInt("path_number");
                var departureAirport = resultSet.getString("departure_airport");
                var destinationAirport = resultSet.getString("destination_airport");
                var ticketPrice = resultSet.getInt("ticket_price");
                var fligthTime = resultSet.getTime("flight_time");

                path.setPathId(id);
                path.setPathNumber(pathNumber);
                path.setDepartureAirport(departureAirport);
                path.setDestinationAirport(destinationAirport);
                path.setTicketPrice(ticketPrice);
                path.setFlightTime(fligthTime);

                paths.add(path);
            }

        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }

        DBMaster.closeConnection();
        return paths;
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

    public void printPathToConsole() {
        for (int i = 0; i < paths.size(); i++) {
            System.out.println(paths.get(i).toString() + "\n");
        }
    }
}
