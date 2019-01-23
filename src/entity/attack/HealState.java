package entity.attack;

import entity.Entity;
import time.Tick;
import time.Time;

public class HealState extends EntityState {

    /**
     * EntityState with the slowRate removed
     * @param victim Entity victim of the Buff/Debuff
     * @param maxTime Time during the state do his job
     * @param hps slow rate removed from the victim's movement
     * @param timeProc Each time when the damage proc on the victim
     */
    HealState(Entity victim, long maxTime, int hps, long timeProc) {
        super(victim, maxTime);
        this.tick = Time.createTick(timeProc);
        this.healByStep = (int)(hps/(timeProc/1000));
    }

    /**
     * SlowRate of the victim's movements
     */
    private float healByStep;

    /**
     * Tick for each damage done
     */
    private Tick tick;

    /**
     * Update the effect of the EntityState
     * @param deltaTime Delta Time
     * @return If the EntityState has to be destroyed
     */
    public boolean update(long deltaTime) {
        if (tick.getNumberPassed() > 0) {
            entity.heal((int) healByStep*tick.getNumberPassed());
        }
        return super.update(deltaTime);
    }

}
