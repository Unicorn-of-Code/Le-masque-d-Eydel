package time;


abstract class TimerType {

    /**
     * Default Constructor
     * @param time maxTime set
     */
    TimerType (long time) {
        this.maxTime = time;
    }

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
     * @param deltaTime Delta Time
     */
    abstract void update(long deltaTime);
}
