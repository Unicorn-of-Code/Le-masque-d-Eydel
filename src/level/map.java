package level;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import entity.Player;

public class map extends BasicGameState{

	private GameContainer container;
	private TiledMap map;
	
	private static Player player;
	private static Animation[] playerAnimations; 
	
	public map(int state) {
		
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		this.container = gc;
		// load map
		this.map = new TiledMap("resources/map/map.tmx");
		// load sprite
		player = new Player();
		playerAnimations = player.getAnimation();
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
	    this.map.render(0, 0, 8);
	    this.map.render(0, 0, 9);
	    this.map.render(0, 0, 10);
	    this.map.render(0, 0, 11);
	    this.map.render(0, 0, 12);
	    this.map.render(0, 0, 13);
	    this.map.render(0, 0, 14);
		this.map.render(0, 0, 15);
		this.map.render(0, 0, 16);	
		
	    
	 // Render sprite + shadow
		g.setColor(new Color(0, 0, 0, .5f));
	    g.fillOval(player.getX() - 30, player.getY() - 23, 32, 16);
	    g.drawAnimation(playerAnimations[player.getDirection() + (player.isMoving() ? 4 : 0)], (int) player.getX()-32, (int) player.getY()-60);
	 	     	    
	    
		this.map.render(0, 0, 17);
		this.map.render(0, 0, 18);
		this.map.render(0, 0, 19);
		this.map.render(0, 0, 20);
		this.map.render(0, 0, 21);
		this.map.render(0, 0, 22);
		this.map.render(0, 0, 23);
		this.map.render(0, 0, 24);
	    
	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
		player.move(gc);
		updateCharacter(delta);
	}
	
	private void updateCharacter(int delta) {
		if (player.isMoving()) {
			float futurX = getFuturX(delta);
			float futurY = getFuturY(delta);
			boolean collision = isCollision(futurX, futurY);
			if (collision) {
				player.setMoving(false);
			} else {
				player.setX(futurX);
				player.setY(futurY);
			}
		}
}
	
	private boolean isCollision(float x, float y) {
		int tileW = this.map.getTileWidth();
		int tileH = this.map.getTileHeight();
		int logicLayer = this.map.getLayerIndex("Collision");
		Image tile = this.map.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
		boolean collision = tile != null;
		if (collision) {
			Color color = tile.getColor((int) x % tileW, (int) y % tileH);
			collision = color.getAlpha() > 0;
		}
		return collision;
}

	private float getFuturX(int delta) {
		float futurX = player.getX();
		switch (player.getDirection()) {
		case 1:
			futurX = player.getX() - .1f * delta;
			break;
		case 3:
			futurX = player.getX() + .1f * delta;
			break;
		}
		return futurX;
	}

	private float getFuturY(int delta) {
		float futurY = player.getY();
		switch (player.getDirection()) {
		case 0:
			futurY = player.getY() - .1f * delta;
			break;
		case 2:
			futurY = player.getY() + .1f * delta;
			break;
		}
		return futurY;
}
	
	
	
	
	
	@Override
	public int getID() {
		return 0;
	}
}
	