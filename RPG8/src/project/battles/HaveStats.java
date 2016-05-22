package project.battles;

public interface HaveStats {
	public int getMaxHP();
	public int getCurrentHP();
	public void setCurrentHP(int currentHP);
	public boolean isRegen();
	void setRegen(boolean regen);
}
