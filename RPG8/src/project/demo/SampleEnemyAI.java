package project.demo;

import project.items.Weapon;

public abstract class SampleEnemyAI{
	public int hp;//static idk
	public int maxhp;
	public int positionx;
	public int positiony;
	public int visionrangeX;
	public int visionrangeY;
	public int visiondegree;
	public Weapon weapon;
	private boolean targetlock = false;
	public boolean boss = false;
	public abstract void reaction();
	public abstract void run();
	public void GeneralEnemyAI(){
		do{
			//do something
			if(targetlock == false)
				checkForPlayer();
			else
				reaction();
			if(maxhp/10>hp)
				run();
		}
		while(checkAlive());
		//animation of death
	}
	public boolean checkAlive(){
		if(hp<0)
			return false;
		return true;
	}
	public void checkForPlayer(){
		int playerXposition=0;
		int playerYposition=0;
		if((positionx+visionrangeX>playerXposition && positionx<playerXposition)&&
				(positiony+visionrangeY>playerYposition && positiony<playerYposition)){
			//in the if statement multiply range by sine of something
			targetlock = true;
		}
	}
}
