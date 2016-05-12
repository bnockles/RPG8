package project.storyV2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;

public class IntroCut extends Cutscenes {
	protected int x;
	protected boolean crossed;
	public IntroCut(String missionName, String objective, Font font, int time, int width, int height, List<Color> list){
		super(missionName, objective, font, time, width, height, list);
		BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		g2.setFont(font);
		int textWidth = g2.getFontMetrics().stringWidth(missionName);
		x = -textWidth;
		crossed = false;
	}
	@Override
	protected void drawImage() {
		// TODO Auto-generated method stub
		int y = height/2;
		BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		g2.setColor(palette.get(0));
		g2.setFont(font);
		int textWidth = g2.getFontMetrics().stringWidth(missionName);
		int textHeight = g2.getFontMetrics().getHeight();
		makeAdjust(g2);
		g2.drawString(missionName, x, y);
		g2.setColor(palette.get(1));
		g2.drawString(objective, (width-x-textWidth), y+textHeight);
		this.image = image;
//		System.out.println(x);
	}
	private void makeAdjust(Graphics2D g2){
		int textWidth = g2.getFontMetrics().stringWidth(missionName);
		int velocity = (textWidth+width)/time;
		double accel = (Math.abs(x+textWidth/2-(double)width/2))/(width);
		if(crossed)accel = (Math.abs(x-textWidth/2+(double)width/2))/(width);
		if(accel<.03)crossed = true;
//		System.out.println(accel);
		x += (x<(textWidth+width))?velocity*accel:0;
	}

}
