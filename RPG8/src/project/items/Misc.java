package project.items;

public class Misc extends Item{
	private String name;
	private String desc;
	private boolean coin;
	private int cost;
	
		
		public Misc(String name, String desc,boolean coin, int cost, int effect, String itemImage){
			super(name,desc, cost, effect, itemImage);
		}
		
	}

