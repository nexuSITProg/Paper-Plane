package gui.controllers;

import db.Passenger;
import db.PassengerCRUD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initData();
        // устанавливаем тип и значение которое должно хранится в колонке
        passangerId.setCellValueFactory(new PropertyValueFactory<Passenger, Integer>("id"));
        passportSeries.setCellValueFactory(new PropertyValueFactory<Passenger, Integer>("passportSeries"));
        passportNumber.setCellValueFactory(new PropertyValueFactory<Passenger, Integer>("passportNumber"));
        secondName.setCellValueFactory(new PropertyValueFactory<Passenger, String>("secondName"));
        firstName.setCellValueFactory(new PropertyValueFactory<Passenger, String>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<Passenger, String>("lastName"));
        address.setCellValueFactory(new PropertyValueFactory<Passenger, String>("address"));
        phone.setCellValueFactory(new PropertyValueFactory<Passenger, String>("phone"));
        raceId.setCellValueFactory(new PropertyValueFactory<Passenger, Integer>("raceId"));
        // заполняем таблицу данными
        Passengers.setItems(passengersData);
    }

    private void initData() {
        var passengerCRUD = new PassengerCRUD();
        var passengers = passengerCRUD.getPassengers();
        passengersData.addAll(passengers);
    }

}
