import java.util.LinkedList;

public class Corvette extends Ship implements PDC, Torpedoes {
    private final int PDC_UNITS;
    private final int TORPEDO_TUBES;

    public Corvette(String shipName, Fraction creatorFraction, Fraction operatorFraction, SpaceObject spaceObjectNearBy, int gunsNumber, int torpedoTubes){
        super(shipName, creatorFraction, spaceObjectNearBy);
        PDC_UNITS = gunsNumber;
        TORPEDO_TUBES = torpedoTubes;

        System.out.println("Создан корабль типа \"Корвет\" с именем " + shipName + " рядом с " + spaceObjectNearBy.getSpaceObjectName());
        System.out.println("Производитель: " + creatorFraction.getFractionName());
        System.out.println("Используется: " + operatorFraction.getFractionName());
        System.out.println("Вооружение: " + gunsNumber + " Пушек Точечной Обороны, " + torpedoTubes + " торпедных аппаратов");
        System.out.println();
    }

    @Override
    public void firePDC(ArtificialObject s, int guns) {
        if (guns > PDC_UNITS) {
            //стреляет по объекту s при помощи всех ПТО
        }
        else {
            //стреляет из g ПТО по объекту s
        }
    }

    @Override
    public void fireTorpedoes(ArtificialObject s, int t) {
        if (t > TORPEDO_TUBES){
            //to-do торпедирует залпами по количеству торпедных аппаратов
            System.out.println("Корабль " + this.getArtificialObjectName() + " выпускает " + t + " торпед очередями по " + TORPEDO_TUBES + ". Торпеды летят в " + s.getArtificialObjectName());
        } else if (t > 0) {
            //to-do выпускает t торпед
            System.out.println("Корабль " + this.getArtificialObjectName() + " выпускает " + t + " торпед. Торпеды летят в " + s.getArtificialObjectName());
        }

        if (t > 0 && s.getClass() == Ship.class){
            ((Ship) s).setTorpedoAlarm(true);
        }
    }

    @Override
    public void defend(int g) {
        if (g > PDC_UNITS && this.isTorpedoAlarm()){
            //to-do защищается при помощи всех ПТО
            System.out.println("Корабль " + this.getArtificialObjectName() + " защищается при помощи всех ПТО");
        } else if (g > 0) {
            System.out.println("Корабль " + this.getArtificialObjectName() + " защищается при помощи" + g + "ПТО");
        }
    }


    public void boardShip(Ship s, NamedCharacter[] boardingParty){
        LinkedList<String> boarded = new LinkedList<>();
        for (NamedCharacter boarder : boardingParty) {
            if (boarder.getCurrentShip().equals(this)) {
                boarder.setCurrentShip(s);
                boarded.add(boarder.getCharacterName());
            }
        }
        System.out.println("Абордажная команда в составе " + boarded + "перебралась с " + this.getArtificialObjectName() + " на " + s.getArtificialObjectName());
    }
}
