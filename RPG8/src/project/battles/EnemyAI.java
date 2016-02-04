package project.battles;

import project.directors.Character;

public abstract class EnemyAI implements Character{
	abstract void movement();
	abstract void sight();
}
