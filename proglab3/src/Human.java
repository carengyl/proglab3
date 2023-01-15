abstract public class Human {
    protected Ship currentShip;
    private boolean locked;
    public void setLocked(boolean state){
        locked = state;
    }
    public boolean isLocked(){
        return locked;
    }

    public boolean resist(){
        return true;
    }

    public void setCurrentShip(Ship currentShip) {
        this.currentShip = currentShip;
        currentShip.addCrew(this);
    }

    public Ship getCurrentShip() {
        return currentShip;
    }
}
