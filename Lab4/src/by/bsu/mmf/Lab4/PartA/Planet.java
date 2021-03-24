package by.bsu.mmf.Lab4.PartA;

import java.util.Objects;

public class Planet{
    private final String namePlanet;
    private final Island island;
    private final Mainland mainland;
    private final Ocean ocean;

    public Planet(String namePlanet) {
        island = new Island();
        mainland = new Mainland();
        ocean = new Ocean();
        this.namePlanet = namePlanet;
    }
    public Planet(String namePlanet, int forIsland, int forMainland, int forOcean) {
        island = new Island(forIsland);
        mainland = new Mainland(forMainland);
        ocean = new Ocean(forOcean);
        this.namePlanet = namePlanet;
    }

    public String getNamePlanet() {
        return namePlanet;
    }

    @Override
    public String toString() {
        return "Planet {" +
                " namePlanet = '" + getNamePlanet() + '\'' +
                ", island = " + island.getName() +
                ", mainland = " + mainland.getName() +
                ", ocean = " + ocean.getName() +
                " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return namePlanet.equals(planet.namePlanet) && island.equals(planet.island) && mainland.equals(planet.mainland) && ocean.equals(planet.ocean);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namePlanet, island, mainland, ocean);
    }
}
