package project.demo;

public class SampleProjectiles {
	private String pimgsrc;
	private int velocity;
	private int dmg;
	private int range;
	private int positionX;
	private int positionY;
	
	public SampleProjectiles(String pimgsrc,int velocity,int dmg, int range, int positionX, int positionY){
		this.pimgsrc = pimgsrc;
		this.velocity = velocity;
		this.dmg = dmg;
		this.range = range;
	}

	public String getPimgsrc() {
		return pimgsrc;
	}

	public int getVelocity() {
		return velocity;
	}

	public int getDmg() {
		return dmg;
	}

	public int getRange() {
		return range;
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	
	
}
