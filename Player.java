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
	private static BufferedImage image;
	private Bullet bullet;
	static {
		try {
			image = ImageIO.read(new File("raumschiff.png"));
		} catch (IOException e) {
			System.err.println("png from player wasn't found");
			e.printStackTrace();
		}
	}

	public Player(int startX, int startY) {
		this.x = startX;
		this.y = startY;
	}
	public int getX() { return x; }

	public int getY() { return y; }

	public void move(int dx, int dy, int panelWidth, int panelHeight) {
		int newY = y + dy;
		int newX = x + dx;
		int topLimitRealitve = (int) Math.round(panelHeight * 0.3);
		int topLimit = panelHeight - topLimitRealitve;
		int bottomLimit = panelHeight - image.getHeight();
		int leftLimit = (int) Math.round(panelHeight * 0.01);
		int rightLimit = panelWidth - image.getWidth();
	
		if (newY >= topLimit && newY <= bottomLimit) {
			y = newY;
		}
		if (newX >= leftLimit && newX <= rightLimit) {
			x = newX;
		}
	}
	public void shoot() {
	    if (bullet == null) {
		bullet = new Bullet(x + 7, y); 
	    } else if (!bullet.isVisible()) {
		bullet.reset(x + 7, y);
	    }
	}
	
	public void updateBullet() {
	    if (bullet != null && bullet.isVisible()) {
		bullet.update();
	    }
	}

	public Bullet getBullet() {
		if (bullet != null && bullet.isVisible()) {
			return bullet;
		}
		return null;
	}

	public void draw(Graphics g) {
		if (image != null) {
			g.drawImage(image, x, y, null);
		} else {
			throw new RuntimeException("player image is null");
		}
		if (bullet != null && bullet.isVisible()) {
			bullet.draw(g);
		}

	}


			
}
