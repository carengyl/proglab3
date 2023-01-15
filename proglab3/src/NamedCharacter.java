import java.util.ArrayList;

public abstract class NamedCharacter extends Human{
    private final String CHARACTER_NAME;
    private final Fraction allegiance;

    public NamedCharacter(String n, Fraction a, Ship s){
        CHARACTER_NAME = n;
        allegiance = a;
        setCurrentShip(s);
        System.out.println("Персонаж " + n + " создан на корабле " + s.getArtificialObjectName() + " и присоединен к фракции " + a.getFractionName());
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

    public Fraction getAllegiance() {
        return allegiance;
    }

    public void say(String phrase){
        System.out.println(CHARACTER_NAME + ": " + phrase);
    }

    public void nod(){
        System.out.println(CHARACTER_NAME + " кивнул(а)");
    }
}
