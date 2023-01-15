import java.util.LinkedList;

public class Planet extends SpaceObject{
    private final LinkedList<String> moons;

    public Planet(String n, Fraction f) {
        super(n, f);
        moons = new LinkedList<>();
    }

    public void setMoon(String m) {
        moons.add(m);
    }

}
