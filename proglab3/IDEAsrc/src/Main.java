package src;

import src.characters.*;
import src.locations.*;
import src.ships.*;
import src.util.Fraction;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        init();

        int innerTime = 0;
        System.out.println("\nНАЧАЛО ИСТОРИИ\n");
        carmondy.say("Корабль под контролем, капитан, сопротивления не оказывали. Никаких проблем.");
        michio.say("Буш, доложите!");
        michio.giveOrder(oksana, "доложите", hornblower);
        oksana.say("Их защиту сняла, тода и аллес.");

        michio.nod();
        michio.say(michio.getCurrentShip().getArtificialObjectName() + " контролирует системы вражеского корабля.");

        carmondy.lockHostages(hornblower, colonists);
        carmondy.setPerimeter();
        carmondy.say("Мы устанавливаем периметр и запираем пленных. Запускаю автоматическую проверку.");

        michio.say("Понятно. Давай-ка отойдем подальше, чтобы не задело взрывом, если в зерновом отсеке спрятана ядрена бомба.");
        michio.giveOrder(evans, "отойдем подальше", null);

        Location[] Belt = new Location[]{jupiter, io, callisto, europe};

        for (int i = 0; i < Belt.length; i++){
            if (Belt[i].getProtectorate().equals(Fraction.FREE_NAVY)){
                if (i== Belt.length-1){
                    System.out.println("Пояс сбросил иго внутренних планет.");
                }
            }
        }

        if (medinaStation.getOperatedBy().equals(Fraction.OAP) && medinaStation.getCurrentLocation().equals(gateHeart)){
            System.out.println("""
                    Поясу принадлежала станция Медина в сердце врат и единственный действующий в Солнечной системе флот, им принадлежала благодарность миллионов астеров.\s
                    В историческом масштабе это была величайшая победа свободы и независимости.\s
                    В местном масштабе они сейчас спасали победителей от голодной смерти.""");
        }

        michio.giveOrder(evans, "лети к", jupiter);

        while (innerTime < 48*60) {
            innerTime += 30;
            if (!carmondy.report()) {
                connaught.fireTorpedoes(hornblower, 2);
                connaught.firePDC(hornblower, 6);
            }
        }

        System.out.println(connaught.getArtificialObjectName() + " долетел до " + connaught.getCurrentLocation().getSpaceObjectName());

        michio.giveOrder(evans, "лети к", io);
        michio.giveOrder(evans, "садись на", io);
        if (connaught.isTorpedoAlarm()){
            michio.giveOrder(evans, "взлетай", null);
        }
    }

    static Drone drone1;
    static Drone drone2;
    static Drone drone3;
    static Drone drone4;
    static Location space;
    static Planet jupiter;
    static Moon io;
    static Moon europe;
    static Moon callisto;

    static InGateSystem gateHeart;
    static Ship medinaStation;

    static OpenSpace somewhere;

    static Corvette connaught ;
    static Evans evans;
    static Michio michio;
    static Oksana oksana;
    static Carmondy carmondy;
    static Sidekick sidekick1;
    static Sidekick sidekick2;
    static Freighter hornblower;
    static Colonists colonists;

    public static void init(){
        space = new rootLocation();

        jupiter = new Planet("Юпитер", Fraction.FREE_NAVY, space);
        io = new Moon("Ио", Fraction.FREE_NAVY, jupiter);
        europe = new Moon("Европа", Fraction.FREE_NAVY, jupiter);
        callisto = new Moon("Каллисто", Fraction.FREE_NAVY, jupiter);

        gateHeart = new InGateSystem("сердце Врат", Fraction.FREE_NAVY, space);
        medinaStation = new Ship("Станция \"Медина\"", Fraction.OAP, 1000, gateHeart);

        somewhere = new OpenSpace("космическая пустота", space);

        connaught = new Corvette("\"Коннахт\"", Fraction.MCR, Fraction.FREE_NAVY, 400, somewhere, 6, 2);
        evans = new Evans("Эванс", Fraction.FREE_NAVY, connaught);
        michio = new Michio("Мичио Па", Fraction.FREE_NAVY, connaught);
        oksana = new Oksana("Оксана Буш", Fraction.FREE_NAVY, connaught);
        carmondy = new Carmondy("Кармонди", Fraction.FREE_NAVY, connaught);
        sidekick1 = new Sidekick("Абордажник 1", Fraction.FREE_NAVY, connaught);
        sidekick2 = new Sidekick("Абордажник 2", Fraction.FREE_NAVY, connaught);
        drone1 = new Drone("Уитли", connaught, 20);
        drone2 = new Drone("Пибоди", connaught, 20);
        drone3 = new Drone("Атлас", connaught, 20);
        drone4 = new Drone("Куб-компаньон", connaught, 20);
        System.out.println();

        ArrayList<String> freighterCargo = new ArrayList<>();
        freighterCargo.add("Вода");
        freighterCargo.add("Продовольствие");

        hornblower = new Freighter("\"Хорнблауэр\"", Fraction.UN, Fraction.INDEPENDENT, 300, somewhere, freighterCargo);
        colonists = new Colonists(hornblower);

        NamedCharacter[] boardingParty = {carmondy, sidekick1, sidekick2};
        connaught.boardShip(hornblower, boardingParty);
        carmondy.occupyShip(hornblower);

        Fraction.FREE_NAVY.displayFractionShips();
    }
}
