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
	    
	 // Render sprite + shadow
		g.setColor(new Color(0, 0, 0, .5f));
	    g.fillOval(player.getX() - 30, player.getY() - 23, 32, 16);
	    g.drawAnimation(playerAnimations[player.getDirection() + (player.isMoving() ? 4 : 0)], (int) player.getX()-32, (int) player.getY()-60);
	 	     	    
	    //this.map.render(0, 0, 14);
		this.map.render(0, 0, 15);
		this.map.render(0, 0, 16);
		this.map.render(0, 0, 17);
		this.map.render(0, 0, 18);
		this.map.render(0, 0, 19);
	    
	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
		player.move(gc);
		if (player.isMoving()) {
	        switch (player.getDirection()) {
	            case 0: player.setY(player.getY() - .1f * delta); break;
	            case 1: player.setX(player.getX() - .1f * delta); break;
	            case 2: player.setY(player.getY() + .1f * delta); break;
	            case 3: player.setX(player.getX() + .1f * delta); break;
	            //case 4: this.y -= .1f * delta; this.x -= .1f * delta; break;
	        }
	    }
	}
	
	@Override
	public int getID() {
		return 0;
	}
}
	