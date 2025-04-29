import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameLoop extends JPanel implements KeyListener, ActionListener {
	private Timer gameTimer;
	private int rectY = 50;
	private int rectX = 50;
	private int width = 50;
	private int height = 50;
	private BufferedImage playerImage;

	
	public GameLoop() {
		gameTimer = new Timer(16, e -> gameLoop());
		gameTimer.start();
		this.setFocusable(true);
		this.addKeyListener(this);

		try {
			playerImage = ImageIO.read(new File("raumschiff.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void gameLoop() {
		repaint();

	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (playerImage != null) {
			g.drawImage(playerImage, rectX, rectY, null); 
		} else {
			g.setColor(Color.RED);
			g.drawRect(rectX, rectY, width, height);
			g.fillRect(rectX, rectY, width, height);
		}

	}
	@Override 
	public void actionPerformed(ActionEvent e){}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
			case KeyEvent.VK_W -> rectY -= 5;
			case KeyEvent.VK_A -> rectX -= 5;
			case KeyEvent.VK_S -> rectY += 5;
			case KeyEvent.VK_D -> rectX += 5;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Game Loop");
		GameLoop gameLoop = new GameLoop();
		frame.add(gameLoop);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		gameLoop.requestFocusInWindow();


	}




	
}
