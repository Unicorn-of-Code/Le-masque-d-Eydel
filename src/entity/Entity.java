package entity;


import entity.attack.EntityState;
import entity.hitbox.Allegency;
import entity.hitbox.Element;
import entity.hitbox.Hitbox;
import level.Map;

import java.util.*;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

/**
 * Abstract class which define an entity
 */
public abstract class Entity {
	
	int direction;
    float movementSpeed;
    private Hitbox hitbox;
    private Gauge life;
    private Gauge armor;
    private List<EntityState> entityStates = new ArrayList<EntityState>();
    Vector2f movement = new Vector2f(0, 0);

    /**
     * Default constructor
     */
    public Entity(float x, float y, float size, float movementSpeed, Allegency allegency, Element element) {
    	this.direction = 2;
    	this.movementSpeed = movementSpeed;	// pixel / ms
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
		return movement.getX()==0 && movement.getY() == 0;
	}

    public Hitbox getHitbox() {
        return this.hitbox;
    }

    /**
     * Update the whole entity
	 * @param deltaTime Delta Time
     */
    public void update(long deltaTime, Map map) {
    	// Resolve if Move
		control(deltaTime, map);

    	// Resolve EntityState
		Iterator<EntityState> eSIt = entityStates.iterator();
    	while (eSIt.hasNext()) {
            EntityState eS = eSIt.next();
            if (eS.update(deltaTime)) {
                eSIt.remove();
            }
        }

		// Resolve final movement
        hitbox.move(movement);
    }

    abstract void control (long deltaTime, Map map);


	/**
	 * Draw Entity
	 * @param g Graphic Slick
	 */
	public abstract void draw(Graphics g);

	/**
	 * Heal the entity
	 * @param amount amount of heal
	 */
    public void heal(int amount) {
        life.add(amount);
    }

    /**
     * Damage the entity
     * @param amount amount of damage
     */
    public void damage(int amount) {
    	if (armor.isEmpty()) {
    		life.rem(amount);
		} else {
    		armor.rem(amount);
		}
    }

    /**
     * Add an EntityState (buff/debuff)
     * @param entityState The EntityState to add
     */
    public void addEntityState (EntityState entityState) {
		entityStates.add(entityState);
    }
}