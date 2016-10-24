package dataStructures;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArrayOperations {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,4,8,16,32};
		reversePrintArray(array);
		
		int[][] twoDArr = new int[][]{
			  { 1, 2, 1},
			  { 2, 3, 2},
			  { 1, 2, 1}
		};
		calculateSumOfDiagonals(twoDArr);
	}
	
	public static void reversePrintArray(int[] arr){
		for(int i = arr.length-1; i >= 0; i--){
			System.out.print(arr[i] + " ");
		}
	}
	
	/**
	 * Accepts a 6x6 2D array and splits it up into 16
	 * 3x3 sub arrays. Then calls calculateHourGlassSum
	 * to get the max sum returned from that function.
	 * 
	 * @param arr
	 * @return maximum hour-glass sum
	 */
	public static int calculateHigestHourGlassSum(int[][] arr){
		int sum = -37;
        // for rows 0,1,2,3
        for(int row = 0; row < arr.length-2; row++){
            // for cols 0,1,2,3
            for(int col = 0; col < arr.length-2; col++){
                int[][] tempArr = new int[3][3];
                for(int subRow = 0; subRow < 3; subRow++){
                    for(int subCol = 0; subCol < 3; subCol++){
                        tempArr[(subRow)][(subCol)] = arr[(row+subRow)][(col+subCol)];
                    }
                }
                int thisSum = calculateHourGlassSum(tempArr);
                if(sum == -37){
                    sum = thisSum;
                }
                else{
                    if(thisSum > sum)
                        sum = thisSum;
                }
            }
        }
        return sum;
	}
	
	/**
	 * Given a 2-dimensional 3*3 array, this function calculates
	 * the 'hour glass' sum of the array. That is it sums elements
	 * in the first row, the second element of the second row, and
	 * the third row and returns the result.
	 * 
	 * For example given this 2D 3*3 array:  
	 * 
	 * 1 3 4
	 * 1 2 1
	 * 1 1 5
	 * 
	 * We would calculate the sum of the following (ignoring values
	 * at x)
	 * 
	 * 1 3 4
	 * x 2 x
	 * 1 1 5
	 * 
	 * And return: 15
	 * @return hour glass sum
	 */
	public static int calculateHourGlassSum(int[][] arr){
        int sum = 0;
        for(int row = 0; row < arr.length; row++){
            for(int col = 0; col < arr.length; col++){
                if(row == 1){
                 if(col == 1){
                     sum += arr[row][col];
                 }   
                }
                else{
                    sum += arr[row][col];
                }
            }
        }
        return sum;
    }
	
	/**
	 * Returns sum of diagonals for an N x N array
	 * @param arr
	 * @return sum of diagonals
	 */
	public static int calculateSumOfDiagonals(int[][] arr){
		int sum = 0;
		for(int i = 0, z = arr.length-1; i < arr.length; i++, z--){
			sum+= arr[i][z];
			sum+= arr[i][i];
		}
		return sum;
	}
	
	@Test
	public void testCalculateSumOfDiagonals(){
		int[][] arr = new int[][]{
			  { 1, 2, 1},
			  { 2, 3, 2},
			  { 1, 2, 1}
		};
		assertEquals(calculateSumOfDiagonals(arr), 10);
	}

}
