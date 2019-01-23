package entity;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Player {

	private Animation[] animations = new Animation[8];
	private float x, y;
	private int direction;
	private boolean moving;

	/**
     * Default constructor
     */
    public Player() {
    	setX(400);
    	setY(400);
    	setDirection(2);
    	setMoving(false);
		try {
			SpriteSheet spriteSheet = new SpriteSheet("resources/sprites/people/playerWater.png", 36, 50);
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
    
    public void move(GameContainer gc) {
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
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	
	public Animation[] getAnimation() {
		return this.animations;
	}

}