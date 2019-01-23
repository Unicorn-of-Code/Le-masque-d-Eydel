package entity.attack;

import java.util.*;

import entity.Entity;
import org.newdawn.slick.geom.Vector2f;

/**
 * Attack Fire 1
 */
public class Fire1 extends Attack {

    /**
     * Default constructor
     */
    public Fire1(Entity entity, Vector2f direction) {
    	super(entity);
    	stateStack.push(new Fire11(this, direction));
    }

}