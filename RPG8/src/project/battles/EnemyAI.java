package project.battles;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import project.battles.demo.BattlesScreen;
import project.directors.Character;
import project.items.Weapon;

public abstract class EnemyAI extends Character{
	private Ellipse2D.Double awarenessRange;
	private int awareRange;
	private int bulletpersec = 100;
	protected int spawnedX;
	protected int spawnedY;
	protected int enemyClass;
	protected int kills;
	protected int deaths; 
	
	protected boolean targetLock = false;
	protected boolean upAndDown = false;
	protected boolean leftAndRight = false;
	protected boolean goAround = false;
	protected boolean goToPlayer = false;
	protected boolean direction = false;
	protected boolean wander = false;
	
	protected boolean alone = true;
	protected boolean left = false;
	protected boolean up = false;
	protected boolean boss = false;
	protected abstract void reaction();
	protected abstract void run();
	protected abstract void goToPlayer();
	protected abstract void dodge();
	public abstract void scale();
	protected int waitInterval;
	
	protected EnemyAI(BufferedImage[][] images, int[] stats, int[] stats2, Weapon weapon, int type) {
		//stats = { 0 X, 1 Y, 2 hp, 3 armor, 4 sneak, 5 speed,6 recovery, 7 exp, 8 strength,9 level}
		super(images, stats, false, weapon);
		this.visionrange = stats2[0];
		this.visiondegree = stats2[1];
		this.awareRange = stats2[2];
		this.bulletpersec = stats2[3];
		this.spawnedX = stats[0];
		this.spawnedY = stats[1];
		awarenessRange = new Ellipse2D.Double(x-awareRange, y-awareRange, awareRange, awareRange);
		this.hostile = true;
		this.moveUp=true;
		if(type == BattlesScreen.LEFT_RIGHT)
			leftAndRight = true;
		if(type == BattlesScreen.UP_DOWN)
			upAndDown = true;
		if(type == BattlesScreen.AROUND)
			goAround = true;
		if(type == BattlesScreen.GOTOPLAYER)
			goToPlayer = true;
		if(type == BattlesScreen.WANDER)
			wander = true;
	}
	public void GeneralEnemyAI(){
		if(checkAlive()){
			visioncone = checkForPlayer(this);
			if(targetLock){
				dodge();
				reaction();
			}
			else{
				if(leftAndRight)
					moveLeftAndRight();
				if(upAndDown)
					moveUpAndDown();
				if(goAround)
					moveAround();
				if(goToPlayer)
					goToPlayer();
				if(wander)
					wander();
			}
			//checkForProjectiles(); // DO NOT IMPLEMENT THIS IF WE HAVEN'T FINISH COLLISIONS
			//checkEnemiesAround();
			if(maxHP/10>currentHP && alone){
				System.out.println(maxHP+" "+currentHP);
				run();
			}
		}else{
			BattlesScreen.enemiesOnScreen.remove(this);
		}
	}

	

	
	private void checkForObjects(){//Enemy can hide behind objects to block damage.
		Point location;
	}
	private void checkForProjectiles(){
		Point location;
		for(Collision projectiles: BattlesScreen.pBullets){
			location = new Point(projectiles.getX(),projectiles.getY());
			if(awarenessRange.contains(location)){
				if(location.getX()-awarenessRange.getCenterX()>0)
					x--;
				else
					x++;
				if(location.getY()-awarenessRange.getCenterY()>0)
					y--;
				else
					y++;
					
			}
		}
	}
	private void checkEnemiesAround(){
		for(EnemyAI enemy:BattlesScreen.enemiesOnScreen){
			if(awarenessRange.contains(enemy.getX(),enemy.getY()))
				alone = false;
			else
				alone = true;
		}
	}
	private boolean checkAlive(){
		if(currentHP<=0)
			return false;
		return true;
	}
	public static Arc2D.Double checkForPlayer(EnemyAI enemy){
		//System.out.println("hello");
		int arcX = enemy.getX()+(enemy.getWidth()/2)-enemy.getVisionrange()/2;
		int arcY = enemy.getY()+(enemy.getHeight()/2)-enemy.getVisionrange()/2;
		int begindegree = 45;
		if(enemy.isMoveLeft())
			begindegree+=90;
		if(enemy.isMoveDown())
			begindegree+=180;
		if(enemy.isMoveRight())
			begindegree+=270;
		Arc2D.Double visioncone = new Arc2D.Double(arcX,arcY, enemy.getVisionrange(), enemy.getVisionrange(), begindegree, 90, Arc2D.PIE);
		//90, 225 change it to line of sight degree - 45 degree + 45
		if(visioncone.intersects(BattlesScreen.character.getBounds())){
			enemy.setTargetLock(true);
		}
		return visioncone;
	}
	public void setTargetLock(boolean targetLock) {
		this.targetLock = targetLock;
	}
	public Arc2D.Double getVisioncone() {
		return visioncone;
	}
	public int getVisionrange() {
		return visionrange;
	}
	public void setVisionrange(int visionrange) {
		this.visionrange = visionrange;
	}
	public int getEnemyClass() {
		return enemyClass;
	}
	
	public void setSpawnedX(int spawnedX) {
		this.spawnedX = spawnedX;
	}
	public void setSpawnedY(int spawnedY) {
		this.spawnedY = spawnedY;
	}
	public int getBulletpersec() {
		return bulletpersec;
	}
	public void setBulletpersec(int bulletpersec) {
		this.bulletpersec = bulletpersec;
	}
	public boolean isTargetLock() {
		return targetLock;
	}
	public static float distance(int aX, int aY, int bX, int bY){
		float dist = (float) Math.sqrt(
				Math.pow(aX - bX, 2) +
				Math.pow(aY - bY, 2) );
		
	return dist;
	}
	protected void moveAround(){
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
	protected void moveUpAndDown(){
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
	protected void moveUp(){
		if(y-height<=0){
			moveUp=false;
			return;
		}
		y-=speed;
	}
	protected void moveDown(){
		if(BattlesScreen.height <= y+height){
			moveDown=false;
			return;
		}
		y+=speed;
	}
	protected void moveLeft(){
		if(x<=0){
			moveLeft = false;
			return;
		}
		x-=speed;
	}
	protected void moveRight(){
		if(BattlesScreen.width <= x+width){
			moveRight = false;
			return;
		}
		x+=speed;
	}
	protected void moveLeftAndRight(){
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

	protected void wander(){
		if(moveUp||moveDown)
			moveUpAndDown();
		else
			moveLeftAndRight();
		randomTurns();
	}
	private void randomTurns(){
		int num =(int) (Math.random()*200);
		//System.out.println(num);
		if(num < 4){
			moveUp = false;
			moveDown = false;
			moveLeft = false;
			moveRight = false;
			if(num == 0)
				moveUp = true;
			if(num == 1)
				moveDown = true;
			if(num == 2)
				moveLeft = true;
			if(num == 3)
				moveRight =true;
		}
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
		if(waitInterval > 1000){
			waitInterval = 0;
			return true;
		}
		return false;
	}
	@Override
	public void fire(int x, int y, int vx, int vy) {
		if(waitInterval(bulletpersec)){
			if(checkAmmo()){
				//if(weapon instanceof Pistol) // this may be the way to check weapons
				firePistol(hostile,x,y,vx,vy);
				weapon.reduceAmmoByOne();
				//System.out.println(BattlesScreen.eBullets.size());
			}
		}
	}
}
