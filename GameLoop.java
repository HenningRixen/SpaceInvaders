import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameLoop extends JPanel implements KeyListener {
	private Timer gameTimer;
	private Player player;
	private Enemy enemy;
	
	public GameLoop(Player player, Enemy enemy) {
		setDoubleBuffered(true);
		gameTimer = new Timer(16, e -> gameLoop());
		gameTimer.start();
		this.setFocusable(true);
		this.addKeyListener(this);
		this.player = player;
		// TODO wohin soll der Enemy in den Constructor oder in die main methode
		this.enemy = enemy;
	}
	private void gameLoop() {
		enemy.update(getWidth());
		repaint();
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		player.draw(g);
		enemy.draw(g);

	}
	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
			case KeyEvent.VK_W -> player.move(0, -5, getWidth(), getHeight());
			case KeyEvent.VK_A -> player.move(-5, 0, getWidth(), getHeight());
			case KeyEvent.VK_S -> player.move(0, 5, getWidth(), getHeight());
			case KeyEvent.VK_D -> player.move(5, 0, getWidth(), getHeight());
			// TODO weil es fürs testen schneller ist
			case KeyEvent.VK_ESCAPE -> System.exit(0);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

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
