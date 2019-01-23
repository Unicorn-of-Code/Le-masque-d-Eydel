package level;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class map extends BasicGameState{

	private GameContainer container;
	private TiledMap map;
	
	/*
	 * Sprite
	 */
	private float x = 400, y = 50;
	private int direction = 2;
	private boolean moving = false;
	private Animation[] animations = new Animation[8];
	
	public map(int state) {
		
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		this.container = gc;
		// load map
		this.map = new TiledMap("resources/map/TestMap.tmx");
		// load sprite
		SpriteSheet spriteSheet = new SpriteSheet("resources/sprites/people/playerWater.png", 36, 50);
		this.animations[0] = loadAnimation(spriteSheet, 0, 1, 0);
	    this.animations[1] = loadAnimation(spriteSheet, 0, 1, 1);
	    this.animations[2] = loadAnimation(spriteSheet, 0, 1, 2);
	    this.animations[3] = loadAnimation(spriteSheet, 0, 1, 3);
	    this.animations[4] = loadAnimation(spriteSheet, 1, 5, 0);
	    this.animations[5] = loadAnimation(spriteSheet, 1, 5, 1);
	    this.animations[6] = loadAnimation(spriteSheet, 1, 5, 2);
	    this.animations[7] = loadAnimation(spriteSheet, 1, 5, 3);
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		this.map.render(0, 0, 0);
		this.map.render(0, 0, 1);
		this.map.render(0, 0, 2);
	    this.map.render(0, 0, 3);
	    this.map.render(0, 0, 4);
	    this.map.render(0, 0, 5);
	    this.map.render(0, 0, 6);
	    this.map.render(0, 0, 7);
	    
	 // Render sprite + shadow
 		g.setColor(new Color(0, 0, 0, .5f));
 	    g.fillOval(x - 16, y - 8, 32, 16);
 	    g.drawAnimation(animations[direction + (moving ? 4 : 0)], (int) x-32, (int) y-60);
	 	     	    
	    this.map.render(0, 0, 8);
	    this.map.render(0, 0, 9);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
		if (this.moving) {
	        switch (this.direction) {
	            case 0: this.y -= .1f * delta; break;
	            case 1: this.x -= .1f * delta; break;
	            case 2: this.y += .1f * delta; break;
	            case 3: this.x += .1f * delta; break;
	        }
	    }
	}
	
	@Override
    public void keyReleased(int key, char c) {
        this.moving = false;
    }
	
	@Override
	public void keyPressed(int key, char c) {
	    switch (key) {
	        case Input.KEY_UP:    this.direction = 0; this.moving = true; break;
	        case Input.KEY_LEFT:  this.direction = 1; this.moving = true; break;
	        case Input.KEY_DOWN:  this.direction = 2; this.moving = true; break;
	        case Input.KEY_RIGHT: this.direction = 3; this.moving = true; break;
	    }
	}
	
	private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
	    Animation animation = new Animation();
	    for (int x = startX; x < endX; x++) {
	        animation.addFrame(spriteSheet.getSprite(x, y), 100);
	    }
	    return animation;
	}
	
	@Override
	public int getID() {
		return 0;
	}
}
	