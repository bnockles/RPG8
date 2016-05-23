package project.directors;
import java.awt.Rectangle;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import project.battles.Explosives;
import project.battles.Melee;
import project.battles.Projectiles;
import project.battles.demo.BattlesScreen;
//import project.save.ItemState;
import project.items.Weapon;
public abstract class Character implements project.battles.Animation, project.battles.HaveStats{

	//public abstract ItemState getItems();
	//public abstract OverworldSpriteControl move();
	protected BufferedImage[] fsprite;
	protected BufferedImage[] bsprite;
	protected BufferedImage[] lsprite;
	protected BufferedImage[] rsprite;
	protected BufferedImage stopImage;
	
	protected Arc2D.Double visioncone;
	protected int visionrange;
	protected int visiondegree;
	
	protected int count;
	protected boolean moveUp = false;
	protected boolean moveDown = false;
	protected boolean moveLeft = false;
	protected boolean moveRight = false;
	protected boolean facingUp = false;
	protected boolean facingDown = false;
	protected boolean facingLeft = false;
	protected boolean facingRight = false;
	
	protected int width;
	protected int height;
	protected int x;
	protected int y;
	
	protected int maxHP;
	protected int currentHP;
	protected int maxArmor;
	protected int currentArmor;
	protected int sneakValue;//Enemies can sneak behind players too 
	protected int speed;
	protected int recovery;//Enemies can recover too.
	protected int exp; //Enemies will give exp to the player when it dies 
	protected int strength; // Muhammad said something about this for enemies and players in the earlier demo
	
	protected ArrayList<Weapon> loadout;
	
	protected boolean hostile;
	
	protected boolean walking = false; // planning to do something with it
	
	public Weapon weapon;
	
	public boolean isMoveUp() {
		return moveUp;
	}
	public boolean isMoveDown() {
		return moveDown;
	}
	public boolean isMoveLeft() {
		return moveLeft;
	}
	public boolean isMoveRight() {
		return moveRight;
	}
	protected Character(BufferedImage[][] images,int[] stats, boolean hostile, Weapon weapon){
		//stats = { 0 X, 1 Y, 2 hp, 3 armor, 4 sneak, 5 speed,6 recovery, 7 exp, 8 strength,9 level}
		// we might create allies if we do this hostile method.
		//need an inventory for character and arraylist of weapons for parameters
		//need armor set
		this.bsprite = images[0];
		this.fsprite = images[1];
		this.lsprite = images[2];
		this.rsprite = images[3];
		this.stopImage = fsprite[0];
		
		this.width = bsprite[0].getWidth();
		this.height = bsprite[0].getHeight();
		this.x = stats[0];
		this.y = stats[1];
		
		this.maxHP = stats[2];
		this.currentHP = stats[2];
		this.maxArmor = stats[3];
		this.currentArmor = stats[3];
		this.sneakValue = stats[4];
		this.speed = stats[5];
		this.recovery = stats[6];
		this.exp = stats[7];
		this.strength = stats[8];
		
		this.hostile = hostile;
		
		this.weapon = weapon;
	}
	public Arc2D.Double getVisioncone() {
		return visioncone;
	}
	public void setVisioncone(Arc2D.Double visioncone) {
		this.visioncone = visioncone;
	}
	public int getVisionrange() {
		return visionrange;
	}
	public void setVisionrange(int visionrange) {
		this.visionrange = visionrange;
	}
	public int getVisiondegree() {
		return visiondegree;
	}
	public void setVisiondegree(int visiondegree) {
		this.visiondegree = visiondegree;
	}
	//ABSTRACT BELOW
	public abstract BufferedImage getImage();
	public abstract void fire(int x, int y, int vx, int vy);

	//NOT GETTERS/SETTERS BELOW
	public Rectangle getBounds(){ //Pelham made this change sorry in advance for changing your code
		return new Rectangle(x, y, width, height);
	}
	
	public void increaseCount(){
		/**
		 * Chieh-Huang Chen
		 */
		count++;
		if(count>=20)
			count=0;
	}
	
	//WEAPON METHODS BELOW
	
	public boolean checkAmmo(){
		if(weapon.getAmmo()<=0){
			return false;
		}
		return true;
	}
	
