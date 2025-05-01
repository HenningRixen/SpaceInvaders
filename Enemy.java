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
	private static BufferedImage image;
	private int speed = 2;
	static {
		try {
			image = ImageIO.read(new File("enemy.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Enemy() {
		this.x = 5;
		this.y = 5;
	}

	//TODO sollte oben am bildschirm random spawen
	public void update(int panelWidth) {
		x += speed;
		if (x < 0 || x + image.getWidth() > panelWidth) {
			speed *= -1;
			y += 15;
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
