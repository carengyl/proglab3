public class OpenSpace extends SpaceObject{
    //класс космической пустоты
    public OpenSpace(String n, Fraction f){
        super(n, f);
    }

    @Override
    public void orbit() {
        System.out.println("Как ни странно, пространство остается неподвижно...");
    }
}
