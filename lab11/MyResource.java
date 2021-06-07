package by.bsu.lab11;
import java.util.Objects;

public class MyResource {
    private String busStation;
    private int bound;
    private int current;

    public MyResource(String busStation, int bound){
        this.bound = bound;
        this.busStation = busStation;
    }

    public int getBound() {
        return bound;
    }
    public void setBound(int bound) {
        this.bound = bound;
    }

    public String getBusStation() {
        return busStation;
    }
    public void setBusStation(String busStation) {
        this.busStation = busStation;
    }

    public int getCurrent() {
        return current;
    }
    public void setCurrent(int current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return "MyResource{" +
                "busStation='" + busStation + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyResource that = (MyResource) o;
        return Objects.equals(busStation, that.busStation);
    }
    @Override
    public int hashCode() {
        return Objects.hash(busStation);
    }
}
