package entity;

import java.util.*;

/**
 * 
 */
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
    private Set<EntityState> entityStates;

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

}