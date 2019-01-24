import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import level.*;

public class Main extends StateBasedGame {
	
	public static final String name = "Le masque d'Eydel";

	public Main(String name) {
		super(name);
		this.addState(new Splash(0));
		this.addState(new Map(1));
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.state.StateBasedGame#initStatesList(org.newdawn.slick.GameContainer)
	 */
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(0).init(gc, this);
		this.getState(1).init(gc, this);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AppGameContainer app;
		try {
			app = new AppGameContainer( new Main(name));
			app.setIcon("resources/hud/Icon.png");
			app.setDisplayMode( 1920, 1080, false);
			app.setShowFPS(false);
			app.start();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
