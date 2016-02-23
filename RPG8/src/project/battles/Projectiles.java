package project.battles;

import project.items.Weapon;

public class Projectiles extends Collision{
	private int characterX;
	private int characterY;
	private int cursorX;
	private int cursorY;
	private Weapon bulletType;
	
	public int getCharacterX() {
		return characterX;
	}

	public int getCharacterY() {
		return characterY;
	}

	public int getCursorX() {
		return cursorX;
	}

	public int getCursorY() {
		return cursorY;
	}

	public Weapon getBulletType() {
		return bulletType;
	}

	public Projectiles(int characterX, int characterY, int cursorX, int cursorY, Weapon bulletType){
		this.characterX = characterX;
		this.characterY = characterY;
		this.cursorX = cursorX;
		this.cursorY = cursorY;
		this.bulletType = bulletType; //this needs more clarity because it has to be created
	}

	@Override
	void collide() {
		// TBD after discussing
		
	}
}
