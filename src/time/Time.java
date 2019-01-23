package time;

import java.util.*;

/**
 * 
 */
public abstract class Time {

    /**
     * Default constructor
     */
    public Time() {
    }


    /**
     * @param time 
     * @return
     */
    public Tick createTick(long time) {
        // TODO implement here
        return null;
    }

    /**
     * @param time 
     * @return
     */
    public Timer createTimer(long time) {
        // TODO implement here
        return null;
    }

    /**
     * @param deltaTime
     */
    public void update(long deltaTime) {
        // TODO implement here
    }

    /**
     * @param timer
     */
    public void deleteTimer(Timer timer) {
        // TODO implement here
    }

}