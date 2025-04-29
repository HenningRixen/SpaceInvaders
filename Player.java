import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
/**
 * Player
 */

			// TODO make it so it has the correct rect for the collision
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
		x += dx;
		y += dy;
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
