package project.battles;

import project.directors.Character;

public abstract class EnemyAI extends Character{
	abstract void movement();
	abstract void sight();
}
