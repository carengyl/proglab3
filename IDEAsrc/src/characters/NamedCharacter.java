package src.characters;

import src.ships.Ship;
import src.util.Fraction;

import java.util.ArrayList;

public abstract class NamedCharacter extends Human{
    private final String CHARACTER_NAME;
    private final Fraction ALLEGIANCE;

    public NamedCharacter(String characterName, Fraction fraction, Ship ship){
        CHARACTER_NAME = characterName;
        ALLEGIANCE = fraction;
        ALLEGIANCE.addFractionMember(this);
        setCurrentShip(ship);
        System.out.println("Персонаж " + characterName + " создан на корабле " + ship.getArtificialObjectName() + " и присоединен к фракции " + fraction.getFractionName());
    }

    //приказы передавать парами строка "приказ" + объект, над которым надо выполнить приказ
    private final ArrayList<Object> order = new ArrayList<>(2);

    public void newOrder(String order, Object parameter) {
        this.order.add(order);
        this.order.add(parameter);
        this.executeOrder();
        this.order.clear();
    }

    public ArrayList<Object> getOrder() {
        return order;
    }

    protected void executeOrder(){
        System.out.println(this.getCharacterName() + " не может понять и выполнить приказ.");
    }

    public String getCharacterName() {
        return CHARACTER_NAME;
    }

    public Fraction getALLEGIANCE() {
        return ALLEGIANCE;
    }

    public void say(String phrase){
        System.out.println(CHARACTER_NAME + ": " + phrase);
    }

    public void nod(){
        System.out.println(CHARACTER_NAME + " кивнул(а)");
    }
}
