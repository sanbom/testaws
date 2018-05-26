/**
 * 
 */
package com.test;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author sandeep
 *
 */
public class TestStringCalculator {

	/**
	 * Test method for {@link com.test.StringCalculator#add(java.lang.String)}.
	 */
	
	
	@Test
	public final void whenOneNumberIsUsedThenReturnValueIsThatSameNumber() {
	    Assert.assertEquals(3, StringCalculator.add("3"));
	}
	 
	@Test
	public final void whenTwoNumbersAreUsedThenReturnValueIsTheirSum() {
	    Assert.assertEquals(3+6, StringCalculator.add("3,6"));
	}

}
