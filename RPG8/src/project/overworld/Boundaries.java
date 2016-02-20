package project.overworld;


public class Boundaries extends Frame {
	public boolean lethal;
	public Boundaries(int xPos, int yPos, int sizeX, int sizeY, boolean lethal) {
		super(xPos,yPos,sizeX,sizeY);
		this.lethal = lethal;
	}
	public boolean isLethal() {
		return lethal;
	}
}
