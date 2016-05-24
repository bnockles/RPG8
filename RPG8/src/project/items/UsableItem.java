package project.items;

import java.awt.Rectangle;

import project.battles.HaveStats;

public interface UsableItem {
	public void useItem(HaveStats c);

	public Rectangle getRectitem();

}