<<<<<<< HEAD
=======
package project.storyV2;

>>>>>>> refs/remotes/origin/storyline
public class Center implements StringCenterer {
	public int centerString(String s, int whereBoxBeginsX, int widthOfBox, int widthOfEachCharacterInPixels) {
                int x = (widthOfBox-widthOfEachCharacterInPixels)/2;
                return x+whereBoxBeginsX;

        }

}
