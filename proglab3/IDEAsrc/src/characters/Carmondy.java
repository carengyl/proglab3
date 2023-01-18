package src.characters;

import src.util.*;
import src.ships.*;
import java.util.ArrayList;

public class Carmondy extends NamedCharacter{
    public Carmondy(String name, Fraction allegiance, Ship ship) {
        super(name, allegiance, ship);
    }

    public void lockHostages (Ship s, Human h){
        if (this.getCurrentShip().equals(s)){
            if (h.resist()){
                this.say("Экипаж нельзя захватить, он сопротивляется.");
            }
            else{
                System.out.println(this.getCharacterName() + " запирает пленных.");
                h.setLocked(true);
            }
        }
    }

    public void occupyShip(Ship s){
        if (this.getCurrentShip().equals(s)){
            ArrayList<Human> enemyCrew = this.getCurrentShip().getOnBoard();
            for (Human enemy : enemyCrew) {
                if (enemy instanceof Colonists) {
                    if (enemy.resist()) {
                        System.out.println("Корабль не удалось захватить, экипаж сопротивляется");
                        break;
                    } else {
                        s.setOperator(this.getALLEGIANCE());
                    }
                }
            }
        }
    }

    public void setPerimeter(){
        System.out.println(this.getCharacterName() + " устанавливает периметр.");
    }

    public boolean report() {
        return true;
    }
}
