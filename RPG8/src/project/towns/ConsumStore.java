package project.towns;

import java.util.ArrayList;

import project.items.ItemResources;

public class ConsumStore implements StoreInterface {
	
	double money;
	ArrayList<Integer> itemNC = new ArrayList<Integer>();
	ArrayList<ShopItems> itemListC = new ArrayList<ShopItems>(){{add((ShopItems) ItemResources.rifleAmmo); add((ShopItems) ItemResources.fireRifleAmmo); add((ShopItems) ItemResources.stunRifleAmmo); add((ShopItems) ItemResources.pistolAmmo);}};
	public ConsumStore(ArrayList<Integer> itemN, int money) {
		this.money = money;
		for(int i = 0; i  < itemNC.size(); i++){
			itemNC.add(i, 0);
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public void moneyInteraction(int itemx) {
		// TODO Auto-generated method stub
		if(itemx == 92)
			if(money >= 450){
					itemNC.set(0, itemNC.get(0) + 1);
					money = money - itemListC.get(0).getPrice();
				}
			if(itemx == 192)
				if(money >= 350){
					itemNC.set(1,itemNC.get(1) + 1);
					money = money - itemListC.get(1).getPrice();
				}
			if(itemx == 292)
				if(money >= 250){
					itemNC.set(2, itemNC.get(2) + 1);
					money = money - itemListC.get(2).getPrice();
				}
			if(itemx == 392)
				if(money >= 250){
					itemNC.set(3, itemNC.get(3) + 1);
					money = money - itemListC.get(3).getPrice();
				}
	}
	public void AllSellingInteraction(int itemx) {
		// TODO Auto-generated method stub
		if(itemx == 92){
			if(itemNC.get(0) > 0){
				money = money + 450;
			}
		}
		if(itemx == 192){
			if(itemNC.get(1) > 0){
				money = money + 350;
			}
		}
		if(itemx == 292){
			if(itemNC.get(2) > 0){
				money = money + 250;
			}
		}
		if(itemx == 392){
			if(itemNC.get(2) > 0){
				money = money + 150;
			}
		}
	}
	public void AllInteraction(int itemx) {
		// TODO Auto-generated method stub
		if(itemx == 92)
		if(money >= 450){
				money = money - 450;
			}
		if(itemx == 192)
			if(money >= 350){
				money -= 350;
			}
		if(itemx == 292)
			if(money >= 250){
				money -= 250;
			}
		if(itemx == 392)
			if(money >= 250){
				money -= 150;
			}
		}

	@Override
	public void moneySellingInteraction(int itemx) {
		// TODO Auto-generated method stub
		if(itemx == 92){
			if(itemNC.get(0) > 0){
				itemNC.set(0, itemNC.get(0) - 1);
				money = money + 450;
			}
		}
		if(itemx == 192){
			if(itemNC.get(1) > 0){
				itemNC.set(1, itemNC.get(1) - 1);
				money = money + 350;
			}
		}
		if(itemx == 292){
			if(itemNC.get(2) > 0){
				itemNC.set(2, itemNC.get(2) - 1);
				money = money + 250;
			}
		}
	}

	@Override
	public void itemSellingInteraction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemInteraction() {
		// TODO Auto-generated method stub
		
	}
	
	public double getMoney() {
		return money;
	}


	public void setMoney(double d) {
		this.money = d;
	}

}
