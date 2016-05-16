package project.overworld;

import project.directors.Game;



public class MapDemonstration extends Game {

	public static void main(String[] args){
		new MapDemonstration();
	}
	public MapDemonstration(){
		super();
	}
	public void reset() {
		MapDemoScreen MapDemoScreen = new MapDemoScreen(this);
		setScreen(MapDemoScreen);
	}
}
