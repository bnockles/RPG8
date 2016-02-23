package project.story;

import java.awt.event.KeyEvent;

public abstract class Cutscenes1  {
	static int acceptableX;
	static int acceptableY;

 static Player joe = new Player(0, 0, "hunter");

	public static void main(String[] args) {
	

	
	joe.moveup();
	//cant edit locationx value in here just by setting it. 
	//Player.setLocation(55,55);  // use this to test different cutscene areas
	joe.setLocation(55, 55);
	possibles();
	
	
	
	
	
	}
	
	




	public  void moveNow(){
		joe.moveup();
	}
	
	
	public static void possibles(){
		acceptableX = joe.getX();
		acceptableY = joe.getY();
		
		if((acceptableX > 50 & acceptableX < 60) & (acceptableY >50 & acceptableY < 60)){ 
			//code to make cutscene here
			System.out.println("work");
		}
		

		else if((acceptableX > 80 & acceptableX < 90) & (acceptableY >80 & acceptableY < 90)){ 
			//code to make cutscene here
			System.out.println("work");
		}
		
		
		
	}
	

	
	
	
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int key = arg0.getKeyCode();
		if(key==KeyEvent.VK_UP){
			joe.moveup();
		}
		
		/**
		else if(key==KeyEvent.VK_DOWN){
			Player.movedown();
		}
		else if(key==KeyEvent.VK_RIGHT){
			Player.moveright();
		}
		else if(key==KeyEvent.VK_LEFT){
			Player.moveleft();
		}
		**/
		
	}
	
}
