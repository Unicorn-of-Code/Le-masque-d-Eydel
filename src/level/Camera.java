package level;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import entity.Player;

public class Camera {

	private Player player;
	private float xCamera, yCamera;

	public Camera(Player player) {
		this.player = player;
		this.xCamera = player.getX();
		this.yCamera = player.getY();
	}
	
	public void place(GameContainer gc, Graphics g) {
		g.translate(gc.getWidth() / 2 - (int) this.xCamera, gc.getHeight() / 2 - (int) this.yCamera -270);
	}
	
	public void update(GameContainer gc) {
		// move camera
		if (this.player.getX() > this.xCamera)this.xCamera = this.player.getX();
		if (this.player.getX() < this.xCamera)this.xCamera = this.player.getX() + 550;
		// Border map
		if (this.xCamera - (gc.getWidth() / 2) < 0) this.xCamera = gc.getWidth() / 2;
		if (this.xCamera + (gc.getWidth() / 2) > gc.getWidth() * 16) this.xCamera = gc.getWidth() * 16 - gc.getWidth() / 2;
		
		int h = gc.getHeight() / 10;
		if (this.player.getY() > this.yCamera+h) this.yCamera = this.player.getY()-h;
		if (this.player.getY() < this.yCamera-h) this.yCamera = this.player.getY()+h;
		// Border map
		if (this.yCamera - (gc.getHeight() / 5) < 0) this.yCamera = gc.getHeight() / 5;
		if (this.yCamera + (gc.getHeight() / 5) > gc.getHeight() * 16) this.yCamera = gc.getHeight() * 16 - gc.getHeight() / 5;
	}
	
	public float getX() {
		return this.xCamera;
	}
}
