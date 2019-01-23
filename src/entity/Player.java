package entity;

import input.Input;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import entity.hitbox.Allegency;
import entity.hitbox.Element;
import org.newdawn.slick.geom.Vector2f;

public class Player extends Entity {

	private Animation[] animations = new Animation[8];

	/**
     * Default constructor
     */
    public Player(float x, float y) {
    	super(x, y, 36.0f, 0.1f, Allegency.Ally, Element.Water);
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

    @Override
	public void move (long deltaTime) {
    	movement.set(0, 0);
		if (Input.getUp() > 0) {
			this.direction = 0; movement.add(new Vector2f(0, -1));
		}
		if (Input.getLeft() > 0) {
			this.direction = 1; movement.add(new Vector2f( -1, 0));
		}
			if (Input.getDown() > 0) {
			this.direction = 2; movement.add(new Vector2f(0, 1));
		}
				if (Input.getRight() > 0) {
			this.direction = 3; movement.add(new Vector2f(1, 0 ));
		}
		fixMovementWithSpeedAndDelta(deltaTime);
	}

	private void fixMovementWithSpeedAndDelta (long deltaTime) {
    	movement.normalise().scale(movementSpeed).scale(deltaTime);
	}
	
	public Animation[] getAnimation() {
		return this.animations;
	}

	public void draw() {
    	// TODO : Retrieve from map
	}
}