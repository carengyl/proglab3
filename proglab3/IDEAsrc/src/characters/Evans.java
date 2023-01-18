package src.characters;

import src.locations.Location;
import src.locations.Moon;
import src.ships.Ship;
import src.util.Fraction;

public class Evans extends NamedCharacter {
    public Evans(String name, Fraction allegiance, Ship ship) {
        super(name, allegiance, ship);
    }

    @Override
    public void executeOrder() {
        switch ((String) getOrder().get(0)) {
            case "отойдем подальше" -> maneuverShip();
            case "лети к" -> flyShipTo((Location) getOrder().get(1));
            case "садись на" -> landShipOn((Moon) getOrder().get(1));
            case "взлетай" -> takeOffFromMoon();
            case "нас атакуют" -> battleState();
            default -> super.executeOrder();
        }
    }

    private void maneuverShip(){
        this.getCurrentShip().maneuver();
        this.getCurrentShip().stopManeuvering();
    }

    private void battleState(){
        this.getCurrentShip().maneuver();
        this.getCurrentShip().setTorpedoAlarm(true);
    }

    private void flyShipTo(Location location){
        this.getCurrentShip().flyTo(location);
    }

    private void landShipOn(Moon moon){
        this.getCurrentShip().landOnMoon(moon);
    }

    private void takeOffFromMoon(){
        this.getCurrentShip().takeOff();
    }
}
