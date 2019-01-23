package entity;

import java.util.Set;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

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