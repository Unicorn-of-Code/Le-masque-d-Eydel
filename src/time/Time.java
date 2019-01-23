package time;

import java.util.*;

/**
 * Abstract class which create Timers and update them
 */
public abstract class Time {

    private List<Timer> timers = new ArrayList<Timer>();

    /**
     * Create Tick
     * @param time Time when it has to tick
     * @return The tick pointer
     */
    public Tick createTick(long time) {
        Tick newTick = new Tick(time);
        timers.add(newTick);
        return newTick;
    }

    /**
     * Create Timer
     * @param time Time when it has to tick
     * @return The Timer Pointer
     */
    public Timer createTimer(long time) {
        Timer newTimer = new Timer(time);
        timers.add(newTimer);
        return newTimer;
    }

    /**
     * Update all the Timer and th Tick
     * @param deltaTime Delta Time
     */
    public void update(long deltaTime) {
        for (Timer t : timers) {
            t.update(deltaTime);
        }
    }

    /**
     * Remove a Timer or a Tick
     * @param timer The Timer or  Tick to delete
     */
    public void deleteTimer(Timer timer) {
        timers.remove(timer);
    }

}