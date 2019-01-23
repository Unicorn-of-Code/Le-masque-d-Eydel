package entity;


import entity.attack.EntityState;
import entity.hitbox.Allegency;
import entity.hitbox.Element;
import entity.hitbox.Hitbox;

import java.util.*;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

/**
 * 
 */
public abstract class Entity {
	
	protected int direction;
	protected boolean moving;
    protected float movementSpeed;
    protected Vector2f movement;
    private Hitbox hitbox;
    private Gauge life;
    private Gauge armor;
    private List<EntityState> entityStates = new ArrayList<EntityState>();

    /**
     * Default constructor
     */
    public Entity(float x, float y, float size, float movementSpeed, Allegency allegency, Element element) {
    	this.direction = 2;
    	this.moving = false;
    	this.movementSpeed = movementSpeed;
    	hitbox = new Hitbox(new Rectangle(x, y, size, size), allegency, element);
    }
    
    public float getX() {
		return this.hitbox.getShape().getX();
	}

	public void setX(float x) {
		this.hitbox.getShape().setX(x);
	}

	public float getY() {
		return this.hitbox.getShape().getY();
	}

	public void setY(float y) {
		this.hitbox.getShape().setY(y);
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

    public Hitbox getHitbox() {
        return this.hitbox;
    }

    /**
     * 	movement
     */
    public void update(int delta) {
    	if (this.isMoving()) {
	        switch (this.getDirection()) {
	            case 0: this.setY(this.getY() - this.movementSpeed * delta); break;
	            case 1: this.setX(this.getX() - this.movementSpeed * delta); break;
	            case 2: this.setY(this.getY() + this.movementSpeed * delta); break;
	            case 3: this.setX(this.getX() + this.movementSpeed * delta); break;
	        }
	    }
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