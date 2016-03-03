package project.towns;

public class Homework {

	/**
	 * @param args
	 */
		static int[][] g ={{9, 8, 7, 6},         

			   {5, 4, 2, 1},

			   {3, 9, 2, 3}};

			public static void main(String[] args) {
				// TODO Auto-generated method stub
				rowMajorOrder(g);
			}
			//QUESTION 8
			
			public static int[] rowMajorOrder(int[][] nums)
				{
					int t = 0;
					int[] array = new int[nums.length*nums[0].length];
					for(int x = 0; x< nums.length; x++)
						for(int y = 0; y <nums[x].length;y++){
							array[t] = nums[x][y];
							t++;
						}
					for(int p = 0; p <array.length; p++)
						System.out.println(array[p]);
					return array;
			
				}
			public int[][] posToNeg2D(int[][] mat, int x, int y)
			//QUESION 7
			{
				
				//THIS COULD PROBABLY BE SIMPLIFIED BY USING DISTANCE BUT I GOT SO FAR AND 
				//MY EGO WONT ALLOW ME TO CHANGE IT.
				//EDIT: I BEAT MY EGO.
//				if(x>0){
//					if(y > 0){
//						if(y < mat.length -1){
//							if(x < mat[x].length-1){
//								mat[x + 1][y] = mat[x+1][y] * - 1;
//								mat[x][y+1] = mat[x][y+1] * - 1;
//								mat[x-1][y] = mat[x-1][y] * - 1;
//								mat[x][y-1] = mat[x][y-1] * - 1;
//								mat[x+1][y+1] = mat[x+1][y+1] * - 1;
//								mat[x-1][y-1] = mat[x-1][y-1] * - 1;
//								mat[x+1][y-1] = mat[x+1][y-1] * - 1;
//								mat[x-1][y+1] = mat[x-1][y+1] * - 1;
//							}
//							else{
//								mat[x][y+1] = mat[x][y+1] * - 1;
//								mat[x-1][y] = mat[x-1][y] * - 1;
//								mat[x][y-1] = mat[x][y-1] * - 1;
//								mat[x-1][y-1] = mat[x-1][y-1] * - 1;
//								mat[x-1][y+1] = mat[x-1][y+1] * - 1;
//							}
//						}
//						else{
//							mat[x + 1][y] = mat[x+1][y] * - 1;
//							mat[x-1][y] = mat[x-1][y] * - 1;
//							mat[x][y-1] = mat[x][y-1] * - 1;
//							mat[x-1][y-1] = mat[x-1][y-1] * - 1;
//							mat[x+1][y-1] = mat[x+1][y-1] * - 1;
//						}
//					}
//					else{
//						mat[x + 1][y] = mat[x+1][y] * - 1;
//						mat[x][y+1] = mat[x][y+1] * - 1;
//						mat[x-1][y] = mat[x-1][y] * - 1;
//						mat[x+1][y+1] = mat[x+1][y+1] * - 1;
//						mat[x-1][y+1] = mat[x-1][y+1] * - 1;
//					}
//				}
//				else{
//					mat[x + 1][y] = mat[x+1][y] * - 1;
//					mat[x][y+1] = mat[x][y+1] * - 1;
//					mat[x][y-1] = mat[x][y-1] * - 1;
//					mat[x+1][y+1] = mat[x+1][y+1] * - 1;
//					mat[x+1][y-1] = mat[x+1][y-1] * - 1;
//				}
				int[][] arrays = mat;
				for(int i = 0 ; i < mat.length ; i++){
					
					for(int j = 0 ; j < mat[i].length ; j++){
					
						if((Math.abs(x-i) == 1 && Math.abs(y-j) == 1) || Math.abs(x-i) 
								==1 && Math.abs(y-j) == 0 || Math.abs(x-i) == 0 && Math.abs(y-j) ==1  ){
						arrays[i][j] = mat[i][j] * -1;
						}
					}
				}	
				return mat;
			
			}
	}

