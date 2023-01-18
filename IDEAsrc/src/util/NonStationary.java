package src.util;

import src.locations.Location;

public interface NonStationary {
    void flyTo(Location s);

    void maneuver();
}
