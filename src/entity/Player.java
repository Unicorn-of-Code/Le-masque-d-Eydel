package entity;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Player {

    /**
     * Default constructor
     */
    public Player() {
    	float x = 400;
		float y = 400;
    	int direction = 2;
    	boolean moving = false;
    	Animation[] animations = new Animation[8];
    	try {
			SpriteSheet spriteSheet = new SpriteSheet("src/resources/sprites/people/soldier.png", 64, 64);
			Animation animation = new Animation();
		    animation.addFrame(spriteSheet.getSprite(1, 1), 100);
		    animation.addFrame(spriteSheet.getSprite(2, 1), 100);
		    animation.addFrame(spriteSheet.getSprite(3, 1), 100);
		    animation.addFrame(spriteSheet.getSprite(4, 1), 100);
		    animation.addFrame(spriteSheet.getSprite(5, 1), 100);
		    animation.addFrame(spriteSheet.getSprite(6, 1), 100);
		    animation.addFrame(spriteSheet.getSprite(7, 1), 100);
		    animation.addFrame(spriteSheet.getSprite(8, 1), 100);
		    this.animations[5] = animation;
    	} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
        Animation animation = new Animation();
        for (int x = startX; x < endX; x++) {
            animation.addFrame(spriteSheet.getSprite(x, y), 100);
        }
        return animation;
    }

}