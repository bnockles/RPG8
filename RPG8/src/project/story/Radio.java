package project.story;

import java.util.Random;

public class Radio extends storyDemo{

	public static void radioCall() {
		//System.out.println("Ammo " + Enemy.weapon);
		if(Math.abs(Swarm.getX()-enemy.getX()) + Math.abs(Swarm.getY()-enemy.getY()) < 200) {
			System.out.println("Enemy nearby");
		}
		else if(enemy.weapon < 4 && enemy.weapon > 0) {
			System.out.println("Low Ammo");
		}
		
		else {
			Random random = new Random();
			int pick = random.nextInt(3 - 1 + 1) + 1;
			if(pick == 1) {
				System.out.println("Avoid the Enemy at all costs!");
			}
			if(pick == 2) {
				System.out.println("The more contact you make with the Enemy, the stronger they will get");
			}
			if(pick == 3) {
				System.out.println("Focus on the mission!");
			}
			/*if(pick == 4) {
			 * System.out.println(dialogue);
			 */
		}
	}

}
