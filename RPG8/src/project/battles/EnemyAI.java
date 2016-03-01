package project.battles;

import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;

import project.battles.demo.BattlesScreen;
import project.directors.Character;
import project.items.Weapon;

public abstract class EnemyAI extends Character{
	private Arc2D.Double visioncone;
	private int visionrange;
	private int visiondegree;
	protected boolean targetlock = false;
	protected boolean left = false;
	protected boolean up = false;
	protected boolean boss = false;
	protected abstract void reaction();
	protected abstract void run();
	protected int waitInterval;
	
	protected EnemyAI(BufferedImage[][] images, int[] stats, int[] vision, Weapon weapon) {
		//stats = { 0 X, 1 Y, 2 hp, 3 armor, 4 sneak, 5 speed,6 recovery, 7 exp, 8 strength,9 level}
		super(images, stats, false, weapon);
		this.visionrange = vision[0];
		this.visiondegree = vision[1];
		this.hostile = true;
		this.moveUp =true;
	}
	public void GeneralEnemyAI(){
		if(checkAlive()){
			//do something
			//System.out.println("hello");
			checkForPlayer();
			if(targetlock)
				reaction();
			moveAround();
			//moveUpAndDown();
			//moveLeftAndRight();
			//goToPlayer();
			if(maxHP/10>currentHP){
				System.out.println(maxHP+" "+currentHP);
				run();
			}
		}
		//animation of death
		//dropItem();
	}
	private boolean checkAlive(){
		if(currentHP<=0)
			return false;
		return true;
	}
	private void checkForPlayer(){
		//System.out.println("hello");
		int arcX = x+(width/2)-visionrange/2;
		int arcY = y+(height/2)-visionrange/2;
		int begindegree = 45;
		if(moveLeft)
			begindegree+=90;
		if(moveDown)
			begindegree+=180;
		if(moveRight)
			begindegree+=270;
		visioncone = new Arc2D.Double(arcX,arcY, visionrange, visionrange, begindegree, 90, Arc2D.PIE);
		//90, 225 change it to line of sight degree - 45 degree + 45
		if(visioncone.contains(BattlesScreen.character.getX(), BattlesScreen.character.getY())){
			targetlock = true;
		}
	}
	public Arc2D.Double getVisioncone() {
		return visioncone;
	}
	private void moveAround(){
		if(moveUp){
			moveUp();
			if(!moveUp){
				moveRight=true;
			}
		}
		if(moveRight){
			moveRight();
			if(!moveRight){
				moveDown=true;
			}
		}
		if(moveDown){
			moveDown();
			if(!moveDown)
				moveLeft=true;
		}
		if(moveLeft){
			moveLeft();
			if(!moveLeft)
				moveUp=true;
		}
	}
	private void moveUpAndDown(){
		if(moveUp){
			moveUp();
			if(!moveUp)
				moveDown = true;
		}
		else{
			moveDown = true;
			moveDown();
			if(!moveDown)
				moveUp = true;
		}
	}
	private void moveUp(){
		if(y-height<=0){
			moveUp=false;
			return;
		}
		y-=speed;
	}
	private void moveDown(){
		if(BattlesScreen.height <= y+height){
			moveDown=false;
			return;
		}
		y+=speed;
	}
	private void moveLeft(){
		if(x<=0){
			moveLeft = false;
			return;
		}
		x-=speed;
	}
	private void moveRight(){
		if(BattlesScreen.width <= x+width){
			moveRight = false;
			return;
		}
		x+=speed;
	}
	private void moveLeftAndRight(){
		if(moveRight){
			moveRight();
			if(!moveRight)
				moveLeft = true;
		}
		else{
			moveLeft = true;
			moveLeft();
			if(!moveLeft)
				moveRight = true;
		}
	}
	private void goToPlayer(){
		int pX = BattlesScreen.character.getX();
		int pY = BattlesScreen.character.getY();
		if(Math.abs(pX-x) < 10 && Math.abs(pY-y) < 10){
			x = (int) (Math.random()*600);
			y = (int) (Math.random()*600);
			//System.out.println(x + " " + y);
		}
		else{
			if(pX-x<0)
				x-=speed;
			else
				x+=speed;
			if(pY-y<0)
				y-=speed;
			else
				y+=speed;
		}
	}
	private void wander(){
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
		increaseCount();
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
	public boolean waitInterval(int perSec){
		waitInterval+= perSec;
		if(waitInterval > 10){
			waitInterval = 0;
			return true;
		}
		return false;
	}
	@Override
	public void fire(int x, int y, int vx, int vy) {
		// TODO Auto-generated method stub
		if(waitInterval(1)){
			if(checkAmmo()){
				//if(weapon instanceof Pistol) // this may be the way to check weapons
				firePistol(hostile,x,y,vx,vy);
				weapon.reduceAmmoByOne();
				System.out.println(BattlesScreen.eBullets.size());
			}
		}
	}
}
