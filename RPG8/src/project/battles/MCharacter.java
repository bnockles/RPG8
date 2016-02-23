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
	private String[] setLoadOut;
	
	public MCharacter(){
		
	}
	public int getLevel() {
		return level;
	}
	
	public int getRecovery() {
		return recovery;
	}

	public void setRecovery(int recovery) {
		this.recovery = recovery;
	}

	public int getHpValue() {
		return hpValue;
	}

	public void setHpValue(int hpValue) {
		this.hpValue = hpValue;
	}

	public int getArmorValue() {
		return armorValue;
	}

	public void setArmorValue(int armorValue) {
		this.armorValue = armorValue;
	}
	
	public int getSneakValue(){ 
		return sneakValue;
	}
	
	public void setSneakValue(int sneakValue) {
		this.sneakValue = sneakValue;
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
