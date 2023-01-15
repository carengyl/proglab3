import java.util.ArrayList;

public class Ship extends ArtificialObject implements NonStationary{
    private SpaceObject currentPosition;
    private boolean torpedoAlarm;
    private final ArrayList<Human> onBoard;
    private boolean maneuvering;
    private boolean remoteControl;

    public Ship(String n, Fraction op, SpaceObject s){
        super(n, op);
        currentPosition = s;
        onBoard = new ArrayList<>();
    }

    public void addCrew(Human h){
        onBoard.add(h);
    }

    public ArrayList<Human> getOnBoard() {
        return onBoard;
    }

    public SpaceObject getCurrentPosition() {
        return currentPosition;
    }

    @Override
    public void flyTo(SpaceObject destination){
        if (remoteControl) {
            System.out.println("Корабль находится на удаленном управлении");
        }
        System.out.println("Корабль " + this.getArtificialObjectName() + " перемещается между " + this.getCurrentPosition().getSpaceObjectName() + " и " + destination.getSpaceObjectName());
        currentPosition = destination;
    }

    @Override
    public void maneuver() {
        System.out.println("Корабль " + this.getArtificialObjectName() + " маневрирует");
        maneuvering = true;
    }

    public boolean isManeuvering() {
        return maneuvering;
    }

    public void setRemoteControl(boolean remoteControl) {
        this.remoteControl = remoteControl;
    }

    @Override
    public boolean isIntact() {
        return super.isIntact();
    }

    public boolean isTorpedoAlarm() {
        return torpedoAlarm;
    }

    public void setTorpedoAlarm(boolean torpedoAlarm) {
        this.torpedoAlarm = torpedoAlarm;
        if (torpedoAlarm){
            System.out.println("На корабле " + this.getArtificialObjectName() + " объявлена тревога!");
        }
    }
}
