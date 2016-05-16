package project.towns;

public class samplehwwwww {
	
	public static int[] rowMajorOrder(int[][]nums)
	{
		int[] rowMajorOrder = new int[nums.length*nums[0].length] ;
		int counter = 0;
		for(int i = 0 ; i < nums.length ; i++)
		{
			for(int j = 0 ; j < nums[i].length ; j++)
			{
				rowMajorOrder[counter] =  nums[i][j];
				counter++;
			}
		}
		return rowMajorOrder ;
	}
	
	
	public static int[][] posToNeg2D(int[][] mat, int x, int y)
	{
		int[][] newArrays = mat ;
		
		
//		int up= mat[x+1][y]
//		int down= mat[x-1][y]
//		int upleft = mat[x-1][y-1] 
//		int mat[x+1][y+1] 
//		int left = mat[x][y-1] 
//		int upright = mat[x-1][y+1] 
//		int downleft = mat[x+1][y-1] 
//		int downright = mat[x+1][y+1]; 	
//		int right = mat[x][y+1] 
//			
//			if(x != 0 && x != mat.length -1 && y != 0 && y!= mat[x].length-1){
//				
//			}
		for(int i = 0 ; i < mat.length ; i++){
		
			for(int j = 0 ; j < mat[i].length ; j++){
			
				if((Math.abs(x-i) == 1 && Math.abs(y-j) == 1) || Math.abs(x-i) ==1 && Math.abs(y-j) == 0 || Math.abs(x-i) == 0 && Math.abs(y-j) ==1  ){
				newArrays[i][j] = mat[i][j] * -1;
				}
			}
		}	
				
				
		return newArrays ;

}
