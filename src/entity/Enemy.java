package entity;

import java.util.*;
import java.util.stream.IntStream;

import entity.attitude.Attitude;
import entity.hitbox.Allegency;
import entity.hitbox.Element;
import level.Map;
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

    /**
     * Initialize a new entity which has a vision range
     * @param x,y : position
     * @param size : hitbox size
     */
    public Enemy(float x, float y, float size, float movementSpeed, float movementSpeedFast,
                 Element element, float visionRange) {
        super(x, y, size, movementSpeed, Allegency.Ennemy, element);
        this.vision = new Circle(this.getHitbox().getShape().getX(), this.getHitbox().getShape().getY(), visionRange);
        this.movementSpeedFast = movementSpeedFast;
        this.attitude = getAttitude();
    }

    /* Test
    public Enemy() {
        super(400, 400, 36.0f, 0.1f, Allegency.Ally, Element.Water);
        this.visionRange = 150;
    }
    */

    @Override
    void control (long deltaTime, Map map) {
        vision.setCenterX(getHitbox().getShape().getCenterX());
        vision.setCenterY(getHitbox().getShape().getCenterY());
        attitude.update(deltaTime, map.getPlayer());
        if (attitude.isAttackCast()) {
            castAttack(getDirectionPlayer(map.getPlayer()), map);
        } else if (attitude.isMoving()) {
            movement.normalise().scale( (attitude.isCool())? movementSpeed : movementSpeed).setTheta(attitude.getAngleDirection());
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


    @Override
    public void draw(Graphics g) {

    }
}