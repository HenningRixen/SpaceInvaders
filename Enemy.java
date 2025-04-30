import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
/**
 * Enemy
 */
public class Enemy {
	private int x, y;
	private BufferedImage image;

	public Enemy(int startX, int startY) {
		this.x = startX;
		this.y = startY;
		try {
			image = ImageIO.read(new File("enemy.png"));
		} catch (IOException e) {
			System.err.println("png from enemy wasn't found");
			e.printStackTrace();
		}
	}

	//TODO sollte oben am bildschirm random spawen und dann sich an den ecken runter bewegen
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
