package Setup;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panel extends JPanel{
	Font myFont = new Font("Serif", Font.BOLD, 60);
	
	private static final long serialVersionUID = 1L;

	public Panel() {
		
	}
	
	public void paintComponent(Graphics g) {
		if(Main.currentState == State.MENU) {
			loadTheBadSwingFont(g);
			displayMainMenu(g);
		}
		if(Main.currentState == State.GAME) {
			displayGame(g);
		}
		if(Main.currentState == State.DEAD) {
			displayDeathScreen(g);
		}
		Main.player.draw(g);
	}
	
	public void displayMainMenu(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Main.width, Main.height);
	}
	
	public void displayGame(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Main.width, Main.height);
		Main.borders.draw(g);
		Main.sides.draw(g);
	}
	
	public void loadTheBadSwingFont(Graphics g) {
		g.setColor(Color.black);
		String load = "l";
		g.drawString(load, 0, 0);
	}
	
	public void displayDeathScreen(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Main.width, Main.height);
		String text = "You're Dead";
		String restart = "Press Space To Restart";
		g.setFont(myFont);
		int w = g.getFontMetrics().stringWidth(text);
		int wr = g.getFontMetrics().stringWidth(restart);
		g.setColor(Color.white);
		g.drawString(text, (Main.width/2) - (w/2), Main.height/4 - 30);
		g.drawString(restart, (Main.width/2) - (wr/2), Main.height/4 + 30);
	}
	
}
