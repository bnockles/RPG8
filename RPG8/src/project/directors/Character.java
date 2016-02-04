package project.directors;

import project.controls.OverworldSpriteControl;
import project.save.ItemState;

public interface Character {
	public ItemState getItems();
	public OverworldSpriteControl move();
}
