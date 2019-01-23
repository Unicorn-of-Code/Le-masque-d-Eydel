package entity.attack;

import entity.Entity;
import entity.Player;

import java.util.*;

/**
 * 
 */
public abstract class Attack {

    /**
     * Default Constructor
     * @param entity Entity which launched the Attack
     */
    Attack(Entity entity) {
        this.entity = entity;
    }

    /**
     * Stack of all the AttackState
     */
    private Stack<AttackState> stateStack = new Stack<AttackState>();

    /**
     * Entity which launched the spell
     */
    private Entity entity;

    /**
     * Update the attack with the Delta Time
     * @param deltaTime Delta Time
     * @return True if the Attack is finished
     */
    public boolean update(long deltaTime) {
        if (stateStack.peek().update(deltaTime)) {
            stateStack.pop();
        }
        return stateStack.empty();
    }

    /**
     * Get the Entity of the launcher
     * @return Entity which launched this attack
     */
    public Entity getEntity() {
        return entity;
    }
}