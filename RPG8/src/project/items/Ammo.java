package project.items;

public class Ammo extends Item{
	private String name;
	private String desc;
	private int ammoType;
	private String itemImage;
	

	public Ammo(String name, String desc,int cost,int ammoType, int effect, String itemImage) {
		super(name, desc, cost, effect, itemImage);
		// TODO Auto-generated constructor stub
		this.name=name;
		this.desc=desc;
		this.ammoType=ammoType;
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	public int getAmmoType() {
		return ammoType;
	}

	public String getItemImage() {
		return itemImage;
	}
	/** Type
	 *[1-Regular, 2-Energy] Qing Ning Huang
	 */
	
}
