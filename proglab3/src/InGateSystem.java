public class InGateSystem extends SpaceObject{
    public InGateSystem (String n, Fraction f){
        super(n, f);
    }

    @Override
    public void orbit() {
        System.out.println(this.getSpaceObjectName() + " находится внутри Кольца, в неизвестной точке космоса.");
    }
}
