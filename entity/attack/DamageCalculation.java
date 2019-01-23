package entity.attack;

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
    private static float strong = 1.5;

    /**
     * 
     */
    private static float medium = 1;

    /**
     * 
     */
    private static float weak = 0.5;

    /**
     * @param attackState 
     * @param entity
     */
    public static void attributeDamage(AttackState attackState, Entity entity) {
        // TODO implement here
    }

}