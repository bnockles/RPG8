package project.controls;

public interface BattlesControls {
	int x;
	int y;
	public void moveUp();
	public void moveDown() {
		// TODO Auto-generated method stub
		y+=5;
	}
	public void moveRight() {
		// TODO Auto-generated method stub
		x+=5;
	}
	public void moveLeft() {
		// TODO Auto-generated method stub
		x-=5;
	}
	
}
