package project.overworld;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class MainMap {
	int region;
	BufferedImage map;
	public MainMap(int region,String image){
		this.region = region;
		try {
			URL url = getClass().getResource(image);
			this.map = ImageIO.read(url);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int getRegion() {
		return region;
	}
	public BufferedImage getMap() {
		return map;
	}
}
