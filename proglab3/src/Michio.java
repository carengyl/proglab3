public class Michio extends NamedCharacter{
    public Michio(String n, Fraction a, Ship s){
        super(n, a, s);
    }

    public void giveOrder(NamedCharacter crewman, String order, Object parameter){
        crewman.newOrder(order, parameter);
    }

    @Override
    protected void executeOrder() {
        System.out.println(this.getCharacterName() + " не может исполнять приказы, т.к. является капитаном.");
    }

}

