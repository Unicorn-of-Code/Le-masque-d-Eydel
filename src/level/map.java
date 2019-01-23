package level;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;


public class map extends BasicGameState{

	private GameContainer container;
	private TiledMap map;
	
	public map(int state) {
		
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		this.container = gc;
		// load map
		this.map = new TiledMap("resources/map/TestMap.tmx");
		
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
	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
		
	}

	@Override
	public int getID() {
		return 0;
	}
}
	