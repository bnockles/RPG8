package project.story;

@SuppressWarnings("serial")
public abstract class Cutscenes1 {
	static int acceptableX;
	static int acceptableY;	
	public static void setLocation(int xval, int yval){
		storyDemo.Swarm.setX(xval);
		storyDemo.Swarm.setY(yval);
		
	}
	public static void possibles(){
	
		acceptableX = storyDemo.Swarm.getX();
		acceptableY = storyDemo.Swarm.getY();

		if(acceptableX >= 0 && acceptableX <= 100 && acceptableY >= 0 && acceptableY <= 100){ 
			//code to make cutscene here
			
			
			
			
			storyDemo.setCutscene(true);
			System.out.println("cutscene true");
			setLocation(56565630, 565630);
		}		
	}

}
