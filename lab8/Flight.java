package by.bsu.lab8;
import java.util.ArrayList;

public interface Flight {
    void setNumberOfFlight(int numberOfFlight);
    void setDestination(String destination);
    void setBrand(String brand);
    void setStatus(ArrayList<String> status);

    int getNumberOfFlight();
    String getDestination();
    String getBrand();
    ArrayList<String> getStatus();

    int getAverageTime();
    double getMass();
    int getFuelStatus();
    double getCostCargo();

    void setDestinationBool(boolean destinationBool);
    void setRepairBool(boolean repairBool);
    void setFuelBool(boolean fuelBool);
    void setLoadBool(boolean loadBool);
    void setUploadBoll(boolean uploadBoll);
    void PassengersOrFreight();
}
