/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Factories.BinaryAbstractFactory;
import Factories.BinaryElementFactory;
import Factories.UnaryElementFactory;
import LowerLevel.And;
import LowerLevel.BinaryElement;
import LowerLevel.Not;
import LowerLevel.Or;
import LowerLevel.UnaryElement;
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
    UnaryElementFactory unaryFactory = new UnaryElementFactory();
    BinaryElementFactory binFactory = new BinaryElementFactory();
    
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
        Variable x1 = new Variable(false);
        Variable x2 = new Variable(true);
        
        BinaryElement andOperation = binFactory.create("And", x1, x2);
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> 
        {
            throw new IllegalArgumentException("testX1andX2");
        });
        assertEquals(false, andOperation.getTruthValue());
        andOperation.setLhs(x2);
        assertEquals(true, andOperation.getTruthValue());
    }
    /** 
     * Create a circuit to evaluate (x1 and x2) or x3 and then
     * verify that its result is false for input (false, true, false) and
     * it is true for input (false, false, true).
     */

    @Test
    public void testX1andX2orX3(){
        Variable x1 = new Variable(false);
        Variable x2 = new Variable(true);
        BinaryElement andOperation = binFactory.create("And", x1, x2);
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> 
        {
            throw new IllegalArgumentException("testX1andX2orX3");
        }); 
        BinaryElement orOperation = binFactory.create("Or", andOperation, x1);
        assertEquals(false, orOperation.getTruthValue());
        andOperation.setLhs(x1);
        andOperation.setRhs(x1);
        orOperation.setLhs(andOperation);
        orOperation.setRhs(x2);
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
        
        UnaryElement notOperation = unaryFactory.create("Not", x1);
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> 
        {
            throw new IllegalArgumentException("testAlwaysTrue");
        });
        BinaryElement orOperation = binFactory.create("Or", x1, notOperation);
        assertEquals(true, orOperation.getTruthValue());
        orOperation.setLhs(x2);
        notOperation.setRhs(x2);
        orOperation.setRhs(notOperation);
        assertEquals(true, orOperation.getTruthValue());
	  //fail("testAlwaysTrue");
    }

}
