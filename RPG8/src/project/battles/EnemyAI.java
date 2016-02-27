package project.battles;

import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;

import project.battles.demo.BattlesScreen;
import project.directors.Character;
import project.items.Weapon;

public abstract class EnemyAI extends Character{
	protected static Arc2D.Double visioncone;
	private int visionrange;
	private int visiondegree;
	protected boolean targetlock = false;
	protected boolean left = false;
	protected boolean up = false;
	protected boolean boss = false;
	protected abstract void reaction();
	protected abstract void run();
	
	protected EnemyAI(BufferedImage[][] images, int[] stats, int[] vision, Weapon weapon) {
		//stats = { 0 X, 1 Y, 2 hp, 3 armor, 4 sneak, 5 speed,6 recovery, 7 exp, 8 strength,9 level}
		super(images, stats, false, weapon);
		this.visionrange = vision[0];
		this.visiondegree = vision[1];
	}
	public void GeneralEnemyAI(){
		if(checkAlive()){
			//do something
			//System.out.println("hello");
			if(targetlock == false)
				checkForPlayer();
			else
				reaction();
			moveUpAndDown();
			if(maxHP/10>currentHP){
				System.out.println(maxHP+" "+currentHP);
				run();
			}
		}
		//animation of death
		//dropItem();
	}
	public boolean checkAlive(){
		if(currentHP<0)
			return false;
		return true;
	}
	public void checkForPlayer(){
		//System.out.println("hello");
		int arcX = x+(width/2)-visionrange/2;
		int arcY = y+(height/2)-visionrange/2;
		
		visioncone = new Arc2D.Double(arcX,arcY, visionrange, visionrange, 225, 90, Arc2D.PIE);
		//90, 225 change it to line of sight degree - 45 degree + 45
		if(visioncone.contains(BattlesScreen.character.getX(), BattlesScreen.character.getY())){
			targetlock = true;
		}
	}
	public static void paintArc(Graphics2D g){
		g.draw(visioncone);
	}
	public void moveUpAndDown(){
		if(moveUp){
			y-=10;
			if(y<=0){
				moveUp = false;
				moveDown = true;
			}
		}
		else{
			y+=10;
			if(BattlesScreen.height <= y){
				System.out.println(y+" "+ BattlesScreen.height);
				moveUp = true;
				moveDown = false;
			}
		}
	}
	public void moveLeftAndRight(){
		if(moveRight){
			y-=10;
			if(y<=0){
				moveRight = false;
				moveLeft = true;
			}
		}
		else{
			y+=10;
			if(BattlesScreen.height <= y){
				System.out.println(y+" "+ BattlesScreen.height);
				moveUp = true;
				moveDown = false;
			}
		}
	}
	public void wander(){
		//System.out.println("a"+positionX);
		if(Math.abs(x-BattlesScreen.character.getX()) < 100){
			x--;
		}
		else{
			x++;
		}
		if(Math.abs(y-BattlesScreen.character.getY()) < 100){
			y--;
		}
		else{
			y++;
		}
		//System.out.println("b"+positionX);
//		if(true){
//			left = !left;
//		}; // check if its gonna crash into a wall or something
//		// need variables for other objects and boundaries
//		if(true){
//			up = !up;
//		}
	}
	@Override
	public BufferedImage getImage() {
		/**
		 * Chieh-Huang Chen
		 */
		// TODO Auto-generated method stub
		// moveup use it as moving.
			if(moveUp == true){
				if((count >= 0 && count < 5) || (count >= 10 && count < 15))
					return bsprite[0];
				if(count >= 5 && count < 10)
					return bsprite[1];
				if(count >= 15 && count < 20)
				return bsprite[2];
			}
 
			if(moveDown == true){
				if((count >= 0 && count < 5) || (count >= 10 && count < 15))
					return fsprite[0];
				if(count >= 5 && count < 10)
					return fsprite[1];
				if(count >= 15 && count < 20)
				return fsprite[2];
			}
			if(moveLeft == true){
				if((count >= 0 && count < 5) || (count >= 10 && count < 15))
					return lsprite[0];
				if(count >= 5 && count < 10)
					return lsprite[1];
				if(count >= 15 && count < 20)
				return lsprite[2];
			}

			if(moveRight == true){
				if((count >= 0 && count < 5) || (count >= 10 && count < 15))
					return rsprite[0];
				if(count >= 5 && count < 10)
					return rsprite[1];
				if(count >= 15 && count < 20)
				return rsprite[2];
			}
		return fsprite[0];
	}
	abstract void movement();
	abstract void sight();
}
