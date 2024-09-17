package src.ships;

import src.characters.*;
import src.locations.*;
import src.util.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Ship extends ArtificialObject implements NonStationary {
    private boolean landed;
    private boolean torpedoAlarm;
    private final ArrayList<Human> onBoard;
    private boolean maneuvering;
    private boolean remoteControl;

    public Ship(String shipName, Fraction operatorFraction, int shipHP, Location locationNearBy) {
        super(shipName, operatorFraction, locationNearBy, shipHP);
        locationNearBy.addShips(this);
        onBoard = new ArrayList<>();
        torpedoAlarm = false;
        landed = false;
    }

    public void deleteFromBoard(Human human){
        onBoard.remove(human);
    }

    public void addOnBoard(Human h) {
        onBoard.add(h);
    }

    public ArrayList<Human> getOnBoard() {
        return onBoard;
    }

    @Override
    public void flyTo(Location destination) {
        if (!landed &&
                (((!this.getCurrentLocation().getSuperLocation().isRoot()) && destination.equals(this.getCurrentLocation().getSuperLocation())) //перемещение вверх по иерархии
                    || this.getCurrentLocation().getSuperLocation().equals(destination.getSuperLocation()) //перемещение между "соседними" локациями
                    || this.getCurrentLocation().getSubLocations().contains(destination))) //перемещение вниз по иерархии
        {
            this.getCurrentLocation().removeShip(this);
            this.setCurrentLocation(destination);
            destination.addShips(this);
        }
    }

    public void landOnMoon(Moon moon){
        if (getCurrentLocation() instanceof Moon && this.getOperatedBy().equals(moon.getProtectorate())){
            landed = true;
            moon.addLandedShip(this);
            System.out.println(this.getArtificialObjectName() + " сел на луну " + this.getCurrentLocation().getSpaceObjectName());
        }
    }

    public void takeOff(){
        if (landed){
            landed = false;
            Moon landingPosition = (Moon) getCurrentLocation();
            landingPosition.removeLandedShip(this);
        }
    }

    @Override
    public void maneuver() {
        System.out.println("Корабль " + this.getArtificialObjectName() + " маневрирует");
        maneuvering = true;
    }

    public void stopManeuvering() {
        maneuvering = false;
    }

    public boolean isManeuvering() {
        return maneuvering;
    }

    public void setRemoteControl(boolean remoteControl) {
        this.remoteControl = remoteControl;
    }

    public void setTorpedoAlarm(boolean torpedoAlarm){
        this.torpedoAlarm = torpedoAlarm;
        if (torpedoAlarm){
            System.out.println("На корабле " + this.getArtificialObjectName() + " объявлена тревога!");
        }
    }

    public boolean isTorpedoAlarm() {
        return torpedoAlarm;
    }

    public boolean isRemoteControl() {
        return remoteControl;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)){
            return false;
        }
        Ship someShip = (Ship) obj;
        return (landed == someShip.landed)
                && (torpedoAlarm == someShip.torpedoAlarm)
                && (maneuvering == someShip.maneuvering)
                && (onBoard != null && onBoard.equals(someShip.onBoard))
                && (remoteControl == someShip.remoteControl);
    }

    @Override
    public int hashCode() {
        int parentHashCode = super.hashCode();
        Object[] vars = {parentHashCode, landed, torpedoAlarm, maneuvering, onBoard, remoteControl};
        return Arrays.hashCode(vars);
    }

    @Override
    public String toString() {
        return super.toString() + " Ship{" +
                "landed=" + landed +
                ", torpedoAlarm=" + torpedoAlarm +
                ", onBoard=" + onBoard +
                ", maneuvering=" + maneuvering +
                ", remoteControl=" + remoteControl +
                '}';
    }
}
