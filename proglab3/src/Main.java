import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        Planet jupiter = new Planet("Юпитер", Fraction.FREE_NAVY);
        Moon io = new Moon("Ио", Fraction.FREE_NAVY, jupiter);
        Moon europe = new Moon("Европа", Fraction.FREE_NAVY, jupiter);
        Moon callisto = new Moon("Каллисто", Fraction.FREE_NAVY, jupiter);

        InGateSystem gateHeart = new InGateSystem("сердце Врат", Fraction.FREE_NAVY);
        Ship medinaStation = new Ship("Станция \"Медина\"", Fraction.OAP, gateHeart);

        OpenSpace somewhere = new OpenSpace("космическая пустота", Fraction.INDEPENDENT);

        Corvette connaught = new Corvette("\"Коннахт\"", Fraction.MCR, Fraction.FREE_NAVY, somewhere, 6, 2);
        Evans evans = new Evans("Эванс", Fraction.FREE_NAVY, connaught);
        Michio michio = new Michio("Мичио Па", Fraction.FREE_NAVY, connaught);
        Oksana oksana = new Oksana("Оксана Буш", Fraction.FREE_NAVY, connaught);
        Carmondy carmondy = new Carmondy("Кармонди", Fraction.FREE_NAVY, connaught);
        Sidekick sidekick1 = new Sidekick("Абордажник 1", Fraction.FREE_NAVY, connaught);
        Sidekick sidekick2 = new Sidekick("Абордажник 2", Fraction.FREE_NAVY, connaught);
        System.out.println();

        LinkedList<String> freighterCargo = new LinkedList<>();
        freighterCargo.add("Продовольствие");
        freighterCargo.add("Вода");
        Freighter hornblower = new Freighter("\"Хорнблауэр\"", Fraction.UN, Fraction.INDEPENDENT, somewhere, freighterCargo);
        Colonists colonists = new Colonists(hornblower);
        System.out.println();

        NamedCharacter[] boardingParty = {carmondy, sidekick1, sidekick2};
        connaught.boardShip(hornblower, boardingParty);
        carmondy.occupyShip(hornblower);



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

        SpaceObject[] Belt = new SpaceObject[]{jupiter, io, callisto, europe};

        for (int i = 0; i < Belt.length; i++){
            if (Belt[i].getProtectorate().equals(Fraction.FREE_NAVY)){
                if (i== Belt.length-1){
                    System.out.println("Пояс сбросил иго внутренних планет.");
                }
            }
        }

        if (medinaStation.getOperatedBy().equals(Fraction.OAP) && medinaStation.getCurrentPosition().equals(gateHeart)){
            System.out.println("Поясу принадлежала станция Медина в сердце врат и единственный действующий в Солнечной системе флот, им принадлежала благодарность миллионов астеров. \nВ историческом масштабе это была величайшая победа свободы и независимости. \nВ местном масштабе они сейчас спасали победителей от голодной смерти.");
        }

        michio.giveOrder(evans, "лети к", jupiter);

        while (innerTime < 48*60) {
            innerTime += 30;
            if (!carmondy.report()) {
                connaught.fireTorpedoes(hornblower, 2);
                connaught.firePDC(hornblower, 6);
            }
        }

        System.out.println(connaught.getArtificialObjectName() + " долетел до " + connaught.getCurrentPosition().getSpaceObjectName());
    }
}
