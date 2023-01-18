package src.locations;

import src.util.Fraction;

public class OpenSpace extends Location {
    public OpenSpace(String openSpaceName, Location openSpaceSuperLocation){
        super(openSpaceName, Fraction.INDEPENDENT, openSpaceSuperLocation);
    }

}
