import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameLoop extends JPanel implements KeyListener, ActionListener {
	private Timer gameTimer;
	
	public GameLoop() {
		gameTimer = new Timer(16, e -> gameLoop());
		gameTimer.start();
		this.setFocusable(true);
	}
	private void gameLoop() {
		repaint();

	}
	@Override 
	public void actionPerformed(ActionEvent e){}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Game Loop");
		GameLoop gameLoop = new GameLoop();
		frame.add(gameLoop);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);


	}




	
}
