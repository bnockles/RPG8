package project.storyV2;

import java.awt.image.BufferedImage;

public abstract class Cutscenes {
	
	BufferedImage image;
	
	public Cutscenes(){
		drawImage();
	}
	
	public final BufferedImage getBufferedImage(){
		return image;
		
	}
	protected abstract void drawImage();
}
