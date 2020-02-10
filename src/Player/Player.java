package Player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Setup.Direction;
import Setup.Main;
import Setup.State;

public class Player {

	private int x, y, width, height;
	
	//other variables
	int gravity = 1;
	int velocity = 0;
	int speed = 10;
	Direction direction = Direction.LEFT;
	
	public Player(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void run() {
		velocity += gravity;
		y += velocity;
		moveLeft();
		moveRight();
		if(x <= 0) {
			direction = Direction.RIGHT;
		}
		if(x >= (Main.width - width)) {
			direction = Direction.LEFT;
		}
	}
	
	public void jump() {
		velocity = -20;
	}
	
	public void die() {
		x = Main.width/2 - (width/2);
		y = Main.height/2 - (height/2);
		velocity = 0;
		direction = Direction.LEFT;
	}
	
	public void moveLeft() {
		if(direction == Direction.LEFT) {
			x -= speed;
		}
	}
	
	public void moveRight() {
		if(direction == Direction.RIGHT) {
			x += speed;
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.pink);
		g.fillRect(x, y, width, height);
	}
	
	public Rectangle collision() {
		return new Rectangle(getX(), getY(), getWidth(), getHeight());
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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
	
}
