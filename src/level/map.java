package level;

import entity.Enemy;
import entity.Entity;
import entity.attack.Attack;
import input.Input;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import entity.Player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Map extends BasicGameState{

	private GameContainer gc;
	private TiledMap map;
	
	private Player player;

	private List<Enemy> ennemies = new ArrayList<>();

	private List<Attack> attacks = new ArrayList<>();

	private Hud hud = new Hud();

	private Camera camera;

	public Map(int state) {
		
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		this.gc = gc;
		
		// load player
		player = new Player(150, 638);
		
		// load Map
		this.map = new TiledMap("resources/Map/Map.tmx");

		camera = new Camera(player);
		
		// load music
		Music background = new Music("resources/sound/game.ogg");
	    background.loop();
	    
	    // load hud
		hud=new Hud(player);
		this.hud.init();
	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
		// Update Input
		Input.update(gc);

		// Update Player
		// If true : Game Over
		player.update(delta, this);

		// Update Ennemies
		Iterator<Enemy> itEn = ennemies.iterator();
		while (itEn.hasNext()) {
			Enemy ennemy = itEn.next();
			if (ennemy.update(delta, this)) {
				itEn.remove();
			}
		}

		// Update Attack
		Iterator<Attack> itAt = attacks.iterator();
		while (itAt.hasNext()) {
			Attack attack = itAt.next();
			attack.update(delta, getEntities());
		}
	}

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		// Scalling screen
		g.scale(2.5f, 2.5f);
		// Place default position camera
		this.camera.place(gc, g);
		// Layout rendering
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
		

		// Render sprites
		
		// Render Animation added

		// Render Attacks
		for (Attack attack : attacks) {
			attack.draw(g);
		}

		// Render Player
		player.draw(g);

		// Render Ennemies
		for (Enemy ennemy : ennemies) {
			ennemy.draw(g);
		}
		this.map.render(0, 0, 14);
		this.map.render(0, 0, 15);
		this.map.render(0, 0, 16);
		this.map.render(0, 0, 17);
		this.map.render(0, 0, 18);
		this.map.render(0, 0, 19);
		this.map.render(0, 0, 20);
		this.map.render(0, 0, 21);
		
		this.hud.render(g);
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
		// Update Input
		Input.update(gc);

		// Update Player
		player.update(delta, this);
		
		// Update Camera
		this.camera.update(gc);

		// Update Ennemies
		Iterator<Ennemy> itEn = ennemies.iterator();
		while (itEn.hasNext()) {
			Ennemy ennemy = itEn.next();
			ennemy.update(delta, this);
		}

		// Update Attack
		Iterator<Attack> itAt = attacks.iterator();
		while (itAt.hasNext()) {
			Attack attack = itAt.next();
			attack.update(delta, getEntities());
		}
	}
	
	public boolean isCollision(float x, float y) {
	    int tileW = this.map.getTileWidth();
	    int tileH = this.map.getTileHeight();
	    int collisionLayer = this.map.getLayerIndex("Collision");
	    Image tile = this.map.getTileImage((int) x / tileW, (int) y / tileH, collisionLayer);
	    boolean collision = tile != null;
	    if (collision) {
	        Color color = tile.getColor((int) x % tileW, (int) y % tileH);
	        collision = color.getAlpha() > 0;
	    }
	    return collision;
	}
	
	@Override
	public int getID() {
		return 0;
	}

	/**
	 * Add attack which will update
	 * @param attack Attack to add
	 */
	public void addAttack(Attack attack) {
		attacks.add(attack);
	}

	/**
	 * Get all entities
	 * @return List of entities
	 */
	public List<Entity> getEntities() {
		List<Entity> en = new ArrayList<>(ennemies);
		en.add(player);
		return en;
	}

	/**
	 * Add animation to draw
	 * @param
	 */
	public void addAnimation (float x, float y) {
		// TODO : Animation to add to the screen
	}
}
	