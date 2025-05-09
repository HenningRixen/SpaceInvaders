import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.File;
/**
 * Bullet
 */
public class Bullet {
	private static BufferedImage image;
	private int x,y;
	private int speed = 10;
	private boolean isVisible = true;
	private final Rectangle bounds;
	static {
		try {
			image = ImageIO.read(new File("bullet.png"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Bullet(int startX, int startY) {
		this.x = startX;
		this.y = startY;
		bounds = new Rectangle(x, y, image.getWidth(), image.getHeight());
	}
	public void update() {
		y -= speed;
		if (y < 0) {
			isVisible = false;
		}
		updateBounds();
	}
	
	public void draw(Graphics g) {
		if (image != null) {
			g.drawImage(image, x, y, null);
		} else {
			throw new RuntimeException("player image is null");
		}

	}
	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean bool){
		isVisible = bool;
	}

	public void reset(int startX, int startY) {
		this.x = startX;
		this.y = startY;
		this.isVisible = true;
		updateBounds();
	}
	private void updateBounds() {
        	bounds.setBounds(x, y, image.getWidth(), image.getHeight());
    	}

	public Rectangle getBounds() {
		return bounds;
	}
}
