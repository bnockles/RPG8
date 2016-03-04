package project.storyV2.demo;

import java.util.ArrayList;

import project.directors.Game;
import project.story.Hero;

public class StoryDemo extends Game {
	final static ArrayList<String> AyaForward = new ArrayList<String>();
	private static String forward = "/images/heroes/sForward.png";
	private static String forward1 = "/images/heroes/forward1.png";
	private static String forward2 = "/images/heroes/forward2.png";
	final static ArrayList<String> AyaLeft = new ArrayList<String>();
	private static String left = "/images/heroes/sLeft.png";
	private static String left1 = "/images/heroes/left1.png";
	private static String left2 = "/images/heroes/left2.png";
	final static ArrayList<String> AyaRight = new ArrayList<String>();
	private static String right = "/images/heroes/sRight.png";
	private static String right1 = "/images/heroes/right1.png";
	private static String right2 = "/images/heroes/right2.png";
	final static ArrayList<String> AyaBack = new ArrayList<String>();
	private static String back = "/images/heroes/sBack.png";
	private static String back1 = "/images/heroes/back1.png";
	private static String back2 = "/images/heroes/back2.png";
	final static ArrayList<String> AyaStanding = new ArrayList<String>();
	public static Hero Swarm;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AyaForward.add(forward1);
		AyaForward.add(forward2);
		AyaLeft.add(left1);
		AyaLeft.add(left2);
		AyaRight.add(right1);
		AyaRight.add(right2);
		AyaBack.add(back1);
		AyaBack.add(back2);
		AyaStanding.add(forward);
		AyaStanding.add(left);
		AyaStanding.add(right);
		AyaStanding.add(back);
		Swarm = new Hero("Aya Drevis", 105, 105);
		Swarm.animate(AyaStanding.get(0));
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
