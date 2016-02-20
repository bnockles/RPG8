package project.mainmenudemo;


import project.directors.Screen;

public class MenuDemo extends project.directors.Game{
		// TODO Auto-generated constructor stub
	
	public static void main(String[] args) {
		new MenuDemo();
	}
	
	public void reset() {
		Screen demoScreen = new MainMenuScreen(this);
		setScreen(demoScreen);
		repaint();
	}
}
