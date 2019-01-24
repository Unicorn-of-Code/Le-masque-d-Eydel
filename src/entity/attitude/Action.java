package entity.attitude;

import time.Timer;

public abstract class Action {

    Action(Timer timer) {
        this.timer = timer;
    }

    private Timer timer;

}