	public void firePistol(boolean hostile, int x, int y, int vx, int vy){//target location
		/**
		 * Yifan
		 */
		Projectiles bullet = new Projectiles(x, y, weapon.getDamage(), vx, vy, weapon.getRange(), weapon.getProjectileImg(),hostile);
		if(hostile)
			BattlesScreen.eBullets.add(bullet);
		else
			BattlesScreen.pBullets.add(bullet);
	}
	public void useMelee(int direction){
		//test code
		double rotation = Math.PI/2;
		int posx = x;
		int posy = y;
		if(direction == 1  || direction == 2){
			rotation = 0;
			if(direction==1)posy-=50;
			if(direction==2)posy+=50;
		}
		if(direction == 3  || direction == 4){
			if(direction==3)posx-=50;
			if(direction==4)posx+=50;
		}
		else rotation = Math.PI/2;
		BufferedImage sheet = UtilityMethods.getImageFromFile(this, "/images/slash/slash.png");
		Melee attack = new Melee(posx,posy,0,50,50,15,sheet,rotation);
		BattlesScreen.pBullets.add(attack);
	}
	public void fireExplosive(boolean hostile, int x, int y, int vx, int vy){
		Explosives bullet = new Explosives(x, y, weapon.getDamage(), vx, vy, weapon.getRange(), weapon.getProjectileImg(), hostile);
		BattlesScreen.pBullets.add(bullet);
		weapon.reduceAmmoByOne();
	}
	public void fireRifle(boolean hostile, int x, int y, int vx, int vy){
		/**
		 * Yifan
		 */
		Projectiles bullet = new Projectiles(x, y, weapon.getDamage(), vx, vy, weapon.getRange(), weapon.getProjectileImg(),hostile);
		BattlesScreen.pBullets.add(bullet);
		weapon.reduceAmmoByOne();
	}
	public void fireHeavy(boolean hostile, int x, int y, int vx, int vy){
		/**
		 * Yifan
		 */
		Projectiles bullet = new Projectiles(x, y, weapon.getDamage(), vx, vy, weapon.getRange(), weapon.getProjectileImg(),hostile);
		Projectiles bullet1 = new Projectiles(x, y, weapon.getDamage(), vx, vy, weapon.getRange(), weapon.getProjectileImg(),hostile);
		BattlesScreen.pBullets.add(bullet);
		BattlesScreen.pBullets.add(bullet1);
		weapon.reduceAmmoByOne();
	}
	public void fireSMG(boolean hostile, int x, int y, int vx, int vy){
		/**
		 * Yifan
		 */
		Projectiles bullet = new Projectiles(x, y, weapon.getDamage(), vx, vy, weapon.getRange(), weapon.getProjectileImg(),hostile);
		BattlesScreen.pBullets.add(bullet);
		weapon.reduceAmmoByOne();
	}
	//GETTERS&SETTERS BELOW
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getMaxHP() {
		return maxHP;
	}
	public int getCurrentHP() {
		return currentHP;
	}
	public int getMaxArmor() {
		return maxArmor;
	}
	public int getCurrentArmor() {
		return currentArmor;
	}
	public int getSneakValue() {
		return sneakValue;
	}
	public int getSpeed() {
		return speed;
	}
	public int getRecovery() {
		return recovery;
	}
	public int getExp() {
		return exp;
	}
	public int getStrength() {
		return strength;
	}
	public ArrayList<Weapon> getLoadout() {
		return loadout;
	}
	public boolean isHostile() {
		return hostile;
	}
	public BufferedImage[] getFsprite() {
		return fsprite;
	}
	public void setFsprite(BufferedImage[] fsprite) {
		this.fsprite = fsprite;
	}
	public BufferedImage[] getBsprite() {
		return bsprite;
	}
	public void setBsprite(BufferedImage[] bsprite) {
		this.bsprite = bsprite;
	}
	public BufferedImage[] getLsprite() {
		return lsprite;
	}
	public void setLsprite(BufferedImage[] lsprite) {
		this.lsprite = lsprite;
	}
	public BufferedImage[] getRsprite() {
		return rsprite;
	}
	public void setRsprite(BufferedImage[] rsprite) {
		this.rsprite = rsprite;
	}
	public boolean isWalking() {
		return walking;
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public boolean isFacingUp() {
		return facingUp;
	}
	public boolean isFacingDown() {
		return facingDown;
	}
	public boolean isFacingLeft() {
		return facingLeft;
	}
	public boolean isFacingRight() {
		return facingRight;
	}
	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}
	public void setCurrentArmor(int currentArmor) {
		this.currentArmor = currentArmor;
	}
	public void setSneakValue(int sneakValue) {
		this.sneakValue = sneakValue;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void setRecovery(int recovery) {
		this.recovery = recovery;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public void setLoadout(ArrayList<Weapon> loadout) {
		this.loadout = loadout;
	}
	public void setHostile(boolean hostile) {
		this.hostile = hostile;
	}
	public void setWeapon(Weapon equippedWeapon) {
		this.weapon = equippedWeapon;
	}
	public void setMoveUp(boolean moveUp) {
		this.moveUp = moveUp;
	}
	public void setMoveDown(boolean moveDown) {
		this.moveDown = moveDown;
	}
	public void setMoveLeft(boolean moveLeft) {
		this.moveLeft = moveLeft;
	}
	public void setMoveRight(boolean moveRight) {
		this.moveRight = moveRight;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setWalking(boolean walking) {
		this.walking = walking;
	}
	public void setStopImage(BufferedImage stopImage) {
		this.stopImage = stopImage;
	}
	public void setFacingUp(boolean facingUp) {
		this.facingUp = facingUp;
	}
	public void setFacingDown(boolean facingDown) {
		this.facingDown = facingDown;
	}
	public void setFacingLeft(boolean facingLeft) {
		this.facingLeft = facingLeft;
	}
	public void setFacingRight(boolean facingRight) {
		this.facingRight = facingRight;
	}
	
}
