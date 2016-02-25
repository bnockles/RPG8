/**
 * 
 */
package reference;

/**
 * @author bnockles
 *
 */
public class SampleTarget implements Target {

	static int targetNumber=0;
	String name;
	boolean hit;
	
	/**
	 * 
	 */
	public SampleTarget() {
		targetNumber++;
		name = "Target "+targetNumber+ " (has not used items yet)";
		hit = false;
	}

	/* (non-Javadoc)
	 * @see enemies.Demo.Target#hit()
	 */
	public void use(SampleItem e) {
		name = name.replace(" not", "").replace(" yet", "");
		ItemScreen.battleMessage=name+ " used "+e.name;

	}

	public String getName() {
		return name;
	}
	

}
