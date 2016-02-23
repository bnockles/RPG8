package project.story;
//jiawei
public class Player {

	
	public static int locationX;
	public static int locationY;
	public String pname;
	
	
	public Player(int xplace, int yplace, String type){
		this.locationX = xplace;
		this.locationY = yplace;
		this.pname = type;
	
	}
	
	public int getX(){
		return locationX;
		
	}
	public int getY(){
		 return locationY;
	}
	public static void moveup(){
		 locationX++;
	}
	public static void movedown(){
		locationX--;
		
	}
	public static void moveleft(){
		locationY--;
		
	}
	public static void moveright(){
		
		locationY++;
	}
	
	public static  void setLocation(int xvalue, int yvalue){
	
		locationY = yvalue;
		locationX = xvalue;
	}
	
	
}



