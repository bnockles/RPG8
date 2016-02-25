package project.story;

import project.directors.Game;
//test
public class EnemyDynamic extends storyDemo{
	
	public static void strengthen() {
		enemy.strength+=10;
		System.out.println("enemy strength " + enemy.strength);
	}
	public static void detectHit() {
		if(Math.abs(Swarm.getX()-enemy.getX()) + Math.abs(Swarm.getY()-enemy.getY()) < 20)
		{
			strengthen();
			enemy.randomX();
			enemy.randomY();
		}
	}

}
