package by.bsu.mmf.Lab4.PartA;

import java.util.Objects;

public class Island {
    private Islands nameIsland;
    private String name;
    private final int NUMBER = 10;

    public Island() {
        int flag = (int)(Math.random()*NUMBER);
        switch (flag) {
            case 0:{
                nameIsland = Islands.GREENLAND;
                name = "GREENLAND";
            } break;
            case 1:{
                nameIsland = Islands.BAFFIN_ISLAND;
                name = "BAFFIN_ISLAND";
            } break;
            case 2:{
                nameIsland = Islands.VICTORIA_ISLAND;
                name = "VICTORIA_ISLAND";
            } break;
            case 3:{
                nameIsland = Islands.BORNEO;
                name = "BORNEO";
            } break;
            case 4:{
                nameIsland = Islands.SUMATRA;
                name = "SUMATRA";
            } break;
            case 5:{
                nameIsland = Islands.GREAT_BRITAIN;
                name = "GREAT_BRITAIN";
            } break;
            case 6:{
                nameIsland = Islands.HONSHU;
                name = "HONSHU";
            } break;
            case 7:{
                nameIsland = Islands.MADAGASCAR;
                name = "MADAGASCAR";
            } break;
            case 8:{
                nameIsland = Islands.NEWFOUNDLAND;
                name = "NEWFOUNDLAND";
            } break;
            case 9:{
                nameIsland = Islands.NEW_GUINEA;
                name = "NEW_GUINEA";
            } break;
        }
    }
    public Island(int i) {
        switch (i) {
            case 0:{
                nameIsland = Islands.GREENLAND;
                name = "GREENLAND";
            } break;
            case 1:{
                nameIsland = Islands.BAFFIN_ISLAND;
                name = "BAFFIN_ISLAND";
            } break;
            case 2:{
                nameIsland = Islands.VICTORIA_ISLAND;
                name = "VICTORIA_ISLAND";
            } break;
            case 3:{
                nameIsland = Islands.BORNEO;
                name = "BORNEO";
            } break;
            case 4:{
                nameIsland = Islands.SUMATRA;
                name = "SUMATRA";
            } break;
            case 5:{
                nameIsland = Islands.GREAT_BRITAIN;
                name = "GREAT_BRITAIN";
            } break;
            case 6:{
                nameIsland = Islands.HONSHU;
                name = "HONSHU";
            } break;
            case 7:{
                nameIsland = Islands.MADAGASCAR;
                name = "MADAGASCAR";
            } break;
            case 8:{
                nameIsland = Islands.NEWFOUNDLAND;
                name = "NEWFOUNDLAND";
            } break;
            case 9:{
                nameIsland = Islands.NEW_GUINEA;
                name = "NEW_GUINEA";
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
        return "Island{" +
                "nameIsland=" + nameIsland +
                ", name='" + name + '\'' +
                ", NUMBER=" + NUMBER +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Island island = (Island) o;
        return  name.equals(island.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameIsland);
    }
}
