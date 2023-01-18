package src.ships;

import src.characters.NamedCharacter;
import src.locations.Location;
import src.util.Fraction;
import src.util.PDC;
import src.util.Torpedoes;

import java.util.ArrayList;
import java.util.Arrays;

public class Corvette extends Ship implements PDC, Torpedoes {
    private final int PDC_UNITS;
    private final int TORPEDO_TUBES;
    private final int PDC_FIRE_RATE;
    private int PDCAmmunition;
    private int torpedoAmmunition;
    private final double CIWSAccuracy;
    private final Drone[] drones;
    private int droneCount;

    public Corvette(String corvetteName, Fraction creatorFraction, Fraction operatorFraction, int corvetteHP, Location locationNearBy, int gunsNumber, int torpedoTubes){
        super(corvetteName, operatorFraction, corvetteHP, locationNearBy);
        PDC_UNITS = gunsNumber;
        PDCAmmunition = 10000;
        PDC_FIRE_RATE = 50;
        CIWSAccuracy = 0.9;
        drones = new Drone[4];
        droneCount = 0;

        TORPEDO_TUBES = torpedoTubes;
        torpedoAmmunition = 40;

        System.out.println("Создан корабль типа \"Корвет\" с именем " + corvetteName + " рядом с " + locationNearBy.getSpaceObjectName());
        System.out.println("Производитель: " + creatorFraction.getFractionName());
        System.out.println("Используется: " + operatorFraction.getFractionName());
        System.out.println("Вооружение: " + gunsNumber + " Пушек Точечной Обороны, " + torpedoTubes + " торпедных аппаратов");
        System.out.println();
    }

    void addDrone(Drone drone){
        if (droneCount < drones.length){
            drones[droneCount] = drone;
            droneCount += 1;
        }
    }

    @Override
    public void firePDC(ArtificialObject target, int gunsShooting) {
        if (this.getCurrentLocation().equals(target.getCurrentLocation())) {
            if (gunsShooting > PDC_UNITS) {
                gunsShooting = PDC_UNITS;
            }

            int bulletsShot = gunsShooting * PDC_FIRE_RATE;

            if (target instanceof Ship && ((Ship) target).isManeuvering()) {
                bulletsShot /= 50;
            }

            if (bulletsShot > this.PDCAmmunition) {
                bulletsShot = PDCAmmunition;
            }

            target.getBullets(bulletsShot);
            PDCAmmunition -= bulletsShot;
        }
    }

    private boolean getTorpedoLock(ArtificialObject targetObject){
        return ((!this.getCurrentLocation().getSuperLocation().isRoot()) && targetObject.getCurrentLocation().equals(this.getCurrentLocation().getSuperLocation()))
                //стрельба вниз по иерархии (пример: планета -> луна)
                || this.getCurrentLocation().equals(targetObject.getCurrentLocation())
                //стрельба вверх по иерархии, но не в корне (пример луна -> планета)
                || this.getCurrentLocation().getSubLocations().contains(targetObject.getCurrentLocation());
                //стрельба в одной локации
    }

    @Override
    public void fireTorpedoes(ArtificialObject targetShip, int torpedoes) {
        if (this.getTorpedoLock(targetShip)) {
            while (torpedoes > TORPEDO_TUBES && torpedoAmmunition >= TORPEDO_TUBES) {
                targetShip.getTorpedoes(TORPEDO_TUBES);
                torpedoes -= TORPEDO_TUBES;
                torpedoAmmunition -= TORPEDO_TUBES;
            }

            if (torpedoes > 0 && targetShip instanceof Ship) {
                ((Ship) targetShip).setTorpedoAlarm(true);
            }

            if (torpedoAmmunition >= torpedoes) {
                targetShip.getTorpedoes(torpedoes);
                torpedoAmmunition -= torpedoes;
            }
        }
    }

    @Override
    public int defend(int torpedoesLaunched) {
        int torpedoesDestroyed = torpedoesLaunched;
        if (torpedoesLaunched * (1 - CIWSAccuracy) * PDC_UNITS * PDC_FIRE_RATE > PDCAmmunition){
            torpedoesDestroyed = defend(torpedoesLaunched - 1);
        }
        return torpedoesDestroyed;
    }

    @Override
    public void getTorpedoes(int torpedoesLaunched) {
        int torpedoesHit = torpedoesLaunched - defend(torpedoesLaunched);
        super.getTorpedoes(torpedoesHit);
    }

    public void boardShip(Ship s, NamedCharacter[] boardingParty){
        ArrayList<String> boarded = new ArrayList<>();
        for (NamedCharacter boarder : boardingParty) {
            if (boarder.getCurrentShip().equals(this)) {
                boarder.changeShip(s);
                boarded.add(boarder.getCharacterName());
            }
        }
        System.out.println("Абордажная команда в составе " + boarded + " перебралась с " + this.getArtificialObjectName() + " на " + s.getArtificialObjectName());
    }

    @Override
    protected void blowUp() {
        ArrayList<ArtificialObject> shipsNearBy = this.getCurrentLocation().getShipsNearBy();
        for (ArtificialObject ship: shipsNearBy) {
            ship.getBullets(PDCAmmunition/shipsNearBy.size());
        }
        super.blowUp();
    }

    @Override
    public int hashCode() {
        int parentHashCode = super.hashCode();
        Object[] vars = {parentHashCode, PDC_UNITS, TORPEDO_TUBES, PDCAmmunition, PDC_FIRE_RATE, torpedoAmmunition, CIWSAccuracy};
        return Arrays.hashCode(vars);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)){
            return false;
        }
        Corvette someCorvette = (Corvette) obj;
        return (PDC_UNITS == someCorvette.PDC_UNITS)
                && (TORPEDO_TUBES == someCorvette.TORPEDO_TUBES)
                && (PDCAmmunition == someCorvette.PDCAmmunition)
                && (PDC_FIRE_RATE == someCorvette.PDC_FIRE_RATE)
                && (torpedoAmmunition == someCorvette.torpedoAmmunition)
                && (CIWSAccuracy == someCorvette.CIWSAccuracy);
    }

    @Override
    public void flyTo(Location destination) {
        super.flyTo(destination);
        for (Drone drone: drones) {
            if (drone != null){
                drone.beCarried(destination);
            }
        }
    }
}
