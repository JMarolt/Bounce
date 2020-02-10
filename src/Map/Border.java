package Map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Setup.Main;

public class Border {
	
	private int x, y;
	private int width, height;

	public Border(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);
		g.fillRect(x, Main.height - height, width, height);
	}
	
	public Rectangle collision() {
		return new Rectangle(x, y, width, height);
	}
	
	public Rectangle tcollision() {
		return new Rectangle(x, Main.height - height, width, height);
	}
	
}
