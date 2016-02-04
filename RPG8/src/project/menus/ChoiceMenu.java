package project.menus;

import java.awt.image.BufferedImage;
import java.util.List;

public class ChoiceMenu extends GridMenu {
	
	int w;
	int h;
	
	public ChoiceMenu(int width, int height, int itemsAcross, int itemsDown, BufferedImage nullImage, List<Selectable> page, String font) {
		super(w, h, itemsAcross, itemsDown, nullImage, page); //w and h defined later
	}
}
