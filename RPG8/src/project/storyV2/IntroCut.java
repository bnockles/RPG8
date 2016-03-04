package project.storyV2;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class IntroCut extends Cutscenes {

	public IntroCut(){
		super();
	}
	@Override
	protected void drawImage() {
		// TODO Auto-generated method stub
		BufferedImage image=new BufferedImage(1000, 800, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		g2.setColor(Color.black);
		g2.drawRect(250, 200, 200,100);
		g2.drawString("Hello my goodman", 275, 250);
		this.image = image;
	}

}
