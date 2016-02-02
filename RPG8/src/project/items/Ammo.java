package project.items;

public class Ammo extends Item{
	String name;
	String desc;
	int ammoType;
	public Ammo(String name, String desc,int ammoType) {
		super(name, desc);
		// TODO Auto-generated constructor stub
		this.name=name;
		this.desc=desc;
		this.ammoType=ammoType;
	}

	/** Type
	 *[1-Regular, 2-Energy] 
	 */
	
}
