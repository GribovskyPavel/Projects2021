package by.bsu.mmf.Lab4.PartA;

import java.util.Objects;

public class Mainland {
    private Mainlands nameMainland;
    private String name;
    private final int NUMBER = 6;

    public Mainland() {
        int flag = (int)(Math.random()*NUMBER);
        switch (flag) {
            case 0:{
                nameMainland = Mainlands.AFRICA;
                name = "AFRICA";
            } break;
            case 1:{
                nameMainland = Mainlands.ANTARCTICA;
                name = "ANTARCTICA";
            } break;
            case 2:{
                nameMainland = Mainlands.NORTH_AMERICA;
                name = "NORTH_AMERICA";
            } break;
            case 3:{
                nameMainland = Mainlands.SOUTH_AMERICA;
                name = "SOUTH_AMERICA";
            } break;
            case 4:{
                nameMainland = Mainlands.AUSTRALIA;
                name = "AUSTRALIA";
            } break;
            case 5:{
                nameMainland = Mainlands.EURASIA;
                name = "EURASIA";
            } break;
        }
    }
    public Mainland(int i) {
        switch (i) {
            case 0:{
                nameMainland = Mainlands.AFRICA;
                name = "AFRICA";
            } break;
            case 1:{
                nameMainland = Mainlands.ANTARCTICA;
                name = "ANTARCTICA";
            } break;
            case 2:{
                nameMainland = Mainlands.NORTH_AMERICA;
                name = "NORTH_AMERICA";
            } break;
            case 3:{
                nameMainland = Mainlands.SOUTH_AMERICA;
                name = "SOUTH_AMERICA";
            } break;
            case 4:{
                nameMainland = Mainlands.AUSTRALIA;
                name = "AUSTRALIA";
            } break;
            case 5:{
                nameMainland = Mainlands.EURASIA;
                name = "EURASIA";
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
    public String toString() {
        return "Mainland{" +
                "nameMainland=" + nameMainland +
                ", name='" + name + '\'' +
                ", NUMBER=" + NUMBER +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mainland mainland = (Mainland) o;
        return name.equals(mainland.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameMainland);
    }
}
