import java.awt.Color;

/**
 * Settings
 */
public class Settings {

	private int width;
	private int height;
	private int playerStartX;
	private int playerStartY;
	//TODO hier gerne nicht nur color sonder ein Image und es dann correct an GameLoop übergeben
	private Color backgroundColor;

	public Settings() {
		this.width = 800;
		this.height = 600;
		this.playerStartX = 360;
		this.playerStartY = 450;
		this.backgroundColor = Color.GREEN;
	}
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	public int getPlayerStartX() {
		return playerStartX;
	}
	public int getPlayerStartY() {
		return playerStartY;
	}
	public Color getBackgroundColor() {
		return backgroundColor;
	}

}
