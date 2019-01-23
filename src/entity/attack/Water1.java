package entity.attack;

import entity.Entity;
import org.newdawn.slick.geom.Vector2f;

import java.util.*;

/**
 *  * Attack Water 1
 */
public class Water1 extends Attack {

    /**
     * Default constructor
     */
    public Water1(Entity entity, Vector2f direction) {
        super(entity);
        stateStack.push(new Water11(this, direction));
    }

}