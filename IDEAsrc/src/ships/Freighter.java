package src.ships;

import src.locations.Location;
import src.util.Cargo;
import src.util.Fraction;

import java.util.ArrayList;
import java.util.Arrays;

public class Freighter extends Ship implements Cargo {

    private final ArrayList<String> cargo;

    public Freighter(String freighterName, Fraction creatorFraction, Fraction operatorFraction, int freighterHP, Location locationNearBy, ArrayList<String> cargo){
        super(freighterName, creatorFraction, freighterHP, locationNearBy);
        this.cargo = cargo;

        System.out.println("Создан грузовой корабль " + freighterName + " рядом с " + locationNearBy.getSpaceObjectName());
        System.out.println("Производитель: " + creatorFraction.getFractionName());
        System.out.println("Используется: " + operatorFraction.getFractionName());
        freightCargo();
        System.out.println();
    }

    @Override
    public void freightCargo() {
        System.out.println("Перевозит " + this.getArtificialObjectName() + " груз: " + this.getCargo().toString());
    }

    public ArrayList<String> getCargo() {
        return cargo;
    }

    @Override
    public int hashCode() {
        int parentHashCode = super.hashCode();
        Object[] vars = {parentHashCode, cargo};
        return Arrays.hashCode(vars);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)){
            return false;
        }
        Freighter someFreighter = (Freighter) obj;
        return (cargo != null && cargo.equals(someFreighter.cargo));
    }
}
