package src.locations;

import src.ships.Ship;
import src.util.Fraction;

import java.util.ArrayList;

public class Moon extends Location {
    private final ArrayList<Ship> landedShips;
    public Moon(String moonName, Fraction moonFraction, Planet planet) {
        super(moonName, moonFraction, planet);
        landedShips = new ArrayList<>();
    }

    public void addLandedShip(Ship ship){
        landedShips.add(ship);
    }

    public void removeLandedShip(Ship ship) {
        landedShips.remove(ship);
    }
}
