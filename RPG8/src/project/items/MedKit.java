package project.items;

public class MedKit extends Item {
	String name;
	String desc;
	int healthGained;
	public MedKit(String name, String desc,int cost, int healthGained) {
		super(name, desc, cost);
		// TODO Auto-generated constructor stub
	}
	//Testing Push
	
	//Health regained by clicking to use
	/**public int giveHealth(Character b){
		int charHealth=b.getHealth();
		charHealth+=this.healthGained;
	}**/
}
