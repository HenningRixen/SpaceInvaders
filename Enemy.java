import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * Enemy
 */
public class Enemy {
	private static BufferedImage image;
	private int x, y;
	private int speed = 2;
	private int health = 100;
	private boolean alive = true;
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

	public int getX() { return x; }

	public int getY() { return y; }

	public int getHealth() {
		return health;
	}

	public void takeDamage(int health) {
		this.health -= health;
		if (this.health <= 0) {
			this.kill();
		}

	}

	public void kill() {
		alive = false;
	}

	public boolean isAlive() {
		return alive;
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

	public Rectangle getBounds() {
		return new Rectangle(x, y, image.getWidth(), image.getHeight());
	}
}
