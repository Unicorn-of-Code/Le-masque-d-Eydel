package level;


import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Hud {
	
	private Image playerBars;
	private Image mask1;
	private Image mask2;
	private Image mask3;
	private Image spellbar;

	public void init() throws SlickException {
	    this.playerBars = new Image("resources/hud/health_bar_decoration.png");
	    this.mask1 = new Image("resources/hud/firemask.png");
	    this.mask2 = new Image("resources/hud/watermask.png");
	    this.mask3 = new Image("resources/hud/plantmask.png");
	    this.spellbar = new Image("resources/hud/spellbar.png");
	  }
	
	private static final int P_BAR_X = 40;
	private static final int P_BAR_Y = 60;
	private static final int BAR_X = 17 + P_BAR_X;
	private static final int LIFE_BAR_Y = 11+ P_BAR_Y;
	private static final int BAR_WIDTH = 200;
	private static final int BAR_HEIGHT = 32;
	private static final int MASKY= 125;
	private static final int MASK1X = 50;
	private static final int MASK2X= 125;
	
	private static final Color LIFE_COLOR = new Color(255, 0, 0);
	private static final Color CIRCLE_COLOR = new Color(0, 0, 0);
	private static final Color FILL_COLOR = new Color(255, 255, 255);

	public void render(Graphics g) {
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
		g.drawImage(this.mask1, MASK1X, MASKY);
		g.drawImage(this.mask2, MASK2X, MASKY);
		g.drawImage(this.spellbar,700, 750);
	}
}

