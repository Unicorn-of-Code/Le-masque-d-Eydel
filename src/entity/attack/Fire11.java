package entity.attack;

import entity.Entity;
import entity.hitbox.Element;
import entity.hitbox.Hitbox;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

import java.util.ArrayList;
import java.util.List;

public class Fire11 extends AttackState {

    /**
     * Constructor
     *
     * @param attackProperty
     */
    public Fire11(Attack attackProperty, Vector2f direction) {
        super(attackProperty, 30, direction.normalise().scale(0.1f),
                Element.Fire,
                6 * Hitbox.tileSize);
    }

    @Override
    boolean update(long deltaTime, List<Entity> entities) {
        if (collideMultiEntity(entities)) {
            return true;
        }
        return (moveHitboxes(deltaTime));
    }

    @Override
    ArrayList<Shape> getShapeArrayList(Attack attackProperty, Vector2f direction) {
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        shapes.add(new Rectangle(attackProperty.getEntity().getX(), attackProperty.getEntity().getY(),
                Hitbox.tileSize, Hitbox.tileSize));
        return shapes;
    }
    
    /**
     * Draw AttackState
     * @param g Graphic Slick
     */
    public void draw(Graphics g) {
        for (Hitbox hitbox : hitboxes) {
        	g.setColor(new Color(1f, 0, 0, 1f));
        	g.draw(hitbox.getShape());
        	g.fill(hitbox.getShape());
        }
    }
}
