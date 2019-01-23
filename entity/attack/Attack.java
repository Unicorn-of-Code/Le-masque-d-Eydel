package entity.attack;

import java.util.*;

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
    private Entity entity;

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
    public Player getPlayer() {
        // TODO implement here
        return null;
    }

    /**
     * @param player
     */
    public void Attack(Player player) {
        // TODO implement here
    }

}