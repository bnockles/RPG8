package project.towns;

import java.util.ArrayList;

import project.items.ItemResources;

public class ArmorStore implements StoreInterface{

	double money;
	ArrayList<ShopItems> itemListA = new ArrayList<ShopItems>(){{add((ShopItems) ItemResources.yourarmor);};};
	ArrayList<Integer> itemNA = new ArrayList<Integer>();
	public ArmorStore(ArrayList<Integer> itemN, double d) {
		this.money = d;
		for(int i = 0; i  < itemListA.size(); i++){
			itemNA.add(i, 0);
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public void moneyInteraction(int itemx) {
		// TODO Auto-generated method stub
		if(itemx == 92)
			if(money >= 450){
					itemNA.set(0, itemNA.get(0) + 1);
					TownScreen.playable.setMoney(TownScreen.playable.getMoney() - itemListA.get(0).getPrice());
				}
			if(itemx == 192)
				if(money >= 350){
					itemNA.set(1,itemNA.get(1) + 1);
					TownScreen.playable.setMoney(TownScreen.playable.getMoney() - itemListA.get(1).getPrice());
				}
			if(itemx == 292)
				if(money >= 250){
					itemNA.set(2, itemNA.get(2) + 1);
					TownScreen.playable.setMoney(TownScreen.playable.getMoney() - itemListA.get(2).getPrice());
				}
	}

	@Override
	public void moneySellingInteraction(int itemx) {
		// TODO Auto-generated method stub
		if(itemx == 92)
			if(itemNA.get(0) > 0){
					itemNA.set(0, itemNA.get(0) - 1);
					TownScreen.playable.setMoney(TownScreen.playable.getMoney() + itemListA.get(0).getPrice());
				}
			if(itemx == 192)
				if(itemNA.get(0) > 0){
					itemNA.set(1,itemNA.get(1) - 1);
					TownScreen.playable.setMoney(TownScreen.playable.getMoney() + itemListA.get(1).getPrice());
				}
			if(itemx == 292)
				if(itemNA.get(0) > 0){
					itemNA.set(2, itemNA.get(2) - 1);
					TownScreen.playable.setMoney(TownScreen.playable.getMoney() + itemListA.get(2).getPrice());
				}
			if(itemx == 392)
				if(itemNA.get(0) > 0){
					itemNA.set(3, itemNA.get(3) - 1);
					TownScreen.playable.setMoney(TownScreen.playable.getMoney() + itemListA.get(3).getPrice());
				}
	}
	 
	public void setMoney(double d) {
		this.money = d;
	}

	public double getMoney() {
		// TODO Auto-generated method stub
		return money;
	}

}
