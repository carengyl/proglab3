package src.characters;

import src.ships.*;

public class Colonists extends Human{
    @Override
    public boolean resist() {
        return false;
    }

    public Colonists(Ship ship){
        ship.addOnBoard(this);
        System.out.println("Создана группа колонистов и добавлена на корабль " + ship.getArtificialObjectName());
        this.setLocked(false);
    }

    @Override
    public void changeShip(Ship newShip) {
        if (!this.isLocked()) {
            super.changeShip(newShip);
        }
        else{
            System.out.println("Колонисты заперты и не могут перемещаться");
        }
    }
}
