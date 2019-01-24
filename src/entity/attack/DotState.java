package entity.attack;

import entity.Entity;
import time.Tick;
import time.Time;

public class DotState extends EntityState {

    /**
     * EntityState with the slowRate removed
     * @param victim Entity victim of the Buff/Debuff
     * @param maxTime Time during the state do his job
     * @param dps Damage per Second
     * @param timeProc Each time when the damage proc on the victim
     */
    DotState(Entity victim, long maxTime, int dps, long timeProc) {
        super(victim, maxTime);
        this.tick = Time.createTick(timeProc);
        this.damageByStep = (int)(dps/(timeProc/1000));
    }

    /**
     * SlowRate of the victim's movements
     */
    private float damageByStep;

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
            entity.damage((int) damageByStep*tick.getNumberPassed());
        }
        return super.update(deltaTime);
    }

}
