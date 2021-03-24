package by.bsu.mmf.Lab4.PartA;

import java.util.Objects;

public class Ocean {
    private Oceans nameOcean;
    private String name;
    private final int NUMBER = 4;

    public Ocean() {
        int flag = (int)(Math.random()*NUMBER);
        switch (flag) {
            case 0:{
                nameOcean = Oceans.ATLANTIC;
                name = "ATLANTIC";
            } break;
            case 1:{
                nameOcean = Oceans.INDIAN;
                name = "INDIAN";
            } break;
            case 2:{
                nameOcean = Oceans.NORTH_ARCTIC;
                name = "NORTH_ARCTIC";
            } break;
            case 3:{
                nameOcean = Oceans.PACIFIC;
                name = "PACIFIC";
            } break;
        }
    }
    public Ocean(int i) {
        switch (i) {
            case 0:{
                nameOcean = Oceans.ATLANTIC;
                name = "ATLANTIC";
            } break;
            case 1:{
                nameOcean = Oceans.INDIAN;
                name = "INDIAN";
            } break;
            case 2:{
                nameOcean = Oceans.NORTH_ARCTIC;
                name = "NORTH_ARCTIC";
            } break;
            case 3:{
                nameOcean = Oceans.PACIFIC;
                name = "PACIFIC";
            } break;
        }
    }
    
    public String getName() {
        return name;
    }

    public int getNUMBER() {
        return NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ocean ocean = (Ocean) o;
        return  name.equals(ocean.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOcean);
    }

    @Override
    public String toString() {
        return "Ocean{" +
                "nameOcean=" + nameOcean +
                ", name='" + name + '\'' +
                ", NUMBER=" + NUMBER +
                '}';
    }
}
