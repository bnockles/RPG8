package project.items;

public class MedKit extends Item {
	//stanley's class
	private String name;
	private String desc;
	private int cost;
	private int healthGained;
	public MedKit(String name, String desc,int cost, int healthGained, int effect) {
		super(name, desc, cost, effect);
		this.healthGained=healthGained;
		// TODO Auto-generated constructor stub
	}
	
	//Health regained by clicking to use
	/**public int giveHealth(Character b){
		int charHealth=b.getHealth();
		charHealth+=this.healthGained;
	}**/
	public void giveHealth(TargetDemo b){
		b.health+=this.healthGained;
		if(b.health>100){
			b.health=100;
		}
	}
}
