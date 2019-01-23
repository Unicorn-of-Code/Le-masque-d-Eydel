package time;

import java.util.*;

/**
 * Timer which reset at the end
 */
public class Tick extends Timer {

    /**
     * Default constructor
     */
    Tick(long time) {
        super(time);
    }

    /**
     * update with the deltaTime
     * @param deltaTime DeltaTime for each loop
     */
    public void update(long deltaTime) {
        passed = false;
        time += deltaTime;
        if (time >= maxTime) {
            time = time - maxTime;
            passed = true;
        }
    }

}