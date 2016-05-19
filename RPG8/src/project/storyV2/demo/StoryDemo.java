package project.storyV2.demo;

import project.directors.Game;

@SuppressWarnings("serial")
public class StoryDemo extends Game {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StoryDemo();
	}
	protected StoryDemo(){
		super();
		
	}
	public void reset(){
		StoryScreen storyScreen = new StoryScreen(this);
		setScreen(storyScreen);
		activeScreen.update();
		repaint();
	}

}
