package project.towns;



public class SampleShopItem implements ShopItems {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public SampleShopItem(){
		//default shop item
	}

	@Override
	public boolean isSellable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isBuyable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Stuff";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Stuff";
	}



}
