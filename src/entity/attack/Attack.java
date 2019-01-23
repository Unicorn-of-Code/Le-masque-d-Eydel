package entity.attack;

import entity.Entity;
import entity.Player;

import java.util.*;

import entity.Entity;

/**
 * Attack define an Attack with differnet states
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
    
    private Entity entity;//lanceur du sort

    /**
     * Update the attack with the Delta Time
     * @param deltaTime Delta Time
     * @return True if the Attack is finished
     */
<<<<<<< HEAD
    public boolean update(long deltaTime) {
        if (stateStack.peek().update(deltaTime)) {
            stateStack.pop();
        }
        return stateStack.empty();
=======
    public Entity getEntity() {
        return this.entity;
>>>>>>> 7df80eb97ee73465a553909615c11c6b6422b928
    }

    /**
     * Get the Entity of the launcher
     * @return Entity which launched this attack
     */
<<<<<<< HEAD
    public Entity getEntity() {
        return entity;
=======
    public void Attack(Entity entity) {
        // TODO implement here
>>>>>>> 7df80eb97ee73465a553909615c11c6b6422b928
    }
}