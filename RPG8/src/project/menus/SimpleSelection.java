package project.menus;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class SimpleSelection implements Selectable {
	
	private boolean selected;
	private BufferedImage image;
	protected int width;
	protected int height;
	
	public SimpleSelection(int w, int h){
		width = w;
		height = h;
		image = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
		selected = false;
		Graphics2D g2 = (Graphics2D)image.getGraphics();
		paintUnselected(g2);
	}
	
	//in SimpleSelection, nothing special happens when then item is selected,
	//by comparison, in the Items package, when items are selected, information about the item appears
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

}
