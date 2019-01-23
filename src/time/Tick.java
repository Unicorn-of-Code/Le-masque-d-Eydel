package time;

import java.util.*;

/**
 * 
 */
public final class Tick extends TimerType {

    /**
     * Default constructor
     */
    public Tick() {
    }

    /**
<<<<<<< HEAD
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
=======
     * @param deltaTime
     */
    public void update(long deltaTime) {
        // TODO implement here
>>>>>>> 7df80eb97ee73465a553909615c11c6b6422b928
    }

    public int getNumberPassed() {
        return numberPassed;
    }
}