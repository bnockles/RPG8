package project.items;

public class TargetDemo implements Target, project.battles.HaveStats{
	int health;
	Weapons weapon;
	int coins;
	int scrap;
	Ammo ammo;
	boolean isBurned=false;
	boolean isCorrosive=false;
	boolean isStunned;
	boolean isRegen=false;
	String name;
	int armor;
	/**
	 * @author Qing Ning Huang, Stanley Ren, Jia Liu
	 */
	public TargetDemo(int health,Weapons weapon,Ammo ammo,int coins,int scrap,String name,Armor armor){
		this.weapon = weapon;
		this.health=health;
		this.ammo=ammo;
		this.coins=coins;
		this.scrap=scrap;
		this.name=name;
		this.armor=armor.getArmor();
		isStunned=false;
	}
	
	public void attack(final TargetDemo target){
		
		if(this.weapon.getAmmoTotal()!=0 || this.weapon.getGunNum()/10 ==1){
			int[] calcs = Armor.damageCalcs(this.weapon.getDamage(), target.health, target.armor);
			ammo.applyEffect(ammo.getEffect(), target);
			target.health = calcs[0];
			target.armor = calcs[1];
			//target.health-=this.weapon.getDamage();
			System.out.println(target.name + " Armor is: " + target.armor);
			if(this.weapon.getGunNum()/10 !=1){
				this.weapon.setAmmoTotal(this.weapon.getAmmoTotal()-1);				
			}
		}
		if(target.health<0){
			target.health=0;
		}
		
//		if(ammo.getEffect() == 3){
//			ItemScreen.isStun = true;
//			final int count = (int) (Math.random()*5+1);
//			final Timer timer = new Timer();
//			final TimerTask countDown = new TimerTask(){
//				public void run(){
//					if(duration>=count){
//						duration=0;
//						ItemScreen.isStun=false;
//						timer.cancel();
//					}else{
//						duration++;
//					}
//				}
//			};
//			timer.scheduleAtFixedRate(countDown, 1000, 1000);
//		}
	}
	
	public void reload(){
		if(this.weapon.getAmmoCapacity()!=0){
			this.weapon.setAmmoTotal(this.weapon.getAmmoClip());
			this.weapon.setAmmoCapacity(this.weapon.getAmmoCapacity()-1);
		}
	}

	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return 0; // chieh here just to comment stuff, why 0?
	}
	@Override
	public int getMaxHP() {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public int getCurrentHP() {
		// TODO Auto-generated method stub
		return health;
	}

	@Override
	public void setCurrentHP(int currentHP) {
		// TODO Auto-generated method stub
		health = currentHP;
	}

	@Override
	public boolean isRegen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setRegen(boolean regen) {
		// TODO Auto-generated method stub
		
	}
}
