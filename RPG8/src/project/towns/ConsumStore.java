package project.towns;

import java.util.ArrayList;

public class ConsumStore extends Store implements StoreInterface {
	
	int money;
	static ArrayList<Integer> itemNC = new ArrayList<Integer>();

	public ConsumStore(ArrayList<Integer> itemN, int money) {
		super(itemNC);
		this.money = money;
		for(int i = 0; i  < 3; i++){
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
					money = money - 450;
				}
			if(itemx == 192)
				if(money >= 350){
					itemNC.set(1,itemNC.get(1) + 1);
					money -= 350;
			}
			if(itemx == 292)
				if(money >= 250){
					itemNC.set(2, itemNC.get(2) + 1);
					money -= 250;
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
	
	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}

}
