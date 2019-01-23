package entity.attack;

import entity.Entity;
import time.Time;
import time.Timer;


/**
 * A state (buff or debuff) for an entity
 */
public abstract class EntityState {

    /**
     * Constructor of EntityState
     * @param victim Entity victim of the Buff/Debuff
     * @param maxTime Time during the state do his job
     */
    EntityState(Entity victim, long maxTime) {
        this.entity = victim;
        this.timer = Time.createTimer(maxTime);
    }

    /**
     * Entity wich the state is applied
     */
    protected Entity entity;

    /**
     * Time during the EntityState exist
     */
    protected Timer timer;

    /**
     * Update the effect of the EntityState
     * @param deltaTime Delta Time
     * @return If the EntityState has to be destroyed
     */
    public boolean update(long deltaTime) {
        return (timer.getPassed());
    }

}