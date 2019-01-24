package entity.attack;

import entity.Entity;
import entity.hitbox.Element;
import entity.hitbox.Hitbox;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

import java.util.*;

/**
 * 
 */
public abstract class AttackState {


    /**
     * Constructor
     * @param attackProperty Attack which has launhed
     * @param damage   Damage done by the AttackState
     * @param element Element of the attack
     * @param maxRange Range max reached
     */
    private AttackState(Attack attackProperty, int damage,
                        Element element, float maxRange) {
        this(attackProperty, damage, new Vector2f(0, 0), element, maxRange);
    }

    /**
     * Constructor
     * @param attackProperty Attack which has launhed
     * @param damage   Damage done by the AttackState
     * @param movement Movement of the hitbox
     * @param element Element of the attack
     * @param maxRange Range max reached
     */
    AttackState(Attack attackProperty, int damage, Vector2f movement,
                Element element, float maxRange) {
        this.damage = damage;
        for (Shape shape : getShapeArrayList(attackProperty, movement)) {
            hitboxes.add(new Hitbox(
                    shape,
                    attackProperty.getEntity().getHitbox().getAllegency(),  // Take the Allegency of the launcher
                    element));
        }
        this.maxRange = maxRange;
        this.movement = movement;
    }

    /**
     * Max range capable
     */
    private float maxRange = 1;

    /**
     * Range reached
     */
    private float currentRange;


    /**
     * Damage done by the Attack
     */
    private int damage;

    /**
     * Vector of the movement of the AttackState's Hitbox
     */
    private Vector2f movement;

    /**
     * The Attack which this AttackState is based on based
     */
    private Attack attackProperty;

    /**
     * Hitboxes of the AttackState
     */
    private List<Hitbox> hitboxes = new ArrayList<Hitbox>();

    /**
     * Update the AttackState with the delta Time
     *
     * @param deltaTime Delta Time
     * @return if the AttackState is finished
     */
    abstract boolean update(long deltaTime, List<Entity> entities);

    public boolean uniqueCollide(List<Entity> entities) {
        for (Entity entity : entities) {
            for (Hitbox hitbox : hitboxes) {
                if (hitbox.collision(entity.getHitbox())) {
                    if (hitbox.getAllegency() != entity.getHitbox().getAllegency()) {
                        DamageCalculation.attributeDamage(this, entity);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean collideMultiEntity(List<Entity> entities) {
        boolean collide = false;
        for (Entity entity : entities) {
            for (Hitbox hitbox : hitboxes) {
                if (hitbox.collision(entity.getHitbox())) {
                    if (hitbox.getAllegency() != entity.getHitbox().getAllegency()) {
                        DamageCalculation.attributeDamage(this, entity);
                        collide = true;
                    }
                }
            }
        }
        return collide;
    }

    public void collide(List<Entity> entities) {
        for (Entity entity : entities) {
            for (Hitbox hitbox : hitboxes) {
                if (hitbox.collision(entity.getHitbox())) {
                    DamageCalculation.attributeDamage(this, entity);
                }
            }
        }
    }

    public boolean moveHitboxes(long deltaTime) {
        Iterator<Hitbox> i = hitboxes.iterator();
        while (i.hasNext()) {
            Hitbox hitbox = i.next();
            Vector2f currentMovement = new Vector2f(movement).scale(deltaTime);
            hitbox.move(currentMovement);
            currentRange += currentMovement.length();
            if (currentRange >= maxRange) {
                i.remove();
            }

        }
        if (hitboxes.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * Return int damage
     *
     * @return damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Return hitboxes
     *
     * @return List<Hitbox> hitboxes
     */
    public List<Hitbox> getHitboxes() {
        return hitboxes;
    }

    /**
     * Return attackProperty
     *
     * @return Attack attackProperty
     */
    public Attack getAttackProperty() {
        return attackProperty;
    }

    abstract ArrayList<Shape> getShapeArrayList(Attack attackProperty, Vector2f direction);

    /**
     * Draw AttackState
     * @param g Graphic Slick
     */
    public void draw(Graphics g) {
        for (Hitbox hitbox : hitboxes) {
            // TODO : Draw sprite on each hitbox
        }
    }
}