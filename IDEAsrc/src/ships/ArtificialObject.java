package src.ships;

import src.locations.*;
import src.util.*;

import java.util.Arrays;

public abstract class ArtificialObject {
    private final String ARTIFICIAL_OBJECT_NAME;
    private Fraction operatedBy;
    private int shipHP;
    private final int TORPEDO_DAMAGE;
    private Location currentLocation;
    private final int BULLET_DAMAGE;

    public ArtificialObject(String artObjectName, Fraction operator, Location location, int shipHP) {
        ARTIFICIAL_OBJECT_NAME = artObjectName;
        operatedBy = operator;
        currentLocation = location;
        this.shipHP = shipHP;
        operatedBy.addFractionShip(this);
        BULLET_DAMAGE = 1;
        TORPEDO_DAMAGE = 1000;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    protected void setCurrentLocation(Location currentLocation) {
        this.currentLocation.removeShip(this);
        this.currentLocation = currentLocation;
        currentLocation.addShips(this);
    }

    private void getDamage(int damage) {
        shipHP = shipHP - damage;
        if (shipHP <= 0){
            this.blowUp();
        }
    }

    public void getTorpedoes(int torpedoesHit) {
        getDamage(torpedoesHit * TORPEDO_DAMAGE);
    }

    protected void blowUp() {
    }

    public void setOperator(Fraction newFraction) {
        operatedBy.removeFractionShip(this);
        operatedBy = newFraction;
        newFraction.addFractionShip(this);
    }

    public Fraction getOperatedBy() {
        return operatedBy;
    }

    public String getArtificialObjectName() {
        return ARTIFICIAL_OBJECT_NAME;
    }

    public void getBullets(int bulletsHit) {
        this.getDamage(BULLET_DAMAGE * bulletsHit);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass() || obj.hashCode() != this.hashCode()){
            return false;
        }

        ArtificialObject someObject = (ArtificialObject) obj;

        return (ARTIFICIAL_OBJECT_NAME != null && ARTIFICIAL_OBJECT_NAME.equals(someObject.ARTIFICIAL_OBJECT_NAME))
                && (currentLocation != null && currentLocation.equals(someObject.currentLocation))
                && (operatedBy != null && operatedBy.equals(someObject.operatedBy))
                && (shipHP == someObject.shipHP)
                && (TORPEDO_DAMAGE == someObject.TORPEDO_DAMAGE)
                && (BULLET_DAMAGE == someObject.BULLET_DAMAGE);
    }

    @Override
    public int hashCode() {
        Object[] vars = {ARTIFICIAL_OBJECT_NAME, currentLocation, operatedBy, shipHP, TORPEDO_DAMAGE, BULLET_DAMAGE};
        return Arrays.hashCode(vars);
    }

    @Override
    public String toString() {
        return "ArtificialObject{" +
                "ARTIFICIAL_OBJECT_NAME='" + ARTIFICIAL_OBJECT_NAME + '\'' +
                ", operatedBy=" + operatedBy +
                ", shipHP=" + shipHP +
                ", TORPEDO_DAMAGE=" + TORPEDO_DAMAGE +
                ", currentLocation=" + currentLocation +
                ", BULLET_DAMAGE=" + BULLET_DAMAGE +
                '}';
    }
}
