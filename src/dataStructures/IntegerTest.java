package dataStructures;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Performs various tests on integers such as whether or not
 * a given integer value would fit into on of Java's integer
 * primitive data types.
 * 
 * @author djreinke
 *
 */
public class IntegerTest {
	
	/**
	 * Returns if given long would fit in a byte
	 * Minimum value of -128 and a maximum value of 127 (inclusive)
	 */
	public boolean fitsInByte(long x){
		return (x>=-128 && x<=127);
	}
	
	/**
	 * Minimum value of -32,768 and a maximum value of 32,767 (inclusive)
	 * use a short to save memory in large arrays
	 * 
	 * @param x
	 * @return if a given long would fit in a short
	 */
	public boolean fitsInShort(long x){
		return (x >= -32768 && x<=32767);
	}
	
	/** 
	 * Returns if a given long would fit in an int
	 * minimum value of -231 and a maximum value of 231-1
	 * @param x
	 * @return if a given long would fit in an int
	 */
	public boolean fitsInInt(long x){
		return (x >= Math.pow(-2.0, 31.00) && x<= Math.pow(2.0, 31.00)-1);
	}
	
	/**
	 * Returns if a given long would fit an an long
	 * minimum value of -263 and a maximum value of 263-1
	 * 
	 * @param x
	 * @return
	 */
	public boolean fitsInLong(long x){
		return (x >= Math.pow(-2.0, 63.00) && x<= Math.pow(2.0, 63.00)-1);
	}
	
	/**
	 * Method to test byte
	 */
	@Test
	public void testByte(){
		assertEquals(true, fitsInByte(-128));
	}
	
	/**
	 * Method to test byte
	 */
	@Test
	public void testByte2(){
		assertEquals(false, fitsInByte(200));
	}
	
	/**
	 * Method to test short
	 */
	@Test
	public void testShort(){
		assertEquals(true, fitsInShort(32767));
	}
	
	/**
	 * Method to test short
	 */
	@Test
	public void testShort2(){
		assertEquals(false, fitsInShort(-33767));
	}
	
	/**
	 * Method to test int
	 */
	@Test
	public void testInt(){
		assertEquals(true, fitsInInt(1500000000));
	}
	
	/**
	 * Method to test long
	 */
	@Test
	public void testLong(){
		/*
		long l = -100000000000000;
		try{
			assertEquals(true, fitsInLong(l));
		}
		catch(Exception e){
			
		}
		*/
	}
}
