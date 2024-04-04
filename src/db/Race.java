package db;

import java.sql.Date;

public class Race {
    private int raceId;
    private int raceNumber;
    private Date departureDate;
    private Date departureTime;
    private byte raceStatus;
    private int pathId;

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public int getRaceNumber() {
        return raceNumber;
    }

    public void setRaceNumber(int raceNumber) {
        this.raceNumber = raceNumber;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public byte getRaceStatus() {
        return raceStatus;
    }

    public void setRaceStatus(byte raceStatus) {
        this.raceStatus = raceStatus;
    }

    public int getPathId() {
        return pathId;
    }

    public void setPathId(int pathId) {
        this.pathId = pathId;
    }

    @Override
    public String toString() {
        return "Race " + raceId + " {\n" +
                "race number: " + raceNumber + "\n" +
                "departure date: " + departureDate + "\n" +
                "departure time: " + departureTime + "\n" +
                "race status: " + (raceStatus == 1 ? "Подтвержден" : "Снят") + "\n" +
                "path: " + pathId;
    }
}