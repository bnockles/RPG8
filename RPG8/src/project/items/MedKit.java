package project.items;

public class MedKit extends Item {
	//stanley's class
	private String name;
	private String desc;
	private int cost;
	private int healthGained;
	private int effect;

	public MedKit(String name, String desc,int cost, int healthGained, int effect) {
		super(name, desc, cost, effect);
		this.healthGained=healthGained;
		this.effect=effect;
		// TODO Auto-generated constructor stub
	}
	
	//Health regained by clicking to use
	/**public int giveHealth(Character b){
		int charHealth=b.getHealth();
		charHealth+=this.healthGained;
	}**/
	public void giveHealth(TargetDemo b){
		b.health+=this.healthGained;
		regen(b);
		if(b.health>100){
			b.health=100;
		}
	}
	public void regen(TargetDemo b){
		if(this.getEffect()==4){
			int changed=0;
			long timenow=System.nanoTime();
			System.out.println(timenow);
			while((System.nanoTime()-timenow)/1000000000<=10){
				if((System.nanoTime()-timenow)/1000000000!=changed){
					changed++;
					b.health+=this.getHealthGained();
					update();
					//System.out.println("Health"+health);
				}
			}
		}
	}

	public int getEffect() {
		return effect;
	}
	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	public int getCost() {
		return cost;
	}

	public int getHealthGained() {
		return healthGained;
	}
}
