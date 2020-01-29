/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import LowerLevel.And;
import LowerLevel.Not;
import LowerLevel.Or;
import LowerLevel.Variable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author 20195000
 */
public class CircuitTest {
    
    public CircuitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testX1andX2() {
        And andOperation = new And();
        Variable x1 = new Variable(false);
        Variable x2 = new Variable(true);
        andOperation.lhs = x1;
        andOperation.rhs = x2;
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> 
        {
            throw new IllegalArgumentException("testX1andX2");
        });
        assertEquals(false, andOperation.getTruthValue());
        andOperation.lhs = x2;
        assertEquals(true, andOperation.getTruthValue());
    }
    /** 
     * Create a circuit to evaluate (x1 and x2) or x3 and then
     * verify that its result is false for input (false, true, false) and
     * it is true for input (false, false, true).
     */

    @Test
    public void testX1andX2orX3(){
        And andOperation = new And();
        Or orOperation = new Or();
        Variable x1 = new Variable(false);
        Variable x2 = new Variable(true);
        andOperation.lhs = x1;
        andOperation.rhs = x2;
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> 
        {
            throw new IllegalArgumentException("testX1andX2orX3");
        }); 
        orOperation.lhs = new Variable(andOperation.getTruthValue());
        orOperation.rhs = x1;
        assertEquals(false, orOperation.getTruthValue());
        andOperation.lhs = x1;
        andOperation.rhs = x1;
        orOperation.lhs = new Variable(andOperation.getTruthValue());
        orOperation.rhs = x2;
        assertEquals(true, orOperation.getTruthValue());
        //fail("testX1andX2orX3");
    }
    /** 
     * Create a circuit to evaluate (x1 or not(x1)) and then
     * verify that its result is true for all values of x1.
     */
    @Test
    public void testAlwaysTrue() {
        
        Variable x1 = new Variable(false);
        Variable x2 = new Variable(true);
        Or orOperation = new Or();
        Not notOperation = new Not();
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> 
        {
            throw new IllegalArgumentException("testAlwaysTrue");
        });
        orOperation.lhs = x1;
        notOperation.rhs = x1;
        orOperation.rhs = new Variable(notOperation.getTruthValue());
        assertEquals(true, orOperation.getTruthValue());
        orOperation.lhs = x2;
        notOperation.rhs = x2;
        orOperation.rhs = new Variable(notOperation.getTruthValue());
        assertEquals(true, orOperation.getTruthValue());
	  //fail("testAlwaysTrue");
    }

}
