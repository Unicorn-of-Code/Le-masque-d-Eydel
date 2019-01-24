package entity;

import entity.attack.Fire1;
import entity.attitude.Attitude;
import entity.hitbox.Allegency;
import entity.hitbox.Element;
import entity.hitbox.Hitbox;
import level.Map;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

public class SlimeFire extends Enemy {

    SlimeFire(float x, float y, float size, float movementSpeed,
              float movementSpeedFast,
              Element element, float visionRange, Attitude attitude) {
        super(x, y, Hitbox.tileSize, 0.1f, 0.13f,
                Element.Fire, Hitbox.tileSize*10);

    }

    @Override
    void castAttack (Vector2f direction, Map map) {
        map.addAttack(new Fire1(this, direction));
    }

    @Override
    Attitude getAttitude() {
        return new Attitude(this, false, 700, 550,
                50, 300, 10);
    }

}
