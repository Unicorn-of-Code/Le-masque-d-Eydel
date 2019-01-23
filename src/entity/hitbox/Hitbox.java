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

    public boolean collision (Hitbox hitbox) {
        return shape.intersects(hitbox.shape);
    }

    /**
     * Move the hitbox from the given vector
     * @param vector Vector of the movement
     */
    public void move(Vector2f vector) {
        shape.setLocation(shape.getLocation().add(vector));
    }

    /**
     * Move the hitbox from the given x and y
     * @param x x to add
     * @param y y to add
     */
    public void move(float x, float y) {
        shape.setLocation(
                shape.getLocation().getX() + x,
                shape.getLocation().getY() + y);
    }

}