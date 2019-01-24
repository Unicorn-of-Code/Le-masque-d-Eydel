package level;


import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import entity.Player;
import entity.hitbox.Element;

public class Hud {
	
	public Hud(Player player) {
		this.player=player;
	}
	
	private Player player;
	private Image playerBars;
	private Image firemask;
	private Image watermask;
	private Image plantmask;
	private Image spellbarfire;
	private Image spellbarwater;
	private Image spellbarplant;
	private Image scrollup;
	private Image scrolldown;

	public void init() throws SlickException {
	    this.playerBars = new Image("resources/hud/health_bar_decoration.png");
	    this.firemask = new Image("resources/hud/firemask.png");
	    this.watermask = new Image("resources/hud/watermask.png");
	    this.plantmask = new Image("resources/hud/plantmask.png");
	    this.spellbarfire = new Image("resources/hud/spellbarfire.png");
	    this.spellbarwater = new Image("resources/hud/spellbarwater.png");
	    this.spellbarplant = new Image("resources/hud/spellbarplant.png");
	    this.scrollup = new Image("resources/hud/scrollup.png");
	    this.scrolldown = new Image("resources/hud/scrolldown.png");
	  }
	
	private static final int P_BAR_X = 40;
	private static final int P_BAR_Y = 60;
	private static final int BAR_X = 17 + P_BAR_X;
	private static final int LIFE_BAR_Y = 11+ P_BAR_Y;
	private static final int BAR_WIDTH = 200;
	private static final int BAR_HEIGHT = 32;
	private static final int MASKY= 125;
	private static final int MASKGX = 50;
	private static final int MASKDX= 125;
	
	private static final Color LIFE_COLOR = new Color(255, 0, 0);
	private static final Color CIRCLE_COLOR = new Color(0, 0, 0);
	private static final Color FILL_COLOR = new Color(255, 255, 255);

	public void render(Graphics g) {
		System.err.println("coucou");
		Element element=player.getHitbox().getElement();
		System.err.println(element);
		g.resetTransform();
		g.setColor(LIFE_COLOR);
		g.fillRect(BAR_X, LIFE_BAR_Y, .9f * BAR_WIDTH, BAR_HEIGHT);
		g.setLineWidth(7);
		g.setColor(CIRCLE_COLOR);
		g.drawOval(50, 125, 60, 60);
		g.drawOval(125, 125, 60, 60);
		g.setColor(FILL_COLOR);
		g.fillOval(50, 125, 60, 60);
		g.fillOval(125, 125, 60, 60);
		g.drawImage(this.playerBars, P_BAR_X, P_BAR_Y);
		switch(element) {
		case Water:{
			g.drawImage(this.firemask, MASKGX, MASKY);
			g.drawImage(this.plantmask, MASKDX, MASKY);
			g.drawImage(this.spellbarwater,700, 750);
			break;
		}
		case Fire:{
			g.drawImage(this.watermask, MASKGX, MASKY);
			g.drawImage(this.plantmask, MASKDX, MASKY);
			g.drawImage(this.spellbarfire,700, 750);
			break;
		}
		case Plant:{
			g.drawImage(this.firemask, MASKGX, MASKY);
			g.drawImage(this.watermask, MASKDX, MASKY);
			g.drawImage(this.spellbarplant,700, 750);
			break;
		}
		}
		
		g.drawImage(this.scrolldown,47,160);
		g.drawImage(this.scrollup,122,160);
	}
}

