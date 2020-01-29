/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TopLevel;
import LowerLevel.*;

/**
 *
 * @author s148192
 */
public class CircuitBuilder {
    public Boolean evaluate(){
        return true;
    }
    
    public static void main (String[] args){
        Variable x1= new Variable(true);
        Variable x2= new Variable(false);
        Variable x3= new Variable(true);
        Variable x4= new Variable(false);
        
        Not not1 = new Not(x3);
        Or or1 = new Or(x2, not1);
        And and1 = new And(x1, or1);
        Or or2 = new Or(and1, x4);
        
        System.out.println(or2.getTruthValue());
    }
}
