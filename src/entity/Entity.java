package entity;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public abstract class Entity {
	
	/*
	 * Sprite
	 */
	private float x = 400, y = 400;
	private int direction = 2;
	private boolean moving = false;
	private boolean onStair;
	private Animation[] animations = new Animation[8];

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