import db.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        PassengerCRUD ps = new PassengerCRUD();

        ps.printPassengersToConsole();
    }
}