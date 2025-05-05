import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.*;

public class GameLoop extends JPanel implements KeyListener {
	private ScheduledExecutorService executor;
	private Player player;
	private Enemy enemy;
	private final Set<Integer> pressedKeys = new HashSet<>();
	
	public GameLoop(Player player, Enemy enemy) {
		setDoubleBuffered(true);
		this.setFocusable(true);
		this.addKeyListener(this);
		this.player = player;
		this.enemy = enemy;

		executor = Executors.newSingleThreadScheduledExecutor();
		executor.scheduleAtFixedRate(this::gameLoop, 0, 16, TimeUnit.MILLISECONDS);
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
		int code = e.getKeyCode();
	    	pressedKeys.add(code);
	    	if (code == KeyEvent.VK_SPACE | code == KeyEvent.VK_ENTER) {
			player.shoot();
	    	}
	    	if (code == KeyEvent.VK_ESCAPE) {
			stopGame();
			System.exit(0);

		}
	}

	public void stopGame() {
        	if (executor != null && !executor.isShutdown()) {
            	executor.shutdown();
            	try {
                	executor.awaitTermination(1, TimeUnit.SECONDS);
            	} catch (InterruptedException e) {
                	e.printStackTrace();
            		}
        	}	
    	}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	private void handleInput() {
		for (int key : pressedKeys) {
        		switch (key) {
					case KeyEvent.VK_W: case KeyEvent.VK_UP:
						player.move(0, -5, getWidth(), getHeight());
						break;
					case KeyEvent.VK_A: case KeyEvent.VK_LEFT:
						player.move(-5, 0, getWidth(), getHeight());
						break;
					case KeyEvent.VK_S: case KeyEvent.VK_DOWN:
						player.move(0, 5, getWidth(), getHeight());
						break;
					case KeyEvent.VK_D: case KeyEvent.VK_RIGHT:
						player.move(5, 0, getWidth(), getHeight());
						break;
					case KeyEvent.VK_ESCAPE:
						System.exit(0);
				}
    		}
	}

	private void checkCollissonBulletEnemy() {
		Bullet b = player.getBullet();
		if (b != null){
			if (enemy.getBounds().intersects(player.getBullet().getBounds()) && enemy.isAlive()) {
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
