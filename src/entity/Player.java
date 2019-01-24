package entity;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import entity.hitbox.Allegency;
import entity.hitbox.Element;

public class Player extends Entity {

	private Animation[] animations = new Animation[8];

	/**
     * Default constructor
     */
    public Player(float x, float y) {
    	super(x, y, 36.0f, 0.1f, Allegency.Ally, Element.Fire);
		try {
			SpriteSheet spriteSheet = new SpriteSheet("resources/sprites/people/PlayerWater.png", 18, 25);
			this.animations[0] = loadAnimation(spriteSheet, 0, 1, 0);
		    this.animations[1] = loadAnimation(spriteSheet, 0, 1, 1);
		    this.animations[2] = loadAnimation(spriteSheet, 0, 1, 2);
		    this.animations[3] = loadAnimation(spriteSheet, 0, 1, 3);
		    this.animations[4] = loadAnimation(spriteSheet, 1, 4, 0);
		    this.animations[5] = loadAnimation(spriteSheet, 1, 4, 1);
		    this.animations[6] = loadAnimation(spriteSheet, 1, 4, 2);
		    this.animations[7] = loadAnimation(spriteSheet, 1, 4, 3);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
        Animation animation = new Animation();
        for (int x = startX; x < endX; x++) {
            animation.addFrame(spriteSheet.getSprite(x, y), 80);
        }
        return animation;
    }
    
    public void move(GameContainer gc, int delta) {
		if (gc.getInput().isKeyDown(Input.KEY_UP)) {
			this.direction = 0; this.moving = true;
		}
		else if (gc.getInput().isKeyDown(Input.KEY_LEFT)) {
			this.direction = 1; this.moving = true;
		}
		else if (gc.getInput().isKeyDown(Input.KEY_DOWN)) {
			this.direction = 2; this.moving = true;
		}
		else if (gc.getInput().isKeyDown(Input.KEY_RIGHT)) {
			this.direction = 3; this.moving = true;
		}
		else {
			this.moving = false;
		}
		this.update(delta);
	}
	
	public Animation[] getAnimation() {
		return this.animations;
	}

}