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
	}
	
	public void displayDeathScreen(Graphics g) {
		String text = "You're Dead AF";
		g.setFont(myFont);
		//int w = g.getFontMetrics().stringWidth(text);
		g.setColor(Color.white);
		//g.drawString(text, (Main.width/2) - (2/2), Main.height/2);
	}
	
}
