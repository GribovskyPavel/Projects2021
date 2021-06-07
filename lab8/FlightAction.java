package by.bsu.lab8;
//      + 5) отправить в пункт назначения;
//        6) отремонтировать;
//        7) заправить;
//        8) загрузить;
//        9) разгрузить;

import java.util.ArrayList;
import java.util.Objects;

public class FlightAction implements Flight{
    private boolean destinationBool;
    private boolean repairBool;
    private boolean fuelBool;
    private boolean loadBool;
    private boolean uploadBoll;
    private boolean passengers;

    public FlightAction(boolean destinationBool, boolean repairBool, boolean fuelBool, boolean loadBool, boolean uploadBoll, boolean passengers) {
        this.destinationBool = destinationBool;
        this.repairBool = repairBool;
        this.fuelBool = fuelBool;
        this.loadBool = loadBool;
        this.uploadBoll = uploadBoll;
        this.passengers = passengers;
    }

    @Override
    public void setDestinationBool(boolean destinationBool) {
        this.destinationBool = destinationBool;
    }
    @Override
    public void setRepairBool(boolean repairBool) {
        this.repairBool = repairBool;
    }
    @Override
    public void setFuelBool(boolean fuelBool) {
        this.fuelBool = fuelBool;
    }
    @Override
    public void setLoadBool(boolean loadBool) {
        this.loadBool = loadBool;
    }
    @Override
    public void setUploadBoll(boolean uploadBoll) {
        this.uploadBoll = uploadBoll;
    }
    @Override
    public void PassengersOrFreight() {
        System.out.println(passengers ? "This is passenger ship" : "This is freight ship");
    }

    @Override
    public String toString() {
        return "FlightAction{" +
                "destinationBool=" + destinationBool +
                ", repairBool=" + repairBool +
                ", fuelBool=" + fuelBool +
                ", loadBool=" + loadBool +
                ", uploadBoll=" + uploadBoll +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightAction that = (FlightAction) o;
        return destinationBool == that.destinationBool && repairBool == that.repairBool && fuelBool == that.fuelBool && loadBool == that.loadBool && uploadBoll == that.uploadBoll;
    }
    @Override
    public int hashCode() {
        return Objects.hash(destinationBool, repairBool, fuelBool, loadBool, uploadBoll);
    }

    @Override
    public void setNumberOfFlight(int numberOfFlight) {

    }
    @Override
    public void setDestination(String destination) {

    }
    @Override
    public void setBrand(String brand) {

    }
    @Override
    public void setStatus(ArrayList<String> status) {

    }
    @Override
    public int getNumberOfFlight() {
        return 0;
    }
    @Override
    public String getDestination() {
        return null;
    }
    @Override
    public String getBrand() {
        return null;
    }
    @Override
    public ArrayList<String> getStatus() {
        return null;
    }
    @Override
    public int getAverageTime() {
        return 0;
    }
    @Override
    public double getMass() {
        return 0;
    }
    @Override
    public int getFuelStatus() {
        return 0;
    }
    @Override
    public double getCostCargo() {
        return 0;
    }
}
