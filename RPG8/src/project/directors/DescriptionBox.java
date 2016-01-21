package project.directors;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class DescriptionBox implements Visible {

	String description;
	BufferedImage image;
	
	public DescriptionBox(String description, int width, int height){
		this.description=description;
		image = new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB);
		update();
	}
	
	@Override
	public final BufferedImage getImage() {
		return image;
	}
	
	public final void setText(String newText){
		description=newText;
		update();
	}

	@Override
	public void update() {
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		paintBackground(g2);
		paintText(g2);
	}
	
	public abstract void paintText(Graphics2D g2);

	
	public void paintBackground(Graphics2D g2) {
		// All descriptive text will have the same background color or image
	}

}
