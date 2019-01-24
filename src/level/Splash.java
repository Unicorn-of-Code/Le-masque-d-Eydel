package level;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;

public class Splash extends BasicGameState{
	
	private float time;
	private Image logo;
	private int tempo;
	public Splash(int state){
		
	}

	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		// TODO Auto-generated method stub
		time = 0;
		tempo = 0;
		logo = new Image("resources/logo.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		g.drawImage(logo, 0, 0);
		logo.setAlpha(0);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
		// TODO Auto-generated method stub
		switch(tempo) {
		
		case 0:
			time+=delta;
			if(time>2000) {
				tempo=1;
			}
			break;
			
		case 1:
			time-=delta;
			if(time<100) {
				s.enterState(1);
			}
			break;
		}
			
		logo.setAlpha(time/2000);
		
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
