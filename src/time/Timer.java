package time;

import java.util.*;

/**
 * 
 */
public final class Timer extends TimerType {

    /**
     * Default constructor
     */
<<<<<<< HEAD
    Timer(long time) {
        super(time);
=======
    public Timer() {
>>>>>>> 7df80eb97ee73465a553909615c11c6b6422b928
    }

    /**
     * 
     */
<<<<<<< HEAD
    private boolean passed;

    /**
     * Update the timer with the deltaTime
     * @param deltaTime Delta Time
=======
    protected boolean passed;

    /**
     * 
     */
    protected long time;

    /**
     * @param deltaTime
>>>>>>> 7df80eb97ee73465a553909615c11c6b6422b928
     */
    public void update(long deltaTime) {
        // TODO implement here
    }

    /**
     * 
     */
    public void reset() {
        // TODO implement here
    }

}