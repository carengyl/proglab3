package src.characters;

import src.ships.*;

abstract public class Human {
    private Ship currentShip;
    private boolean locked;
    public void setLocked(boolean state) {
        locked = state;
    }
    public boolean isLocked() {
        return locked;
    }

    public boolean resist() {
        return true;
    }

    public void setCurrentShip(Ship currentShip) {
        this.currentShip = currentShip;
    }

    public void changeShip(Ship newShip) {
        currentShip.deleteFromBoard(this);
        currentShip = newShip;
        newShip.addOnBoard(this);
    }

    public Ship getCurrentShip() {
        return currentShip;
    }
}
