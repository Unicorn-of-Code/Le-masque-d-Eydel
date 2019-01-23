package entity.attack;

import entity.Entity;
import entity.hitbox.Element;
import entity.hitbox.Hitbox;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

import java.util.ArrayList;
import java.util.List;

class Plant11 extends AttackState {

    /**
     * Constructor
     *  @param attackProperty
     *
     */
    Plant11(Attack attackProperty, Vector2f direction) {
        super(attackProperty, 4, direction.normalise().scale(0.1f),
                Element.Water,
                10 * Hitbox.tileSize);
    }

    @Override
    boolean update (long deltaTime, List<Entity> entities) {
        collide(entities);
        return true;
    }

    @Override
    ArrayList<Shape> getShapeArrayList(Attack attackProperty, Vector2f direction) {
        float[] arrayPoints = new float[10];

        Vector2f center = new Vector2f(attackProperty.getEntity().getHitbox().getShape().getCenterX(),
                attackProperty.getEntity().getHitbox().getShape().getCenterY());

        Vector2f angleV = new Vector2f(direction).normalise().scale(2*Hitbox.tileSize).add((double)120/2);
        // Vecteur longueur 2 tilesize avec rotate de 120/2 degrees


        Vector2f firstVector =  direction.copy().normalise().scale(Hitbox.tileSize/2);

        Vector2f u = center.copy().add(firstVector);
        arrayPoints[0] =
                arrayPoints[1] = firstVector.copy().add(firstVector).getX();

        for (int i = 2; i < 10; i++) {
            Vector2f v = center.copy().add(firstVector).add(angleV);
            arrayPoints[i++] = v.getX();
            arrayPoints[i] = v.getY();
            angleV.add((double) (120/3));
        }

        Shape shape = new Polygon(arrayPoints);
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        shapes.add(shape);
        return shapes;
    }
}
