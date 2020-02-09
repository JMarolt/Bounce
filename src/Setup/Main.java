package Setup;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import Player.Player;

public class Main implements ActionListener, KeyListener{

	//important variables
	public static final int width = 1920;
	public static final int height = 1080;
	private JFrame f;
	private Panel p;
	private Timer timer;
	public static State currentState = State.GAME;
	//other variables
	static int px = 500;
	static int py = 500;
	static int pw = 50;
	static int ph = 50;
	public static Player player = new Player(px, py, pw, ph);
	boolean left = false;
	boolean right = false;
	boolean jump = false;     
	
	public Main() {
		
	}
	
	public void makeFrame() {
		f = new JFrame();
		f.setTitle("Bounce");
		f.setPreferredSize(new Dimension(width, height));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setFocusable(true);
		f.addKeyListener(this);
		makePanel();
		addToPanel();
		addToFrame();
		f.pack();
		f.setVisible(true);
		timer = new Timer(1000/60, this);
		timer.start();
	}
	
	public void addToFrame() {
		f.add(p);
	}
	
	public void addToPanel() {
		
	}
	
	public void makePanel() {
		p = new Panel();
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.makeFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		p.repaint();
		player.run();
		if(jump) {
			player.jump();
			jump = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 32) {
			jump = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
}
