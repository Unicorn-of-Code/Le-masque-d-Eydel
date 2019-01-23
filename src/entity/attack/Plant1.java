package entity.attack;

import entity.Entity;
import org.newdawn.slick.geom.Vector2f;

import java.util.*;

/**
 *  * Attack Plant 1
 */
public class Plant1 extends Attack {

    /**
     * Default constructor
     */
    public Plant1(Entity entity, Vector2f direction) {
        super(entity);
        stateStack.push(new Plant11(this, direction));
    }

}