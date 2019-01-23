package entity;



import entity.attack.EntityState;
import entity.hitbox.Hitbox;

import java.util.*;
import entity.attack.EntityState;


public abstract class Entity {

    /**
     * Default constructor
     */
    public Entity() {
    }

    /**
     * 
     */
    protected int movementSpeed;

    /**
     * 
     */
    protected Vector2f movement;

    /**
     * 
     */
    private Hitbox hitbox;

    /**
     * 
     */
    private gauge life;

    /**
     * 
     */
    private gauge armor;

    /**
     * 
     */
    private List<EntityState> entityStates = new ArrayList<EntityState>();

    /**
     * 
     */
    public void getHitbox() {
        // TODO implement here
    }

    /**
     * 
     */
    public void update() {
        // TODO implement here
    }

    /**
     *
     * @param amount
     */
    public void heal(int amount) {
        // TODO implement here
    }

    /**
     *
     * @param amount
     */
    public void damage(int amount) {
        // TODO implement here
    }

    /**
     *
     * @param entityState
     */
    public void addEntityState (EntityState entityState) {

    }
}