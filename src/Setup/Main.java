package Setup;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import Map.Border;
import Map.Sides;
import Player.Player;

public class Main implements ActionListener, KeyListener{

	//important variables
	public static final int width = 1920;
	public static final int height = 1080;
	private JFrame f;
	private Panel p;
	private Timer timer;
	public static State currentState = State.MENU;
	//other variables
	static int pw = 50;
	static int ph = 50;
	static int px = (width/2) - (pw/2);
	static int py = (height/2) - (ph/2);
	public static Player player = new Player(px, py, pw, ph);
	public static Border borders = new Border(0, 0, 1920, 2);
	public static Sides sides = new Sides(-30, 0, 1910, 0, 40, 1920);
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
	}
	
	public void addToFrame() {
		f.add(p);
	}
	
	public void addToPanel() {
		
	}
	
	public void makePanel() {
		p = new Panel();
	}
	
	public void start() {
		timer.start();
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.makeFrame();
		main.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		p.repaint();
		player.run();
		if(jump) {
			player.jump();
			jump = false;
		}
		if(player.collision().intersects(borders.collision()) || player.collision().intersects(borders.tcollision())) {
			player.die();
			currentState = State.DEAD;
			sides.setAmount(sides.getAmount() + 1);
		}
		System.out.println(sides.getAmount());
	}
 
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 32) {
			jump = true;
		}
		if(e.getKeyCode() == 32 && currentState == State.DEAD) {
			currentState = State.GAME;
		}
		if(e.getKeyCode() == 32 && currentState == State.MENU) {
			currentState = State.GAME;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
}
