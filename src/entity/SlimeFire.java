package entity;

import entity.attack.AttackState;
import entity.attack.Fire11;
import entity.attitude.Attitude;
import entity.hitbox.Allegency;
import entity.hitbox.Element;
import entity.hitbox.Hitbox;
import level.Map;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Vector2f;

public class SlimeFire extends Enemy {
	
	private Animation[] animations = new Animation[8];

    public SlimeFire(float x, float y) {
        super(x, y, Hitbox.tileSize, 3f, 0.13f,
                Element.Fire, 8);
        try {
			SpriteSheet spriteSheet = new SpriteSheet("resources/sprites/monsters/slimeRed.png", 24, 24);
			this.animations[0] = loadAnimation(spriteSheet, 0, 1, 0);
		    this.animations[1] = loadAnimation(spriteSheet, 0, 1, 1);
		    this.animations[2] = loadAnimation(spriteSheet, 0, 1, 2);
		    this.animations[3] = loadAnimation(spriteSheet, 0, 1, 3);
		    this.animations[4] = loadAnimation(spriteSheet, 1, 3, 0);
		    this.animations[5] = loadAnimation(spriteSheet, 1, 3, 1);
		    this.animations[6] = loadAnimation(spriteSheet, 1, 3, 2);
		    this.animations[7] = loadAnimation(spriteSheet, 1, 3, 3);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @Override
    void castAttack (Vector2f direction, Map map) {
        //map.addAttack(new Fire1(this, direction));
    }

    @Override
    Attitude getAttitude() {
        return new Attitude(this, false, 700, 550,
                50, 300, 10);
    }
    
    Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
        Animation animation = new Animation();
        for (int x = startX; x < endX; x++) {
            animation.addFrame(spriteSheet.getSprite(x, y), 80);
        }
        return animation;
    }
    
    public void draw(Graphics g) {
		g.drawAnimation(animations[getDirection() + (isMoving() ? 4 : 0)], (int) getX()-4, (int) getY()-5);
	}

}
