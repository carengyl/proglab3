public class Oksana extends NamedCharacter{
    public Oksana(String n, Fraction a, Ship s) {
        super(n, a, s);
    }

    @Override
    public void executeOrder() {
        switch ((String) getOrder().get(0)) {
            case "доложите" -> hack((Ship) getOrder().get(1));
            default -> super.executeOrder();
        }
    }

    private void hack(Ship s){
        s.setRemoteControl(true);
        System.out.println(this.getCharacterName() + " управляет кораблем " + s.getArtificialObjectName() + " удаленно.");
    }
}
