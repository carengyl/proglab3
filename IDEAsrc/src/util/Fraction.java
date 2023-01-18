package src.util;

import src.characters.*;
import src.locations.*;
import src.ships.*;
import java.util.ArrayList;

public enum Fraction {
    UN("Объединенные Нации"),
    MCR("Марсианская Конгрессионная Республика"),
    OAP("Альянс Свободных Планет"),
    FREE_NAVY("Свободный флот"),
    INDEPENDENT("Независимый");

    private final String fractionName;
    Fraction(String fractionName){
        this.fractionName = fractionName;
        fractionLocations = new ArrayList<>();
        fractionShips = new ArrayList<>();
        fractionMembers = new ArrayList<>();
    }

    private final ArrayList<ArtificialObject> fractionShips;
    private final ArrayList<Location>  fractionLocations;
    private final ArrayList<NamedCharacter> fractionMembers;

    public void addFractionShip(ArtificialObject ship) {
        fractionShips.add(ship);
    }

    public void removeFractionShip(ArtificialObject ship){
        fractionShips.remove(ship);
    }

    public void addFractionMember(NamedCharacter member){
        fractionMembers.add(member);
    }

    public void addFractionLocation(Location location){
        fractionLocations.add(location);
    }

    public ArrayList<Location> getFractionLocations() {
        return fractionLocations;
    }

    public ArrayList<NamedCharacter> getFractionMembers() {
        return fractionMembers;
    }

    public void displayFractionShips() {
        System.out.println();
        System.out.println("Корабли фракции " + fractionName);
        for (ArtificialObject ship: fractionShips) {
            System.out.println(this.fractionName + ": " + ship.getArtificialObjectName());
        }
        System.out.println();
    }

    public String getFractionName(){
        return fractionName;
    }
}

