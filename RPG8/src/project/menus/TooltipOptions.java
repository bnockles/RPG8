package project.menus;

import java.awt.Graphics2D;

/**
 * Mark Mozgovoy
 */

import java.io.File;

import project.storyV2.DisplayBox;

public class TooltipOptions implements DisplayBox {
	public static final int TOOLTIP_INVENTORY = 0;
	public static final int TOOLTIP_STORE = 1;
	public static final int TOOLTIP_DIALOGUE = 2;
	
	public static Tooltip getTooltip(int type){
		if(type == TOOLTIP_INVENTORY) return new Tooltip(450, 230, 492, 90,
				"Title Here", new File("resources/image1.jpg"), "Description here",
				234, -10);
		if(type == TOOLTIP_STORE) return new Tooltip(450, 290, 492, 330, "Title Here", new File("resources/image1.jpg"), "Description here",
				317, 660, 100, 50);
		if(type == TOOLTIP_DIALOGUE) return new Tooltip(870, 230, 72, 630, "Character Name Here", "Dialogue Text Here");
		
		//If you do not put in a valid type, it will just return the default option.
		return new Tooltip(450, 230, 492, 220,
				"Title Here", new File("resources/image1.jpg"), "Description here",
				234, 120);
	}
	
	@Override
	public Tooltip makeBox(String charName, String msg) {
		Tooltip t = TooltipOptions.getTooltip(TOOLTIP_DIALOGUE);
		editBox(t, charName, msg);
		return t;
	}

	@Override
	public void editBox(Tooltip box, String charName, String msg) {
		// TODO Auto-generated method stub
		box.setTitle(charName);
		box.setDescription(msg);
	}

	@Override
	public void drawBox(Graphics2D g2) {
		// TODO Auto-generated method stub
		t.drawTooltipDialogue(g2);
	}
}
