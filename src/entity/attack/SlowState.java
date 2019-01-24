package entity.attack;

import entity.Entity;

public class SlowState extends EntityState {

    /**
     * EntityState with the slowRate removed
     * @param victim Entity victim of the Buff/Debuff
     * @param maxTime Time during the state do his job
     * @param slowRate slow rate removed from the victim's movement
     */
    public SlowState(Entity victim, long maxTime, float slowRate) {
        super(victim, maxTime);
        this.slowRate = slowRate;
    }

    /**
     * SlowRate of the victim's movements
     */
    private float slowRate;

    /**
     * Update the effect of the EntityState
     * @param deltaTime Delta Time
     * @return If the EntityState has to be destroyed
     */
    public boolean update(long deltaTime) {
        // TODO : Slow speed of the victim
        return super.update(deltaTime);
    }

}
