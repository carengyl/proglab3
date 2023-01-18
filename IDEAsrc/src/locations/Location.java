package src.locations;

import src.util.*;
import src.ships.*;

import java.util.ArrayList;

public abstract class Location implements Stationary {
    private final String OBJECT_NAME;
    private final boolean root;
    private final Location superLocation;
    private final ArrayList<Location> subLocations;
    private final Fraction protectorate;
    private final ArrayList<ArtificialObject> shipsNearBy;

    public Location(String spaceObjectName, Fraction protectorate, Location superLocation) {
        root = false;
        this.superLocation = superLocation;
        this.superLocation.addSubLocation(this);
        this.OBJECT_NAME = spaceObjectName;
        this.protectorate = protectorate;
        this.protectorate.addFractionLocation(this);
        shipsNearBy = new ArrayList<>();
        subLocations = new ArrayList<>();
    }

    public Location() {
        root = true;
        superLocation = null;
        OBJECT_NAME = "Измерение";
        protectorate = Fraction.INDEPENDENT;
        protectorate.addFractionLocation(this);
        shipsNearBy = null;
        subLocations = new ArrayList<>();
    }

    public boolean isRoot() {
        return root;
    }

    public void addShips(ArtificialObject ship){
        shipsNearBy.add(ship);
    }

    @Override
    public void addSubLocation(Location location) {
        subLocations.add(location);
    }

    @Override
    public ArrayList<Location> getSubLocations() {
        return subLocations;
    }

    public ArrayList<ArtificialObject> getShipsNearBy() {
        return shipsNearBy;
    }

    public String getSpaceObjectName() {
        return this.OBJECT_NAME;
    }

    public Location getSuperLocation() {
        return superLocation;
    }

    public void removeShip(ArtificialObject ship) {
        shipsNearBy.remove(ship);
    }

    public Fraction getProtectorate() {
        return protectorate;
    }
}
