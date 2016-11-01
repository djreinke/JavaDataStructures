package algorithms;

import static org.junit.Assert.assertEquals;

/**
 * This is a solution to the following algorithmic 
 * problem on HackerRank: 
 * https://www.hackerrank.com/challenges/fibonacci-modified
 * 
 * @author djreinke
 * 
 * Given terms t_i and t_i+1 where i is the set of all 
 * integers from 1 to infinity, term t_i+2 is computed using
 * the following relation: 
 * 
 * t_i+2 = t_i + (t_i+1)^2
 * 
 * Given three space separated integers, t_1, t_2, and n, this
 * program computes and prints the term t_n of a modified
 * Fibonacci sequence
 * 
 * Constraints: 
 * 0< = t_1
 * t_2 <= 2
 * 3 <= n <= 20
 * t_n may far exceed the range of a 64-bit integer
 * 
 * Output:
 * Prints a single integer denoting the value of term t+n
 * of the modified Fibonacci sequence where the first two
 * terms are t_1 and t_2
 * 
 * Sample input:
 * 0 1 5
 * 
 * Sample output: 
 * 5
 * 
 * Explanation: 
 * The first two terms of the sequence are
 * t_1 = 0 and t_2 = 1, which gives the modified Fibonacci
 * sequence of {0,1,1,2,5,27,...}. Because n = 5, we print term
 * t_5 which is 5. 
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import org.junit.Test;

public class FibonacciModified {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Use BigInteger because t_n may exceed the range of 64-bit integer
        BigInteger[] vals = new BigInteger[3];
        vals[0] = BigInteger.valueOf(scanner.nextInt());
        vals[1] = BigInteger.valueOf(scanner.nextInt());
        vals[2] = vals[0];
        int n = scanner.nextInt();
        
        System.out.print(fibonacciModified(vals, n));

    }
    
    public static BigInteger fibonacciModified(BigInteger arr[], int n){
        for(int i = 1; i <= n-2; i++){
            if(i%3 == 1)
                arr[2] = calculateFib(arr[0], arr[1]);
            else if(i%3 == 2)
                arr[0] = calculateFib(arr[1], arr[2]);
            else
                arr[1] = calculateFib(arr[2], arr[0]);
        }
        
        if((n-2)%3 == 1)
            return arr[2];
        else if((n-2)%3 == 2)
            return arr[0];
        else 
        	return arr[1];
    }
    
    public static BigInteger calculateFib(BigInteger tx, BigInteger ty){
        return tx.add(ty.multiply(ty));
    }
    
	/**
	 * Method to test fibonacciModified
	 */
	@Test
	public void testFibonacciModified01(){
		BigInteger[] vals = new BigInteger[3];
		
		vals[0] = BigInteger.valueOf(0);
        vals[1] = BigInteger.valueOf(1);
        vals[2] = vals[0];
        int n = 5;
		assertEquals(fibonacciModified(vals, n), BigInteger.valueOf(5));
		
	}
	
	/**
	 * Method to test fibonacciModified
	 */
	@Test
	public void testFibonacciModified02(){
		BigInteger[] vals = new BigInteger[3];
		
		vals[0] = BigInteger.valueOf(0);
        vals[1] = BigInteger.valueOf(1);
        vals[2] = vals[0];
        int n = 10;
        assertEquals(fibonacciModified(vals, n), new BigInteger("84266613096281243382112"));
	}

}
