package project.storyV2;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class Cutscenes {
	
	protected BufferedImage image;
	protected String missionName;
	protected String objective;
	protected Font font;
	protected int time;
	protected int width;
	protected int height;
	protected List<Color> palette;
	
	public Cutscenes(String missionName, String objective, Font font, int time, int width, int height, List<Color> list){
		this.missionName = missionName;
		this.objective = objective;
		this.font = font;
		this.time = time;
		this.width = width;
		this.height = height;
		this.palette = list;
	}
	
	public final BufferedImage getBufferedImage(){
		drawImage();
		return image;
		
	}
	protected abstract void drawImage();
}
