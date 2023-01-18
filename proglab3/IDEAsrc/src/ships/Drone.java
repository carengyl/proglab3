package src.ships;

import src.locations.Location;
import src.util.NonStationary;

import java.util.Arrays;

public class Drone extends ArtificialObject implements NonStationary {
    private boolean maneuvering;
    private boolean remoteControl;
    private boolean docked;
    private final Corvette carrier;

    public Drone(String droneName, Corvette corvette, int droneHP){
        super(droneName, corvette.getOperatedBy(), corvette.getCurrentLocation(), droneHP);
        carrier = corvette;
        corvette.addDrone(this);
        docked = true;
        remoteControl = false;
        maneuvering = false;
        System.out.println("Создан разведывательный дрон " + getArtificialObjectName() + " на корабле " + carrier.getArtificialObjectName());
    }

    @Override
    public void flyTo(Location destination) {
        if (remoteControl && !docked &&
                (((!this.getCurrentLocation().getSuperLocation().isRoot()) && destination.equals(this.getCurrentLocation().getSuperLocation())) //перемещение вверх по иерархии
                        || (this.getCurrentLocation().getSuperLocation().equals(destination.getSuperLocation()) && (!this.getCurrentLocation().getSuperLocation().isRoot())) //перемещение между "соседними" локациями, не корневыми, не системами
                        || this.getCurrentLocation().getSubLocations().contains(destination))) //перемещение вниз по иерархии
        {
            this.setCurrentLocation(destination);
        }
    }

    @Override
    public void maneuver() {
        if (remoteControl){
            maneuvering = true;
        }
    }

    public void controlDrone() {
        remoteControl = true;
        docked = false;
    }

    public void stopControl() {
        remoteControl = false;
        docked = true;
    }

    public void beCarried(Location destination) {
        if (carrier.getCurrentLocation().equals(destination)) {
            this.setCurrentLocation(destination);
        }
    }

    @Override
    public void getTorpedoes(int torpedoesHit) {
       if (maneuvering){
           super.getTorpedoes(0);
       } else {
           super.getTorpedoes(torpedoesHit);
       }
    }

    @Override
    public int hashCode() {
        int parentHashCode = super.hashCode();
        Object[] vars = {parentHashCode, maneuvering, remoteControl, docked, carrier};
        return Arrays.hashCode(vars);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)){
            return false;
        }
        Drone someDrone = (Drone) obj;
        return (maneuvering == someDrone.maneuvering) && (remoteControl == someDrone.remoteControl) && (docked == someDrone.docked) &&
                (carrier.equals(someDrone.carrier));
    }
}
