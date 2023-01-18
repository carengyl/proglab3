package src.characters;

import src.ships.Ship;
import src.util.Fraction;

public class Michio extends NamedCharacter{
    public Michio(String name, Fraction allegiance, Ship ship){
        super(name, allegiance, ship);
    }

    public void giveOrder(NamedCharacter crewman, String order, Object parameter){
        crewman.newOrder(order, parameter);
    }

    @Override
    protected void executeOrder() {
        System.out.println(this.getCharacterName() + " не может исполнять приказы, т.к. является капитаном.");
    }

}

