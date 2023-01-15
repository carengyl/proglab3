import java.util.LinkedList;

public class Freighter extends Ship implements Cargo{

    private final LinkedList<String> cargo;

    public Freighter(String shipName, Fraction creatorFraction, Fraction operatorFraction, SpaceObject spaceObjectNearBy, LinkedList<String> cargo){
        super(shipName, creatorFraction, spaceObjectNearBy);
        this.cargo = cargo;

        System.out.println("Создан грузовой корабль " + shipName + " рядом с " + spaceObjectNearBy.getSpaceObjectName());
        System.out.println("Производитель: " + creatorFraction.getFractionName());
        System.out.println("Используется: " + operatorFraction.getFractionName());
        System.out.println("Перевозит: " + this.cargo.toString());
        System.out.println();
    }

    @Override
    public void freightCargo() {
        System.out.println("Перевозит " + this.getArtificialObjectName() + " груз: " + this.getCargo().toString());
    }

    public LinkedList<String> getCargo() {
        return cargo;
    }
}
