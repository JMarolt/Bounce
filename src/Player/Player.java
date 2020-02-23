package Player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Setup.Direction;
import Setup.Main;
import Setup.State;

public class Player {

	private int x, y, width, height;

	// other variables
	int gravity = 1;
	int velocity = 0;
	int speed = 10;
	Direction direction = Direction.LEFT;
	Color[] possibleColors;
	Color color = Color.pink;

	public Player(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void run() {
		addRandomColors();
		if (Main.currentState == State.GAME) {
			velocity += gravity;
			y += velocity;
			moveLeft();
			moveRight();
			if (collision().intersects(Main.sides.lcollision())) {
				direction = Direction.RIGHT;
			}
			if (collision().intersects(Main.sides.rcollision())) {
				direction = Direction.LEFT;
			}
			if(x == ((Main.width/2) - Main.player.getWidth()/2)) {
				switchColors();
			}
		}
	}

	public void jump() {
		velocity = -20;
	}

	public void die() {
		x = Main.width / 2 - (width / 2);
		y = Main.height / 2 - (height / 2);
		velocity = 0;
		direction = Direction.LEFT;
	}

	public void moveLeft() {
		if (direction == Direction.LEFT) {
			x -= speed;
		}
	}

	public void moveRight() {
		if (direction == Direction.RIGHT) {
			x += speed;
		}
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}
	
	public void addRandomColors() {
		possibleColors = new Color[5];
		possibleColors[0] = Color.pink;
		possibleColors[1] = Color.red;
		possibleColors[2] = Color.green;
		possibleColors[3] = Color.blue;
		possibleColors[4] = Color.yellow;
	}
	
	public void switchColors() {
		int i = (int) (Math.random()*5);
		while(color == possibleColors[i]) {
			i = (int) (Math.random()*5);
		}
		color = possibleColors[i];
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
