package project.controls;

public class Status {
		private String name;
		private int speedModifier;
		boolean effect;
		String eName;
		public Status(String name, int speedModifier, String eName, boolean effect){
			this.name=name;
			this.speedModifier=speedModifier;
			this.eName=eName;
			this.effect=effect;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setSpeedModifier(int speedModifier) {
			this.speedModifier = speedModifier;
		}
		public void setEffect(boolean effect) {
			this.effect = effect;
		}
		public void seteName(String eName) {
			this.eName = eName;
		}
		public String getName() {
			return name;
		}
		public int getSpeedModifier() {
			return speedModifier;
		}
		public boolean isEffect() {
			return effect;
		}
		public String geteName() {
			return eName;
		}	
}