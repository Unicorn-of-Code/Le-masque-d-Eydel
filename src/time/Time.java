package time;

import java.util.*;

/**
 * 
 */
public final class Time {

    /**
     * Default constructor
     */
<<<<<<< HEAD
    private static List<TimerType> timers = new ArrayList<TimerType>();
=======
    public Time() {
    }
>>>>>>> 7df80eb97ee73465a553909615c11c6b6422b928


    /**
     * @param time 
     * @return
     */
<<<<<<< HEAD
    public static Tick createTick(long time) {
        Tick newTick = new Tick(time);
        timers.add(newTick);
        return newTick;
=======
    public Tick createTick(long time) {
        // TODO implement here
        return null;
>>>>>>> 7df80eb97ee73465a553909615c11c6b6422b928
    }

    /**
     * @param time 
     * @return
     */
<<<<<<< HEAD
    public static Timer createTimer(long time) {
        Timer newTimer = new Timer(time);
        timers.add(newTimer);
        return newTimer;
=======
    public Timer createTimer(long time) {
        // TODO implement here
        return null;
>>>>>>> 7df80eb97ee73465a553909615c11c6b6422b928
    }

    /**
     * @param deltaTime
     */
    public void update(long deltaTime) {
<<<<<<< HEAD
        for (TimerType t : timers) {
            t.update(deltaTime);
        }
=======
        // TODO implement here
>>>>>>> 7df80eb97ee73465a553909615c11c6b6422b928
    }

    /**
     * @param timer
     */
    public void deleteTimer(Timer timer) {
        // TODO implement here
    }

}