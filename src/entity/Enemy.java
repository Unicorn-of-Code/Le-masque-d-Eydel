package entity;


import entity.attack.AttackState;
import entity.attack.DamageCalculation;
import entity.attitude.Attitude;
import entity.hitbox.Allegency;
import entity.hitbox.Element;
import entity.hitbox.Hitbox;
import level.Map;
import time.Time;
import time.Timer;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;


/**
 * The enemies of the forest
 */
public abstract class Enemy extends Entity {

    private Attitude attitude;
    private Shape vision;
    private float movementSpeedFast;
    private Timer attackTimer;
    AttackState attackState;
    int damage;

    /**
     * Initialize a new entity which has a vision range
     * @param x,y : position
     * @param size : hitbox size
     */
    public Enemy(float x, float y, float size, float movementSpeed, float movementSpeedFast,
                 Element element, int damage) {
        super(x, y, size, movementSpeed, Allegency.Ennemy, element);
        this.movementSpeedFast = movementSpeedFast;
        this.attitude = getAttitude();
        attackTimer = Time.createTimer((500));
        this.damage = damage;
    }

    /* Test
    public Enemy() {
        super(400, 400, 36.0f, 0.1f, Allegency.Ally, Element.Water);
        this.visionRange = 150;
    }
    */

    @Override
    void control (long deltaTime, Map map, float xCam, float yCam, Player player) {
    	Vector2f v = new Vector2f(
    			player.getHitbox().getShape().getCenterX() - this.getHitbox().getShape().getCenterX(),
    			player.getHitbox().getShape().getCenterY() - this.getHitbox().getShape().getCenterY());

    	if (v.length() <= 10*Hitbox.tileSize) {
    		v.normalise().scale(movementSpeed);
    		this.movement = v.copy();
    		System.out.println("Move");

        	if (v.length() <= 2*Hitbox.tileSize) {
        		if (attackTimer.getPassed()) {
        			DamageCalculation.attributeDamageFromEnemy(damage, this.getHitbox().getElement(), player, this);
        			attackTimer.reset();
        		}
        	}
    	}
    }

    private Vector2f getDirectionPlayer (Player player) {
        return new Vector2f(
                player.getHitbox().getShape().getCenterX() - getHitbox().getShape().getCenterX(),
                player.getHitbox().getShape().getCenterY() - getHitbox().getShape().getCenterY()
        );
    }

    public Shape getVision() {
        return vision;
    }

    abstract void castAttack (Vector2f direction, Map map);

    abstract Attitude getAttitude();

    public abstract void draw(Graphics g);
}