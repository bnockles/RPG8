package project.demo;

import project.items.Weapon;

public class SampleGEnemy extends SampleEnemyAI implements SampleCharacter{
	
	public SampleGEnemy(int[] stats, Weapon weapon){
		maxhp = stats[0];
		positionx = stats[1];
		positiony = stats[2];
		visionrangeX = stats[3];
		visionrangeY = stats[4];
		visiondegree = stats[5];
		this.weapon = weapon;
	}

	public SampleGEnemy(int[] stats, Weapon weapon, boolean boss){
		maxhp = stats[0];
		positionx = stats[1];
		positiony = stats[2];
		visionrangeX = stats[3];
		visionrangeY = stats[4];
		visiondegree = stats[5];
		this.weapon = weapon;
		this.boss = boss;
	}
	
	@Override
	public void reaction() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void getPositionX() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void getPositionY() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setPositionX() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setPositionY() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
