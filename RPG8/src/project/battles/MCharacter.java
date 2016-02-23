package project.battles;
import project.controls.OverworldSpriteControl;
import project.directors.Character;
import project.save.ItemState;

public class MCharacter extends Character {
	private int level;
	private int recovery;
	private int hpValue;
	private int armorValue;
	private int sneakValue;
//	private String[] setLoadOut;

	public MCharacter(int recovery, int hpValue, int armorValue, int sneakValue){
		this.recovery= recovery;
		this.hpValue=  hpValue;
		this.armorValue = armorValue;
		this.sneakValue = sneakValue;
	}
	public int getLevel() {
		return level;
	}
	
	public int getRecovery() {
		return recovery;
	}

	public int getHpValue() {
		return hpValue;
	}

	public int getArmorValue() {
		return armorValue;
	}
	
	public int getSneakValue(){ 
		return sneakValue;
	}
	
	
	@Override
	public ItemState getItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OverworldSpriteControl move() {
		// TODO Auto-generated method stub
		return null;
	}

}
