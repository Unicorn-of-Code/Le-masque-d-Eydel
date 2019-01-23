package entity.attack;

import entity.Entity;
import entity.hitbox.Element;
import entity.hitbox.Hitbox;

import java.util.*;

/**
 * 
 */
public abstract class AttackState {

    /**
     * Constructor
     * @param damage Damage done by the AttackState
     * @param movement Movement of the AttackState's hitboxes
     * @param hitboxes Hitboxes of the AttackState
     */
    public AttackState(Attack attackProperty, int damage, Vector2f movement, ArrayList<Shape> shapes, Element element) {
        this.damage = damage;
        this.movement = movement;
        for (Shape shape : shapes) {
            hitboxes.add(new Hitbox(
                    shape,
                    attackProperty.getEntity().getHitbox().getAllegency(),  // Take the Allegency of the launcher
                    element));
        }
    }

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
     * @param deltaTime Delta Time
     * @return if the AttackState is finished
     */
    boolean update(long deltaTime) {
        for (Hitbox hitbox : hitboxes) {
            hitbox.move(movement);
        }
        return false;
    }

    /**
     * Return int damage
     * @return damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Return hitboxes
     * @return List<Hitbox> hitboxes
     */
    public List<Hitbox> getHitboxes() {
        return hitboxes;
    }

    /**
     * Return attackProperty
     * @return Attack attackProperty
     */
    public Attack getAttackProperty() {
        return attackProperty;
    }
}