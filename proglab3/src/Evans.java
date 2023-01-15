public class Evans extends NamedCharacter{
    public Evans(String n, Fraction a, Ship s){
        super(n, a, s);
    }

    @Override
    public void executeOrder() {
        switch ((String) getOrder().get(0)) {
            case "отойдем подальше" -> maneuverShip();
            case "лети к" -> flyShipTo((SpaceObject) getOrder().get(1));
            default -> super.executeOrder();
        }
    }

    private void maneuverShip(){
        this.getCurrentShip().maneuver();
    }

    private void flyShipTo(SpaceObject s){
        this.getCurrentShip().flyTo(s);
    }
}
