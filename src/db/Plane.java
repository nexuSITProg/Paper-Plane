package db;

import java.sql.Date;
import java.sql.Time;
import java.time.Year;

public class Plane {
    private int planeId;
    private String planeModel;
    private Date manufactureDate;
    private Time exploitationTime;
    private byte readyToFlight;
    private int raceId;

    public int getPlaneId() {
        return planeId;
    }

    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }

    public String getPlaneModel() {
        return planeModel;
    }

    public void setPlaneModel(String planeModel) {
        this.planeModel = planeModel;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Time getExploitationTime() {
        return exploitationTime;
    }

    public void setExploitationTime(Time exploitationTime) {
        this.exploitationTime = exploitationTime;
    }

    public byte getReadyToFlight() {
        return readyToFlight;
    }

    public void setReadyToFlight(byte readyToFlight) {
        this.readyToFlight = readyToFlight;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    @Override
    public String toString() {
        return "Plane " + planeId + ": {\n" +
                "plane model: " + planeModel + "\n" +
                "manufacture date: " + manufactureDate + "\n" +
                "exploitation time: " + exploitationTime + "\n" +
                "ready to flight: " + (readyToFlight == 1 ? "Yes" : "No") + "\n" +
                "race: " + raceId + "\n}";
    }
}
