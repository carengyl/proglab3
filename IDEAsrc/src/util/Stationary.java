package src.util;

import src.locations.Location;

import java.util.ArrayList;

public interface Stationary {
    Location getSuperLocation();
    void addSubLocation(Location location);
    ArrayList<Location> getSubLocations();
}
