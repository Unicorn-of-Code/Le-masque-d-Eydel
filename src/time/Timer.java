package time;

import java.util.*;

/**
 * Timer wich doesn't update at the end
 */
public class Timer {

    /**
     * Default constructor
     * @param time Limit of the timer
     */
    Timer(long time) {
        this.maxTime = time;
    }

    /**
     * Boolean which show if the time is passed
     */
    boolean passed;

    /**
     * Actual time passed
     */
    long time = 0;

    /**
     * Max Time to reach
     */
    long maxTime;

    /**
     * Update the timer with the deltaTime
     * @param deltaTime Deta Time
     */
    public void update(long deltaTime) {
        if (!passed) {
            time += deltaTime;

            if (time >= maxTime) {
                time = maxTime;
                passed = true;
            }
        }
    }

    /**
     * Reset the Timer to 0 with passed = false
     */
    public void reset() {
        passed = false;
        time = 0;
    }

    /**
     * Return the boolean passed
     * @return passed
     */
    public boolean getPassed () {
        return passed;
    }

}