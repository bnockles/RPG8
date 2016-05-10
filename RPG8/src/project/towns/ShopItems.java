package project.towns;

public interface ShopItems {
	
	public boolean isSellable();
	
	public boolean isBuyable();
	
	public double getPrice();
	
	public String getName();
	
	public String getDescription();
}
