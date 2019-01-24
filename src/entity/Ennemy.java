package entity;

import java.util.*;
import java.util.stream.IntStream;

import entity.hitbox.Allegency;
import entity.hitbox.Element;
import org.newdawn.slick.geom.Circle;


/**
 * The enemies of the forest
 */
public class Ennemy extends Entity {

    private float visionRange;

    /**
     * Initialize a new entity which has a vision range
     * @param x,y : position
     * @param size : hitbox size
     */
    public Ennemy(float x, float y, float size, float movementSpeed, Allegency allegency, Element element, float visionRange) {
        super(x, y, size, movementSpeed, allegency, element);
        this.visionRange = visionRange;
    }

    public Ennemy() {
        super(400, 400, 36.0f, 0.1f, Allegency.Ally, Element.Water);
        this.visionRange = 150;
    }



    public void move(Player player, float delta) {
        //if the enemy's moving
        if (this.isMoving()) {

            float playerx = player.getHitbox().getShape().getX();
            float playery = player.getHitbox().getShape().getY();
            Circle visionRange =  new Circle(this.getHitbox().getShape().getX(), this.getHitbox().getShape().getY(), this.visionRange);
            float x = this.getHitbox().getShape().getX();
            float y = this.getHitbox().getShape().getY();

            //if it's in range of the player
            if (visionRange.contains(playerx, playery)) {
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