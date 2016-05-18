public class Center implements StringCenterer {
	public int centerString(String s, int whereBoxBeginsX, int widthOfBox, int widthOfEachCharacterInPixels) {
                int x = (widthOfBox-widthOfEachCharacterInPixels)/2;
                return x+whereBoxBegins;

        }

}