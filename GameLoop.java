import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;

import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.*;

public class GameLoop extends JPanel implements KeyListener {
	private Timer gameTimer;
	private Player player;
	private Enemy enemy;
	private final Set<Integer> pressedKeys = new HashSet<>();
	
	public GameLoop(Player player, Enemy enemy) {
		setDoubleBuffered(true);
		gameTimer = new Timer(16, e -> gameLoop());
		gameTimer.start();
		this.setFocusable(true);
		this.addKeyListener(this);
		this.player = player;
		this.enemy = enemy;
	}
	private void gameLoop() {
		handleInput();
		if (enemy.isAlive()) {
			enemy.update(getWidth());
		}
		player.updateBullet();
		checkCollissonBulletEnemy();
		repaint();
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		player.draw(g);
		if (enemy.isAlive()) {
			enemy.draw(g);
		}

	}
	@Override
	public void keyReleased(KeyEvent e) {
		pressedKeys.remove(e.getKeyCode());
	}

	@Override
	public void keyPressed(KeyEvent e) {
	    pressedKeys.add(e.getKeyCode());
	    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
		player.shoot();
	    }
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	private void handleInput() {
		for (int key : pressedKeys) {
        		switch (key) {
            			case KeyEvent.VK_W -> player.move(0, -5, getWidth(), getHeight());
            			case KeyEvent.VK_A -> player.move(-5, 0, getWidth(), getHeight());
				case KeyEvent.VK_S -> player.move(0, 5, getWidth(), getHeight());
				case KeyEvent.VK_D -> player.move(5, 0, getWidth(), getHeight());
				case KeyEvent.VK_SPACE -> player.shoot();			
				case KeyEvent.VK_ESCAPE -> System.exit(0);
			}
    		}
	}

	private void checkCollissonBulletEnemy() {
		Bullet b = player.getBullet();
		if (b != null){
			if (enemy.getBounds().intersects(player.getBullet().getBounds())) {
				enemy.takeDamage(50);
				System.out.println(enemy.getHealth());
				System.out.println(enemy.isAlive());
				player.getBullet().setVisible(false);

			}
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Game Loop");
		Settings settings = new Settings();
		Player player = new Player(settings.getPlayerStartX(), settings.getPlayerStartY());
		Enemy enemy = new Enemy();
		GameLoop gameLoop = new GameLoop(player, enemy);
		frame.add(gameLoop);
		frame.setSize(settings.getWidth(), settings.getHeight());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		gameLoop.requestFocusInWindow();
	}
}
