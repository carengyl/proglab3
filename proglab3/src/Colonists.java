public class Colonists extends Human{
    @Override
    public boolean resist() {
        return false;
    }

    public Colonists(Ship s){
        s.addCrew(this);
        System.out.println("Создана группа колонистов и добавлена на корабль " + s.getArtificialObjectName());
        this.setLocked(false);
    }

    @Override
    public void setCurrentShip(Ship currentShip) {
        if (!this.isLocked()) {
            this.currentShip = currentShip;
        }
        else{
            System.out.println("Колонисты заперты и не могут перемещаться");
        }
    }
}
