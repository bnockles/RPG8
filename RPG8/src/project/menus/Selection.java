package project.menus;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Selection {
	
	private boolean selected;
	private BufferedImage image;
	protected int width;
	protected int height;
	
	public Selection(int w, int h){
		width = w;
		height = h;
		image = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
		selected = false;
		Graphics2D g2 = (Graphics2D)image.getGraphics();
		paintUnselected(g2);
	}

	public final int getWidth(){
		return width;
	}
	
	public final int getHeight(){
		return height;
	}
	
	public final boolean isSelected(){
		return selected;
	}
	public final void setSelect(boolean b){
		selected = b;
		
		if(selected)paintSelected((Graphics2D)image.getGraphics());
		else paintUnselected((Graphics2D)image.getGraphics());
	}
	
	public final BufferedImage getImage(){
		return image;
	}
	
	public abstract void paintSelected(Graphics2D g2);
	
	public abstract void paintUnselected(Graphics2D g2);
	
	public abstract void confirm();
}
