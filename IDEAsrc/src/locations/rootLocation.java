package src.locations;

import src.ships.ArtificialObject;

import java.util.ArrayList;

public class rootLocation extends Location{
    public rootLocation(){
        super();
    }

    @Override
    public Location getSuperLocation() {
        return null;
    }

    @Override
    public ArrayList<ArtificialObject> getShipsNearBy() {
        return null;
    }

    @Override
    public void addShips(ArtificialObject ship) {
        System.out.println("Корабли или станции не могут находиться в корневой локации");
    }
}
