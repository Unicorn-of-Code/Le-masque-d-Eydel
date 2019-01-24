package entity;


import entity.attack.EntityState;
import entity.hitbox.Allegency;
import entity.hitbox.Element;
import entity.hitbox.Hitbox;
import level.Map;

import java.util.*;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
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
    	this.life = new Gauge(100);
    	this.armor = new Gauge(100);
    	armor.set0();
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
		return movement.getX() != 0 || movement.getY() != 0;
	}

    public Hitbox getHitbox() {
        return this.hitbox;
    }

    public float getMovementSpeed() {
    	return (float)this.movementSpeed;
	}

    /**
     * Update the whole entity
	 * @param deltaTime Delta Time
     */
    public boolean update(long deltaTime, Map map, float xCam, float yCam, Player player) {
    	// Resolve if Move
		control(deltaTime, map, xCam, yCam, player);

    	// Resolve EntityState
		Iterator<EntityState> eSIt = entityStates.iterator();
    	while (eSIt.hasNext()) {
            EntityState eS = eSIt.next();
            if (eS.update(deltaTime)) {
                eSIt.remove();
            }
        }
    	
		// Resolve final movement
    	if (isMoving()) {
	        hitbox.move(movement);
	        // If collision decort
	        boolean cont = true;
	        /*
	        for (Entity entity : map.getEntities()) {
	        	if (this != entity) {
	        		if (this.getHitbox().collision(entity.getHitbox())) {
	    	        	hitbox.move(movement.negate());
	    	        	cont = false;
	    	        	break;
	        		}
	        	}
	        }
	        if (cont) {*/
        	if (map.isCollision(this.getX()+16, this.getY()+16)) {
	        	hitbox.move(movement.negate());
	        }
    	}
    	return life.isEmpty();
    }

    abstract void control (long deltaTime, Map map, float xCam, float yCam, Player player);


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

        	System.out.println("Damaged");
    		life.rem(amount);
    		System.out.println(life.isEmpty());
    		
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