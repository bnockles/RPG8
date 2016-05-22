package project.towns;

import java.awt.Component;
import java.util.ArrayList;

import project.items.ItemResources;

public class ConsumStore implements StoreInterface {
	
	double money;
	ArrayList<Integer> itemNC = new ArrayList<Integer>();
	ArrayList<ShopItems> itemListC = new ArrayList<ShopItems>(){{add(ItemResources.rifleAmmo); add(ItemResources.heavyAmmo); add(ItemResources.SMGAmmo); add(ItemResources.pistolAmmo);}};
	ArrayList<String> itemListCDes = new ArrayList<String>();
	int count = 4;
	public ConsumStore(ArrayList<Integer> itemN, double d) {
		this.money = d;
		for(int i = 0; i  < count; i++){
			itemNC.add(i, 0);
			itemListCDes.add(i, itemListC.get(i).getDescription());
			System.out.println(itemListCDes.get(i));
			//itemListWPics.add(i, itemListW.get(i));
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public void moneyInteraction(int itemx) {
		// TODO Auto-generated method stub
		int x = 92;
		for(int i = 0; i < count; i++){
			if(itemx == x){
				itemNC.set(i, itemNC.get(i) + 1);
				TownScreen.playable.setMoney(TownScreen.playable.getMoney() - itemListC.get(i).getPrice());
			}
			x+=100;
		}
	}
	
	@Override
	public void moneySellingInteraction(int itemx) {
		// TODO Auto-generated method stub
		int x = 92;
		for(int i = 0; i < count; i++){
			if(itemx == x){
				itemNC.set(i, itemNC.get(i) - 1);
				TownScreen.playable.setMoney(TownScreen.playable.getMoney() + itemListC.get(i).getPrice());
			}
			x+=100;
		}
	}

	
	public ArrayList<Integer> getItemNC() {
		return itemNC;
	}

	public double getMoney() {
		return money;
	}


	public void setMoney(double d) {
		this.money = d;
	}

	public ArrayList<ShopItems> getItemListC() {
		return itemListC;
	}


}
