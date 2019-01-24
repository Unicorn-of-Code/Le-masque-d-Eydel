package entity.hitbox;

import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

/**
 * Hitbox for entities
 */
public class Hitbox {

    /**
     * Constructor
     * @param shape Shape of the hitbox
     * @param allegency Allegency of the hitbox
     * @param element Element of the hitbox
     */
    public Hitbox(Shape shape, Allegency allegency, Element element) {
        this.shape = shape;
        this.element = element;
        this.allegency = allegency;
    }

    public static final float tileSize = 16f;

    /**
     * Shape of the hitbox
     */
    private Shape shape;

    /**
     * Allegency of the hitbox, who will be touched
     */
    private Allegency allegency;

    /**
     * Elementof the hitbox
     */
    private Element element;

    /**
     * Set the element of the hitbox
     * @param element Element of the enumeration
     */
    public void setElement(Element element) {
        this.element = element;
    }

    /**
     * Set the allegency of the hitbox
     * @param allegency Allegency of the enumeration
     */
    public void setAllegency(Allegency allegency) {
        this.allegency = allegency;
    }

    /**
     * Get Element
     */
    public Element getElement() {
        return element;
    }

    /**
     * Get Allegency
     */
    public Allegency getAllegency() {
        return allegency;
    }
    
    /**
     * Return the shape of the hitbox
     * @return Shape
     */
    public Shape getShape () {
    	return shape;
    }

    /**
     * Test collision
     * @param hitbox Other hitbox
     * @return True if collide
     */
    public boolean collision (Hitbox hitbox) {
        return shape.intersects(hitbox.shape);
    }

    /**
     * move the hitbox
     * @param x x to add
     * @param y y to add
     */
    public void move(float x, float y) {
        shape.setX(shape.getX() + x);
        shape.setY(shape.getY() + y);
    }

    /**
     * Move the hitbox
     * @param v Vector to add
     */
    public void move(Vector2f v) {
        shape.setX(shape.getX() + v.getX());
        shape.setY(shape.getY() + v.getY());
    }
}