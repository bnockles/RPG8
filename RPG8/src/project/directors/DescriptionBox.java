package project.directors;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * @author = bnockles
 * extend this class to create rectangular text boxes with the thematic bacground color and border
 * this class simply emables consistent appearance of rectangular text boxes for desciptions of items
 * 
*/
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
	
	/**
	 * @param String change text
	 * call this method to change the content of the textbox without changing size
	 * so the box can be dynamic
	 * */
	public final void setText(String newText){
		description=newText;
		update();
	}

	@Override
	public void update() {
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		paintBackground(g2);
		paintText(g2);
		paintForeground(g2);
	}
	
	public abstract void paintText(Graphics2D g2);

	/**
	 * @param Graphics2D from BufferedImage
	 * All descriptive text will have the same background color or image
	 * */
	public final void paintBackground(Graphics2D g2) {
		
	}
	/**
	 * @param Graphics2D from BufferedImage
	 * All descriptive text will have the same background color or image
	 * */
	public final void paintForeground(Graphics2D g2) {
		// All descriptive text will have the same border/foreground
	}

}
