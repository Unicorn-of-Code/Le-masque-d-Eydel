package time;

import java.util.*;

/**
 * Timer which reset at the end
 */
public final class Tick extends TimerType {

    /**
     * Default constructor
     */
    Tick(long time) {
        super(time);
    }

    /**
     * Number of time done
     */
    private int numberPassed = 0;

    /**
     * update with the deltaTime
     * @param deltaTime DeltaTime for each loop
     */
    public void update(long deltaTime) {
        numberPassed = 0;
        time += deltaTime;
        long mod = time % maxTime;
        if (mod != 0) {
            time = time - maxTime*mod;
        }
    }

    public int getNumberPassed() {
        return numberPassed;
    }
}