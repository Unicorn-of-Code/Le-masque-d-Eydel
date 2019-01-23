package entity.attack;

import entity.Entity;

import java.util.*;

/**
 * 
 */
public abstract class DamageCalculation {

    /**
     * Default constructor
     */
    public DamageCalculation() {
    }

    /**
     * 
     */
    private final static float strong = 1.5f;

    /**
     * 
     */
    private final static float medium = 1f;

    /**
     * 
     */
    private final static float weak = 0.5f;

    /**
     * @param attackState 
     * @param entity
     */
    public static void attributeDamage(AttackState attackState, Entity entity) {
        // TODO implement here
    }

}