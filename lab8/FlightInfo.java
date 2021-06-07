package by.bsu.lab8;
//     +  1) получить или изменить различную
//        информацию о рейсе: номер рейса, пункт назначения, марка судна,
//        статус судна (загрузка, разгрузка, заправка, в пути, в ремонте,
//        готов к вылету, требуется ремонт);
//        2) узнать среднее время рейса;
//        3) узнать снаряженную массу;
//        4) узнать количество топлива;
//        10) узнать хрупкость/ценность груза

import java.util.ArrayList;
import java.util.Objects;

public class FlightInfo implements Flight{
    private int numberOfFlight;
    private String destination;
    private String brand;
    private ArrayList<String> status;
    private final int averageTimeOfFlight;
    private final double mass;
    private final int fuelStatus;
    private final double costCargo;

    public FlightInfo(){
        this.numberOfFlight = 0;
        this.destination = null;
        this.brand = null;
        this.averageTimeOfFlight = 0;
        this.mass = 0;
        this.fuelStatus = 0;
        this.costCargo = 0;
        this.status = new ArrayList<>();
        status.add("Loading");
        status.add("Uploading");
        status.add("Refueling");
        status.add("En route");
        status.add("Under repair");
        status.add("Ready for departure");
        status.add("Repairs required");
    }
    public FlightInfo(int numberOfFlight, String destination, String brand, int averageTimeOfFlight, double mass, int fuelStatus, double costCargo){
        this.numberOfFlight = numberOfFlight;
        this.destination = destination;
        this.brand = brand;
        this.averageTimeOfFlight = averageTimeOfFlight;
        this.mass = mass;
        this.fuelStatus = fuelStatus;
        this.costCargo = costCargo;
    }

    @Override
    public void setNumberOfFlight(int numberOfFlight) {
        this.numberOfFlight = numberOfFlight;
    }
    @Override
    public void setDestination(String destination) {
        this.destination = destination;
    }
    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }
    @Override
    public void setStatus(ArrayList<String> status) {
        this.status = status;
    }

    @Override
    public int getNumberOfFlight() {
        return numberOfFlight;
    }
    @Override
    public String getDestination() {
        return destination;
    }
    @Override
    public String getBrand() {
        return brand;
    }
    @Override
    public ArrayList<String> getStatus() {
        return status;
    }

    @Override
    public int getAverageTime() {
        return averageTimeOfFlight;
    }
    @Override
    public double getMass() {
        return mass;
    }
    @Override
    public int getFuelStatus() {
        return fuelStatus;
    }
    @Override
    public double getCostCargo() {
        return costCargo;
    }

    @Override
    public String toString() {
        return "FlightInfo{" +
                "numberOfFlight=" + numberOfFlight +
                ", destination='" + destination + '\'' +
                ", brand='" + brand + '\'' +
                ", status=" + status +
                ", averageTimeOfFlight=" + averageTimeOfFlight +
                ", mass=" + mass +
                ", fuelStatus=" + fuelStatus +
                ", costCargo=" + costCargo +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightInfo that = (FlightInfo) o;
        return numberOfFlight == that.numberOfFlight && averageTimeOfFlight == that.averageTimeOfFlight && Double.compare(that.mass, mass) == 0 && fuelStatus == that.fuelStatus && Double.compare(that.costCargo, costCargo) == 0 && destination.equals(that.destination) && brand.equals(that.brand) && status.equals(that.status);
    }
    @Override
    public int hashCode() {
        return Objects.hash(numberOfFlight, destination, brand, status, averageTimeOfFlight, mass, fuelStatus, costCargo);
    }

    @Override
    public void setDestinationBool(boolean destinationBool) {

    }
    @Override
    public void setRepairBool(boolean repairBool) {

    }
    @Override
    public void setFuelBool(boolean fuelBool) {

    }
    @Override
    public void setLoadBool(boolean loadBool) {

    }
    @Override
    public void setUploadBoll(boolean uploadBoll) {

    }
    @Override
    public void PassengersOrFreight() {

    }
}
