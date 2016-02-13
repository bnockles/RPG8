/**
 * 
 */
package reference;

import java.util.ArrayList;

/**
 * @author Mr. Nockles
 * I made this for my demo. This is bare bones!
 *
 */
public class SampleItem {

	ArrayList<Target> targets;
	public String name;
	/**
	 * 
	 */
	public SampleItem(int number, ArrayList<Target> targets) {
		name = "Item "+number;
		this.targets=targets;
	}
	
	//the following method will most likely be
	//something required by the Battles team. It is likely they will 
	//require a method for taking a turn in a battle
	public void use(){
		int targetSelection = (int) (Math.random()*targets.size());
		targets.get(targetSelection).use(this);
	}

}
