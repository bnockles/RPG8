package project.story;

import project.directors.Game;

public class EnemyDynamic extends storyDemo{
	
	public void strengthen() {
		Enemy.strength+=10;
		System.out.println("enemy strength " + Enemy.strength);
	}
	public static void detectHit() {
		if(Math.abs(Aya.getX()-Enemy.getX()) + Math.abs(Aya.getY()-Enemy.getY()) < 20)
		{
			strengthen();
			Enemy.randomX();
			Enemy.randomY();
		}
	}

}
