package project.menus;

import java.awt.image.BufferedImage;
import java.util.List;

public class ChoiceMenu extends GridMenu {
	
	String description;
	String dialogue;
	
	public ChoiceMenu(int width, int height, int itemsAcross, int itemsDown, BufferedImage nullImage, 
	List<Selectable> page, String description, String dialogue) {
		super(width, height, itemsAcross, itemsDown, nullImage, page); //w and h defined later
		this.description = description;
		this.dialogue;
	}
}
