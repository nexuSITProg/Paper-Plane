package gui.controllers;

import db.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Time;
import java.util.Date;
import java.util.ResourceBundle;

public class TabPaneController implements Initializable {
    // Passenger data
    private static ObservableList<Passenger> passengersData = FXCollections.observableArrayList();
    @FXML private TableColumn<Passenger, Integer> passangerId;
    @FXML private TableColumn<Passenger, Integer> passportSeries;
    @FXML private TableColumn<Passenger, Integer> passportNumber;
    @FXML private TableColumn<Passenger, String> secondName;
    @FXML private TableColumn<Passenger, String> firstName;
    @FXML private TableColumn<Passenger, String> lastName;
    @FXML private TableColumn<Passenger, String> address;
    @FXML private TableColumn<Passenger, String> phone;
    @FXML private TableColumn<Passenger, Integer> raceId;
    @FXML private TableView<Passenger> Passengers;

    // Path data
    private static ObservableList<Path> pathData = FXCollections.observableArrayList();
    @FXML private TableColumn<Path, Integer> parentPathId;
    @FXML private TableColumn<Path, Integer> pathNumber;
    @FXML private TableColumn<Path, String> departureAirport;
    @FXML private TableColumn<Path, String> destinationAirport;
    @FXML private TableColumn<Path, Integer> ticketPrice;
    @FXML private TableColumn<Path, Time> flightTime;
    @FXML private TableView<Path> Paths;

    // Race data
    private static ObservableList<Race> raceData = FXCollections.observableArrayList();
    @FXML private TableColumn<Race, Integer> parentRaceId;
    @FXML private TableColumn<Race, Integer> raceNumber;
    @FXML private TableColumn<Race, Date> departureDate;
    @FXML private TableColumn<Race, Date> departureTime;
    @FXML private TableColumn<Race, Byte> raceStatus;
    @FXML private TableColumn<Race, Integer> pathId;
    @FXML private TableView<Race> Races;

    // Plane data
    private static ObservableList<Plane> planeData = FXCollections.observableArrayList();
    @FXML private TableColumn<Plane, Integer> planeId;
    @FXML private TableColumn<Plane, String> planeModel;
    @FXML private TableColumn<Plane, Date> manufactureDate;
    @FXML private TableColumn<Plane, Time> exploitationTime;
    @FXML private TableColumn<Plane, Byte> readyToFlight;
    @FXML private TableColumn<Plane, Integer> planeRaceId;
    @FXML private TableView<Plane> Planes;

    // Init
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initData();
        // Passenger columns
        passangerId.setCellValueFactory(new PropertyValueFactory<Passenger, Integer>("id"));
        passportSeries.setCellValueFactory(new PropertyValueFactory<Passenger, Integer>("passportSeries"));
        passportNumber.setCellValueFactory(new PropertyValueFactory<Passenger, Integer>("passportNumber"));
        secondName.setCellValueFactory(new PropertyValueFactory<Passenger, String>("secondName"));
        firstName.setCellValueFactory(new PropertyValueFactory<Passenger, String>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<Passenger, String>("lastName"));
        address.setCellValueFactory(new PropertyValueFactory<Passenger, String>("address"));
        phone.setCellValueFactory(new PropertyValueFactory<Passenger, String>("phone"));
        raceId.setCellValueFactory(new PropertyValueFactory<Passenger, Integer>("raceId"));

        // Path columns
        parentPathId.setCellValueFactory(new PropertyValueFactory<Path, Integer>("pathId"));
        pathNumber.setCellValueFactory(new PropertyValueFactory<Path, Integer>("pathNumber"));
        departureAirport.setCellValueFactory(new PropertyValueFactory<Path, String>("departureAirport"));
        destinationAirport.setCellValueFactory(new PropertyValueFactory<Path, String>("destinationAirport"));
        ticketPrice.setCellValueFactory(new PropertyValueFactory<Path, Integer>("ticketPrice"));
        flightTime.setCellValueFactory(new PropertyValueFactory<Path, Time>("flightTime"));

        // Race columns
        parentRaceId.setCellValueFactory(new PropertyValueFactory<Race, Integer>("raceId"));
        raceNumber.setCellValueFactory(new PropertyValueFactory<Race, Integer>("raceNumber"));
        departureDate.setCellValueFactory(new PropertyValueFactory<Race, Date>("departureDate"));
        departureTime.setCellValueFactory(new PropertyValueFactory<Race, Date>("departureTime"));
        raceStatus.setCellValueFactory(new PropertyValueFactory<Race, Byte>("raceStatus"));
        pathId.setCellValueFactory(new PropertyValueFactory<Race, Integer>("pathId"));

        // Plane columns
        planeId.setCellValueFactory(new PropertyValueFactory<Plane, Integer>("planeId"));
        planeModel.setCellValueFactory(new PropertyValueFactory<Plane, String>("planeModel"));
        manufactureDate.setCellValueFactory(new PropertyValueFactory<Plane, Date>("manufactureDate"));
        exploitationTime.setCellValueFactory(new PropertyValueFactory<Plane, Time>("exploitationTime"));
        readyToFlight.setCellValueFactory(new PropertyValueFactory<Plane, Byte>("readyToFlight"));
        planeRaceId.setCellValueFactory(new PropertyValueFactory<Plane, Integer>("raceId"));


        // заполняем таблицу данными
        Passengers.setItems(passengersData);
        Paths.setItems(pathData);
        Races.setItems(raceData);
        Planes.setItems(planeData);
    }

    // Init data
    private void initData() {
        // Passengers
        var passengerCRUD = new PassengerCRUD();
        var passengers = passengerCRUD.getPassengers();
        passengersData.addAll(passengers);

        // Paths
        var pathCRUD = new PathCRUD();
        var paths = pathCRUD.getPaths();
        pathData.addAll(paths);

        // Races
        var raceCRUD = new RaceCRUD();
        var races = raceCRUD.getRaces();
        raceData.addAll(races);

        // Planes
        var planeCRUD = new PlaneCRUD();
        var planes = planeCRUD.getPlanes();
        planeData.addAll(planes);
    }

}