public class Moon extends SpaceObject{
    private final String planetOrbit;
    public Moon(String n,  Fraction f, Planet p) {
        super(n, f);
        p.setMoon(n);

        planetOrbit = p.getSpaceObjectName();
    }

    @Override
    public void orbit() {
        System.out.println(super.getSpaceObjectName() + " кружится вокруг " + planetOrbit);
    }
}
