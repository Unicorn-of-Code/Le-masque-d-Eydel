package entity;

import entity.attack.*;
import input.Input;
import level.Map;
import org.newdawn.slick.*;

import entity.hitbox.Allegency;
import entity.hitbox.Element;
import entity.hitbox.Hitbox;

import org.newdawn.slick.geom.Vector2f;
import time.Time;
import time.Timer;

/**
 * Class of the player
 */
public class Player extends Entity {


	// TODO : Gestion Dodge, timer stunt and immunity stunt

	private Animation[] animations = new Animation[8];
	private Vector2f look = new Vector2f(0, 0);
	private Timer[] timerAttack = new Timer[4];


	/**
     * Default constructor
     */
    public Player(float x, float y) {
    	super(x, y, Hitbox.tileSize, 0.1f, Allegency.Ally, Element.Water);
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

		// Set timers spell
		timerAttack[0] = Time.createTimer(100);
		timerAttack[1] = Time.createTimer(1000);
		timerAttack[2] = Time.createTimer(1000);
		timerAttack[3] = Time.createTimer(3000);
    }
    
    Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
        Animation animation = new Animation();
        for (int x = startX; x < endX; x++) {
            animation.addFrame(spriteSheet.getSprite(x, y), 80);
        }
        return animation;
    }

    @Override
	void control (long deltaTime, Map map, float xCam, float yCam, Player player) {
    	switchElement();
    	attack(map, xCam, yCam);
    	move(deltaTime);
	}

	private void switchElement () {
		if (Input.isSwitchLeft()) {
			switch (getHitbox().getElement()) {
				case Water: getHitbox().setElement(Element.Fire); break;
				case Plant: getHitbox().setElement(Element.Water); break;
				case Fire: getHitbox().setElement(Element.Plant); break;
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (Input.isSwitchRight()) {
			switch (getHitbox().getElement()) {
				case Water: getHitbox().setElement(Element.Plant); break;
				case Plant: getHitbox().setElement(Element.Fire); break;
				case Fire: getHitbox().setElement(Element.Water); break;
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void attack (Map map, float xCam, float yCam) {
    	if (Input.isA1()) {
    		if (timerAttack[0].getPassed()) {
    		
				switch (getHitbox().getElement()) {
					case Water: map.addAttack(new Water1(this, look.copy())); break;
					case Plant: map.addAttack(new Plant1(this, look.copy())); break;
					case Fire: map.addAttack(new Fire1(this, look.copy())); break;
				}
				timerAttack[0].reset();
			}
    		
		} else if (Input.isA2()) {
			if (timerAttack[1].getPassed()) {
				switch (getHitbox().getElement()) {
					case Water: map.addAttack(new Water2(this, look.copy())); break;
					case Plant: map.addAttack(new Plant2(this, look.copy())); break;
					case Fire: map.addAttack(new Fire2(this, look.copy())); break;
				}
				timerAttack[1].reset();
			}

		} else if (Input.isA3()) {
			if (timerAttack[2].getPassed()) {
				switch (getHitbox().getElement()) {
					case Water: map.addAttack(new Water3(this, look.copy())); break;
					case Plant: map.addAttack(new Plant3(this, look.copy())); break;
					case Fire: map.addAttack(new Fire3(this, look.copy())); break;
				}
				timerAttack[2].reset();
			}

		} else if (Input.isA4()) {

			if (timerAttack[3].getPassed()) {
				switch (getHitbox().getElement()) {
					case Water: map.addAttack(new Water4(this, look.copy())); break;
					case Plant: map.addAttack(new Plant4(this, look.copy())); break;
					case Fire: map.addAttack(new Fire4(this, look.copy())); break;
				}
				timerAttack[3].reset();
			}

		}
	}

	private void move(long deltaTime) {
    	look.set(Input.getMouseX() - getHitbox().getShape().getCenterX(),
				Input.getMouseY() - getHitbox().getShape().getCenterY());
		movement.set(0, 0);
		if (Input.getUp() > 0) {
			this.direction = 0;
			movement.add(new Vector2f(0, -1));
		}
		if (Input.getLeft() > 0) {
			this.direction = 1;
			movement.add(new Vector2f(-1, 0));
		}
		if (Input.getDown() > 0) {
			this.direction = 2;
			movement.add(new Vector2f(0, 1));
		}
		if (Input.getRight() > 0) {
			this.direction = 3;
			movement.add(new Vector2f(1, 0));
		}
		fixMovementWithSpeedAndDelta(deltaTime);
	}

	private void fixMovementWithSpeedAndDelta (long deltaTime) {
    	movement.normalise().scale(movementSpeed).scale(deltaTime);
	}
	
	public Animation[] getAnimation() {
		return this.animations;
	}

	/**
	 * Draw Player
	 * @param g Graphic Slick
	 */
	public void draw(Graphics g) {
		g.drawAnimation(animations[getDirection() + (isMoving() ? 4 : 0)], (int) getX()-1, (int) getY()-8);
		g.setColor(new Color(0, 0, 0, .5f));
		g.fillOval(getX(), getY()+12, 16, 8);
	}
}