public abstract class SpaceObject implements Stationary{
    private final String OBJECT_NAME;
    private Fraction protectorate;

    public SpaceObject(String n, Fraction f){
        this.OBJECT_NAME = n;
        this.protectorate = f;
    }

    public String getSpaceObjectName() {
        return this.OBJECT_NAME;
    }

    public void orbit() {
        System.out.println(this.OBJECT_NAME + " вращается вокруг Солнца.");
    }

    public Fraction getProtectorate() {
        return protectorate;
    }

    public void setProtectorate(Fraction f) {
        this.protectorate = f;
    }
}
