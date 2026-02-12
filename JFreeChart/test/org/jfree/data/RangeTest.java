package org.jfree.data;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;


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
        assertEquals(4, exampleRange.getCentralValue(), 0.0001,
                "The central value of (2, 6) should be 4");
    }
    /*
     * getLength()
     */
    
    @Test
    void testBounds() {
    	Range exampleRange = new Range(1,5);
    	assertEquals(1,exampleRange.getLowerBound(),
    			"Lower range should equals to the lowerbound range");
    	assertEquals(5,exampleRange.getUpperBound(),
    			"Upper range should equals to the higherbound range");
    }
    @Test
    void testGetLength() {
        Range exampleRange = new Range(1, 5);
        assertEquals(4, exampleRange.getLength(), 0.0001,
                "The length of (1, 5) should be 4");
    }    
    
    @Test
    void testIntersect() {
    	Range exampleRange = new Range(1,5);
    	//
    	assertTrue(exampleRange.intersects(2,6)
    			,"This should intersect!");
    	//
    	assertTrue(exampleRange.intersects(2,4),
    			"This should intersect!");
    	//
    	assertTrue(exampleRange.intersects(-5,1),
    			"This should intersect!");
    	//
    	assertTrue(exampleRange.intersects(5,10),
    			"This should intersect!");
    	//
    	assertFalse(exampleRange.intersects(-5,0),
    			"This should not intersect!");
    	//
    	assertFalse(exampleRange.intersects(6,10),
    			"This should not intersect!");
    	}
    /*
     * contains(double)
     */

    @Test
    void testContainsValue() {
        Range exampleRange = new Range(1, 5);
        //
        assertEquals(0, exampleRange.getLength(), 0.0001,
        		"The length of (1, 5) should be 4");
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
    /* Check this first
    @Test
    void testContainsNull() {
    	Range exampleRange = new Range(null,null);
    	assertTrue(exampleRange.contains(null), 
    			"Range should not contain null value.");
    }
    */
    
    @Test
    //This test is just an example, 2 is not constant
    void testShift() {
    	Range exampleRange = new Range(-1,1);
    	Range testRange = Range.shift(exampleRange, 2.0, true);
    	assertEquals(3,testRange.getUpperBound(),0.001,
    			"Range shift should not be more than 2!");
    	Range testRange2 = Range.shift(exampleRange,2.0,true);
    	assertEquals(1,testRange2.getLowerBound(),0.001,
    			"Range shift should not be more than 2!");
    }
    
    
    @Test
    //This test is just an example, 2 is not constant
    void testConstrain() {
    	Range exampleRange = new Range(-1,1);
    	double test = exampleRange.constrain(5.0);
    	assertTrue(test <= 1,
    			"Range should not be over than the actual upper Range");
    	double test2 = exampleRange.constrain(-5);
    	assertTrue(test2 >= -1,
    			"Range should not be over than the actual lower Range");
    }
    
    @Test
    void testEqualsSameValues() {
    	Range other = new Range(-1, 1);
    	assertEquals(true, exampleRange.equals(other));
    }
    
    @Test
    void testEqualsDifferentLowerBound() {
    	Range other = new Range(1, 1);
    	assertEquals(false, exampleRange.equals(other));
    }
    
    @Test
    void testEqualsDifferentUpperBound() {
    	Range other = new Range(-1, 2);
    	assertEquals(false, exampleRange.equals(other));
    }
    
    @Test
    void testEqualsNullObject() {
    	assertEquals(false, exampleRange.equals(null));
    }
    
    @Test
    void testEqualsSameReference() {
    	assertEquals(false, exampleRange.equals(exampleRange));
    }
    
    @Test
    void testExpandNormalExpasion() {
    	Range base = new Range(2,6);
    	Range expanded = Range.expand(base, 0.25, 0.5);
    	assertEquals(1, expanded.getLowerBound(), 0.0000001);
    	assertEquals(8, expanded.getUpperBound(), 0.0000001);
    }
    
    @Test
    void testExpandZeroMargins() {
    	Range base = new Range(2,6);
    	Range expanded = Range.expand(base, 0.0, 0.0);
    	assertEquals(2, expanded.getLowerBound(), 0.0000001);
    	assertEquals(6, expanded.getUpperBound(), 0.0000001);
    }
    
    @Test
    void testExpandNegativeMargins() {
    	Range base = new Range(2,6);
    	Range expanded = Range.expand(base, -0.25, -0.25);
    	assertEquals(3, expanded.getLowerBound(), 0.0000001);
    	assertEquals(5, expanded.getUpperBound(), 0.0000001);
    }
    
    @Test
    void testExpandToInclude() {
    	
    }
    
    @Test
    void testToString() {
    	
    }

}
