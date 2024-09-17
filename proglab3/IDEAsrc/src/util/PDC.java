package src.util;

import src.ships.ArtificialObject;

public interface PDC {
    void firePDC(ArtificialObject targetObject, int gunsShooting);

    int defend(int torpedoes);
}
