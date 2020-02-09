package Setup;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panel extends JPanel{
	
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
	}
	
	public void displayDeathScreen(Graphics g) {
		
	}
	
}
