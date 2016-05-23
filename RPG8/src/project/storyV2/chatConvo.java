package project.storyV2;

public class chatConvo {
	String charName;
	String dialogue;
	public chatConvo(String charName, String dialogue) {
		this.charName = charName;
		this.dialogue = dialogue;
	}
	public String getName() {
		return charName;
	}
	public String getDialogue() {
		return dialogue;
	}
}
