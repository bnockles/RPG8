package project.storyV2;

import project.menus.StringCenterer;

public class Center implements StringCenterer {
	public static int centerStringStatic(String s, int whereBoxBeginsX, int widthOfBox, int widthOfEachCharacterInPixels) {
                int x = (widthOfBox-widthOfEachCharacterInPixels*s.length())/2;
                return x+whereBoxBeginsX;
        }

	@Override
	public int centerString(String s, int whereBoxBeginsX, int widthOfBox, int widthOfEachCharacterInPixels) {
		// TODO Auto-generated method stub
		return centerStringStatic(s, whereBoxBeginsX, widthOfBox, widthOfEachCharacterInPixels);
	}

}
