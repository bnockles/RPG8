package project.items;

public class Ammo extends Item{
	private String name;
	private String desc;
	private int ammoType;
	
	public Ammo(String name, String desc,int cost,int ammoType, int effect) {
		super(name, desc, cost, effect);
		// TODO Auto-generated constructor stub
		this.name=name;
		this.desc=desc;
		this.ammoType=ammoType;
	}

	/** Type
	 *[1-Regular, 2-Energy] 
	 */
	
}
