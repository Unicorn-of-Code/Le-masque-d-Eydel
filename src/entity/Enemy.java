package entity;

import java.util.*;
import java.util.stream.IntStream;

import entity.attitude.Attitude;
import entity.hitbox.Allegency;
import entity.hitbox.Element;
import level.Map;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;


/**
 * The enemies of the forest
 */
public abstract class Enemy extends Entity {

    private Attitude attitude;
    private Shape vision;

    /**
     * Initialize a new entity which has a vision range
     * @param x,y : position
     * @param size : hitbox size
     */
    public Enemy(float x, float y, float size, float movementSpeed, Allegency allegency,
                 Element element, float visionRange, Attitude attitude) {
        super(x, y, size, movementSpeed, Allegency.Ennemy, element);
        this.vision = new Circle(this.getHitbox().getShape().getX(), this.getHitbox().getShape().getY(), visionRange);
    }

    /* Test
    public Enemy() {
        super(400, 400, 36.0f, 0.1f, Allegency.Ally, Element.Water);
        this.visionRange = 150;
    }
    */

    @Override
    void control (long deltaTime, Map map) {
        move(deltaTime, map.getPlayer());
    }

    public void move(float deltaTime, Player player) {
        //if the enemy's moving
        if (this.isMoving()) {

            float playerx = player.getHitbox().getShape().getX();
            float playery = player.getHitbox().getShape().getY();
            float x = this.getHitbox().getShape().getX();
            float y = this.getHitbox().getShape().getY();

            //if it's in range of the player
            if (vision.contains(playerx, playery)) {
                Circle attackRange =  new Circle(this.getHitbox().getShape().getX(), this.getAttack().getHitbox().getShape().getY(), this.attackRange);
                if (attackRange >= 5555) {
                    this.attack();
                } else {

                    Random random = new Random();
                    int randomInt = random.nextInt(400);
                    if (randomInt < 200) {
                        if (playerx - x > 0) {
                            this.getHitbox().getShape().setX(x + this.getMovementSpeed()*delta);
                        } else {
                            this.getHitbox().getShape().setX(x - this.getMovementSpeed()*delta);
                        }
                    } else if (randomInt <= 400) {
                        if (playery - y > 0) {
                            this.getHitbox().getShape().setY(y + this.getMovementSpeed()*delta);
                        } else {
                            this.getHitbox().getShape().setY(y - this.getMovementSpeed()*delta);
                        }
                    }
                }
            }
        }
    }

}