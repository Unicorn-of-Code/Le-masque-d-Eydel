package entity.attack;

import java.util.*;

/**
 * 
 */
public abstract class AttackState {

    /**
     * Default constructor
     */
    public AttackState() {
    }

    /**
     * 
     */
    private int damage;

    /**
     * 
     */
    private Vector2f movement;

    /**
     * 
     */
    private Attack attackProperty;

    /**
     * 
     */
    private Set<Hitbox> hiboxes;

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
    public int getDamage() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public Hitbox getHitbox() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Attack getAttackProperty() {
        // TODO implement here
        return null;
    }

    /**
     * @param attackProperty
     */
    public void AttackState(Attack attackProperty) {
        // TODO implement here
    }

}