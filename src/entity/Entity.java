package entity;

<<<<<<< HEAD

import entity.attack.EntityState;
import entity.hitbox.Hitbox;

import java.util.*;
=======
import java.util.Set;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import entity.attack.EntityState;

>>>>>>> 7df80eb97ee73465a553909615c11c6b6422b928

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