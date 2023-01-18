package src.characters;

import src.ships.Drone;
import src.ships.Ship;
import src.util.Fraction;

public class Oksana extends NamedCharacter {
    public Oksana(String name, Fraction allegiance, Ship ship) {
        super(name, allegiance, ship);
    }

    @Override
    public void executeOrder() {
        switch ((String) getOrder().get(0)) {
            case "доложите" -> hack((Ship) getOrder().get(1));
            case "возьми дрон" -> takeDrone((Drone) getOrder().get(1));
            case "хватит маяться фигней" -> stopDrone((Drone) getOrder().get(1));
            default -> super.executeOrder();
        }
    }

    private void hack(Ship s) {
        s.setRemoteControl(true);
        if (s.isRemoteControl()) {
            System.out.println(this.getCharacterName() + " управляет кораблем " + s.getArtificialObjectName() + " удаленно.");
        }
    }

    private void takeDrone(Drone drone) {
        drone.controlDrone();
    }

    private void stopDrone(Drone drone) {
        drone.stopControl();
    }
}
