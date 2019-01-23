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
	
	private Hud hud = new Hud();
	
	public map(int state) {
		
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		this.container = gc;
		// load map
		this.map = new TiledMap("resources/map/map.tmx");
		// load sprite
		player = new Player(400, 400);
		playerAnimations = player.getAnimation();
		this.hud.init();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		g.scale(2.5f, 2.5f);
		this.map.render(0, 0, 0);
		this.map.render(0, 0, 1);
		this.map.render(0, 0, 2);
	    this.map.render(0, 0, 3);
	    this.map.render(0, 0, 4);
	    this.map.render(0, 0, 5);
	    this.map.render(0, 0, 6);
	    this.map.render(0, 0, 7);
	    this.map.render(0, 0, 8);
	    //this.map.render(0, 0, 9);
	    this.map.render(0, 0, 10);
	    this.map.render(0, 0, 11);
	    this.map.render(0, 0, 12);
	    this.map.render(0, 0, 13);
	    
	 // Render sprite + shadow
		g.setColor(new Color(0, 0, 0, .5f));
	    g.fillOval(player.getX() - 31, player.getY() - 40, 16, 8);
	    g.drawAnimation(playerAnimations[player.getDirection() + (player.isMoving() ? 4 : 0)], (int) player.getX()-32, (int) player.getY()-60);
	 	
	    this.map.render(0, 0, 14);
		this.map.render(0, 0, 15);
		this.map.render(0, 0, 16);
		this.map.render(0, 0, 17);
		this.map.render(0, 0, 18);
		this.map.render(0, 0, 19);
	    this.hud.render(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
		player.move(gc, delta);
	}
	
	@Override
	public int getID() {
		return 0;
	}
}
	