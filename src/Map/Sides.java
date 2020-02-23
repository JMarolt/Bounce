package Map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Sides {

	int lx, ly, rx, ry;
	int width, height;
	
	int amount = 1;
	
	public Sides(int lx, int ly, int rx, int ry, int width, int height) {
		this.lx = lx;
		this.ly = ly;
		this.rx = rx;
		this.ry = ry;
		this.width = width;
		this.height = height;
	}
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g.setColor(Color.red);
		g2d.fillRoundRect(lx, ly, width, height, 10, 10);
		g2d.fillRoundRect(rx, ry, width, height, 10, 10);
	}
	
	public Rectangle rcollision() {
		return new Rectangle(getRx(), getRy(), getWidth(), getHeight());
	}
	
	public Rectangle lcollision() {
		return new Rectangle(getLx(), getLy(), getWidth(), getHeight());
	}

	public int getLx() {
		return lx;
	}

	public void setLx(int lx) {
		this.lx = lx;
	}

	public int getLy() {
		return ly;
	}

	public void setLy(int ly) {
		this.ly = ly;
	}

	public int getRx() {
		return rx;
	}

	public void setRx(int rx) {
		this.rx = rx;
	}

	public int getRy() {
		return ry;
	}

	public void setRy(int ry) {
		this.ry = ry;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
