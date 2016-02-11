package project.directors;

import project.controls.OverworldSpriteControl;
import project.save.ItemState;
import project.items.Weapon;
public interface Character {
	public ItemState getItems();
	public OverworldSpriteControl move();
	public Weapon equippedWeapon = new Weapon();
	public boolean isHostile();
}
