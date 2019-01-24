package entity.attack;

import entity.Entity;
import org.newdawn.slick.geom.Vector2f;

import java.util.*;

/**
 * 
 */
public class Water3 extends Attack {


    /**
     * Default constructor
     */
    public Water3(Entity entity, Vector2f direction) {
        super(entity);
        stateStack.push(new Water11(this, direction));
    }
}