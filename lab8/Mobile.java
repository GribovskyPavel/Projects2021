package by.bsu.lab8;

public interface Mobile{
    String toString();
    int hashCode();
    boolean equals(Object o);
    void start();
    void finish();
    void connectWithDatabase();
    void connectWithComputer();
    void connectWithNetwork();
    void disConnectWithDatabase();
    void disConnectWithComputer();
    void disConnectWithNetwork();
    String currentStatus();
    void exportData(Object o);
    boolean isViruses();
}
