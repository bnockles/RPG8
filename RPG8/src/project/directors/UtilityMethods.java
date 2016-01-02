package project.directors;

import java.awt.FontMetrics;
import java.awt.Graphics2D;

public class UtilityMethods {

	/**
	 * centers a single line of text in the middle of a rectangular area
	 * 
	 * @param g2 Graphics2D by which text is drawn
	 * @param text single-line text to be centered
	 * @param areaWidth width of panel to center between
	 * @param areaHeight height of panel to center between
	 */
	public static void centerText(Graphics2D g2, String text,int areaWidth,int areaHeight){
		FontMetrics fm = g2.getFontMetrics();
		int x = (areaWidth-fm.stringWidth(text))/2;
		int y = (fm.getAscent() + (areaHeight - (fm.getAscent() + fm.getDescent())) / 2);
		g2.drawString(text, x, y);
	}

}
