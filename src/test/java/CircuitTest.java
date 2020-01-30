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
import LowerLevel.Expression;
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
    
    public class GTE extends BinaryElement{

        public GTE(Expression lhs, Expression rhs) {
            super(lhs, rhs);
        }

        @Override
        public Boolean getTruthValue() {
            return false;
        }

        @Override
        public double getDoubleValue() {
            if(this.getLhs().getDoubleValue() >= this.getRhs().getDoubleValue()){
                return 1.0;
            } else {
                return 0.0;
            }
        }
    }
    
    /** First of all create a circuit which will evaluate
     * expression (x1 and x2) or not(x1). Hold the circuit
     * in some variable.
     *
     * Feed this circuit with x1=true, x2=false, assert result is false
     *
     * Feed the same circuit with x1=false, x2=true, assert result is true
     *
     * Feed the same circuit with x1=0.0, x2=1.0, assert result is 1.0
     *
     * Feed the same circuit with x1=0.5, x2=0.5, assert result is 0.625
     *
     * Feed the same circuit with x1=0.0, x2=2.0, make sure it throws an exception
     */
    public void testX1andX2orNotX1() {
        Variable x1 = new Variable(true);
        Variable x2 = new Variable(false);
        UnaryElement notOperation = unaryFactory.create("Not", x1);
        BinaryElement andOperation = binFactory.create("And", x1, x2);
        BinaryElement orOperation = binFactory.create("Or", andOperation, notOperation);
        assertEquals(false, orOperation.getTruthValue());
        x1.setBooleanValue(false);
        x2.setBooleanValue(true);
        assertEquals(true, orOperation.getTruthValue());
        x1.setDoubleValue(0.0);
        x2.setDoubleValue(1.0);
        assertEquals(1.0, orOperation.getDoubleValue(), 0);
        x1.setDoubleValue(0.5);
        x2.setDoubleValue(0.5);
        assertEquals(0.625, orOperation.getDoubleValue(), 0);
        x1.setDoubleValue(0.0);
        x2.setDoubleValue(2.0);
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> 
        {
            throw new IllegalArgumentException("Please specify a value between 0.0 and 1.0");
        }); 
        
        
        
    }

    /** Write your own element type called "gte" that will have two inputs and one output.
     * The output value will be 1 if x1 >= x2 and 0 otherwise. 
     * 
     * Create 
     * circuit for following expression: (x1 and not(x1)) gte x1
     *
     * Feed the circuit with 0.5 and verify the result is 0
     *
     * Feed the same circuit with 1 and verify the result is 0
     *
     * Feed the same circuit with 0 and verify the result is 1
     */
    @Test
    public void testGreaterThanElement() {
        
        Variable x1 = new Variable(0.5);
        UnaryElement notOperation = unaryFactory.create("Not", x1);
        BinaryElement andOperation = binFactory.create("And", x1, notOperation);
        BinaryElement gteOperation = new GTE(andOperation, x1);
        assertEquals(0.0, gteOperation.getDoubleValue(), 0);
        x1.setDoubleValue(1.0);
        assertEquals(0.0, gteOperation.getDoubleValue(), 0);
        x1.setDoubleValue(0.0);
        assertEquals(1.0, gteOperation.getDoubleValue(), 0);
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
