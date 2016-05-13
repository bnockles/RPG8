package project.oldsave;

public class ItemState {

	boolean potionCollected;
	
	public ItemState(boolean isPotionCollected) {
		potionCollected=isPotionCollected;
	}

	public boolean isPotionCollected() {
		return potionCollected;
	}

	public void setPotionCollected(boolean potionCollected) {
		this.potionCollected = potionCollected;
	}

}
