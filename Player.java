import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
/**
 * Player
 */

			// TODO so umsetzen, dass das raumschiff bild auch genau mit der kollision funktioniert
public class Player {
	private int x, y;
	private BufferedImage image;

	public Player(int startX, int startY) {
		this.x = startX;
		this.y = startY;
		try {
			image = ImageIO.read(new File("raumschiff.png"));
		} catch (IOException e) {
			System.err.println("png from player wasn't found");
			e.printStackTrace();
		}
	}

	public void move(int dx, int dy) {
		int newY = y + dy;
		int newX = x + dx;
		// TODO hier settings rein?
		if (newY >= 350 && newY <= 470) {
			y = newY;
		}
		if (newX >= 5 && newX <= 693) {
			x = newX;
		}
	}

	public void draw(Graphics g) {
		if (image != null) {
			g.drawImage(image, x, y, null);
		} else {
			throw new RuntimeException("player image is null");
		}

	}

	public int getX() { return x; }
	public int getY() { return y; }

			
}
