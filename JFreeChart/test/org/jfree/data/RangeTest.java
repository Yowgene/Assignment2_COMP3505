package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RangeTest {
	
	private Range exampleRange;

    @BeforeEach
    void setUp() {
        exampleRange = new Range(-1, 1);
    }
    
    /*
     * getCentralValue()
     */

    @Test
    void testGetCentralValue() {
        exampleRange = new Range(2, 6);
        //
        assertEquals(0, exampleRange.getCentralValue(), 0.0001,
        		"The central value of (-1, 1) should be 0");
        //
        assertEquals(4, exampleRange.getCentralValue(), 0.0001,
                "The central value of (2, 6) should be 4");
        //
        assertEquals(3, exampleRange.getCentralValue(), 0.0001,
        		"The central value of (3, 3) should be 3");
    }
    /*
     * getLength()
     */
    @Test
    void testGetLength() {
        exampleRange = new Range(1, 5);
        assertEquals(4, exampleRange.getLength(), 0.0001,
                "The length of (1, 5) should be 4");
    }    
    /*
     * contains(double)
     */

    @Test
    void testContainsValue() {
        exampleRange = new Range(1, 5);
        //
        assertEquals(0, exampleRange.getLength(), 0.0001,
        		"The length of (3, 3) should be 0");
        //
        assertFalse(exampleRange.contains(0),
                "Range (1,5) should not contain values below the lower bound");
        //
        assertFalse(exampleRange.contains(6),
        		"Range (1,5) should not contain values above the upper bound");
        //
        assertTrue(exampleRange.contains(1),
        		"Range (1,5) should contain its lower bound");
        //
        assertTrue(exampleRange.contains(5),
        		"Range (1,5) should contain its upper bound");
       //
        assertTrue(exampleRange.contains(3),
    			"Range (1,5) should contain 3");
    }
    
    @Test
    void testContainsNull() {
    	exampleRange = new Range(null,null);
    	assertTrue(exampleRange.contains(null), 
    			"Range should not contain null value.");
    }
    
    @Test
    //This test is just an example, 2 is not constant
    void testShift() {
    	Range testRange = Range.shift(exampleRange, 2.0, true);
    	assertTrue(3,testRange.getUpperBound(),0.001,
    			"Range shift should not be more than 2!");
    	Range testRange2 = Range.shift(exampleRange,2.0,true);
    	assertTrue(1,testRange.getLowerBound(),0.001,
    			"Range shift should not be more than 2!");
    }
    
    
    @Test
    //This test is just an example, 2 is not constant
    void testConstrain() {
    	double test = exampleRange.constrain(5.0);
    	assertTrue(test <= 1,
    			"Range should not be over than the actual upper Range");
    	double test2 = exampleRange.constrain(-5);
    	assertTrue(test >= -1,
    			"Range should not be over than the actual lower Range");
    }
}
