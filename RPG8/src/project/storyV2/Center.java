package project.storyV2;

import project.menus.StringCenterer;

public class Center implements StringCenterer {
	public int centerString(String s, int whereBoxBeginsX, int widthOfBox, int widthOfEachCharacterInPixels) {
                int x = (widthOfBox-widthOfEachCharacterInPixels*s.length())/2;
                return x+whereBoxBeginsX;

        }

}
