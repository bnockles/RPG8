package project.towns;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class StoreNPC {
	
	BufferedImage npc;
	int x;
	int y;
	public StoreNPC(int x, int y, String name, String imageLocation){
		int width = 200;
		int height = 200;
		this.x = x;
		this.y = y;
		npc = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		URL url = getClass().getResource(imageLocation);
		try {
			BufferedImage original = ImageIO.read(url);
			Graphics2D g = (Graphics2D) npc.getGraphics();
			int w = original.getWidth();
			int h = original.getHeight();
			g.drawImage(original, 0, 0, width, height, 0, 0, w, h, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public BufferedImage getNpc() {
		return npc;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
