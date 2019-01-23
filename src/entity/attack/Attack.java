package entity.attack;

import java.util.*;

import entity.Entity;

/**
 * 
 */
public abstract class Attack {

    /**
     * Default constructor
     */
    public Attack() {
    }

    /**
     * 
     */
    private Set<AttackState> stateStack;

    /**
     * 
     */
    
    private Entity entity;//lanceur du sort

    /**
     * @param delta 
     * @return
     */
    public boolean update(long delta) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public Entity getEntity() {
        return this.entity;
    }

    /**
     * @param player
     */
    public void Attack(Entity entity) {
        // TODO implement here
    }

}