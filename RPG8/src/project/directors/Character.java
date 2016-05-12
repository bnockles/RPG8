package project.directors;
import project.controls.OverworldSpriteControl;
import project.save.ItemState;
import project.items.Weapon;
public abstract class Character {

	public abstract ItemState getItems();
	public abstract OverworldSpriteControl move();
	public Weapon equippedWeapon = new Weapon();
	public boolean Hostile;
	public int maxHP;
	public int currentHP;
	public int positionX;
	public int positionY;

}
