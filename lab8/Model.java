package by.bsu.lab8;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Model extends SiemensMobile{
    private boolean isWork;
    private boolean isDataBase;
    private boolean isComputer;
    private boolean isNetwork;
    private boolean isViruses;
    private final ArrayList<String> Statuses;
    private String status;
    private Object object;

    public Model() {
        this.isWork = false;
        this.isDataBase = false;
        this.isComputer = false;
        this.isNetwork = false;
        this.isViruses = false;
        Statuses = new ArrayList<>();
        Statuses.add("Waiting");
        Statuses.add("Starting");
        Statuses.add("Updating");
        Statuses.add("Connecting");
        Statuses.add("Loading");
        Statuses.add("Finishing");
        this.status = Statuses.get(0);
        this.object = null;
    }

    @Override
    public String toString() {
        return "Model{" +
                "Siemens mobile version=" + version +
                ", isWork=" + isWork +
                ", isDataBase=" + isDataBase +
                ", isComputer=" + isComputer +
                ", isNetwork=" + isNetwork +
                ", isViruses=" + isViruses +
                ", status='" + status + '\'' +
                ", object=" + object +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return isWork == model.isWork && isDataBase == model.isDataBase && isComputer == model.isComputer && isNetwork == model.isNetwork && isViruses == model.isViruses && status.equals(model.status) && object.equals(model.object);
    }
    @Override
    public int hashCode() {
        return Objects.hash(isWork, isDataBase, isComputer, isNetwork, isViruses, Statuses, status, object);
    }

    @Override
    public void start() {
        System.out.println("Starting the work of the device...");
        this.isWork = true;
    }
    @Override
    public void finish() {
        System.out.println("Finishing the work of the device...");
        this.isWork = false;
    }
    @Override
    public void connectWithDatabase() {
        this.isDataBase = true;
        System.out.println("Connecting with DataBase...");
    }
    @Override
    public void connectWithComputer() {
        this.isComputer = true;
        System.out.println("Connecting with computer...");
    }
    @Override
    public void connectWithNetwork() {
        this.isNetwork = true;
        System.out.println("Connecting with network...");
    }
    @Override
    public void disConnectWithDatabase() {
        this.isDataBase = false;
        System.out.println("Disconnecting from DataBase...");
    }
    @Override
    public void disConnectWithComputer() {
        this.isComputer = false;
        System.out.println("Disconnecting from computer...");
    }
    @Override
    public void disConnectWithNetwork() {
        this.isNetwork = false;
        System.out.println("Disconnecting from network...");
    }
    @Override
    public String currentStatus() {
        return this.status;
    }
    @Override
    public void exportData(Object o) {
        this.object = o;
    }
    @Override
    public boolean isViruses() {
        return isViruses;
    }

    public void setViruses(boolean viruses) {
        isViruses = viruses;
    }
    public void setStatus(Scanner sc) {
        System.out.print("""
                --- Choosing the mobile status ---
                Enter 1 - "Waiting"
                Enter 2 - "Starting"
                Enter 3 - "Updating"
                Enter 4 - "Connecting"
                Enter 5 - "Loading"
                Enter 6 - "Finishing"
                """);
        System.out.print("Enter here: ");
        String flag = sc.next();
        switch (flag) {
            case "1" -> status = this.Statuses.get(0);
            case "2" -> status = this.Statuses.get(1);
            case "3" -> status = this.Statuses.get(2);
            case "4" -> status = this.Statuses.get(3);
            case "5" -> status = this.Statuses.get(4);
            case "6" -> status = this.Statuses.get(5);
            default -> System.out.println("You entered something wrong!");
        }
    }
}
