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
        Variable a1= new Variable(true);
        Variable a2= new Variable(false);
        Variable a3= new Variable(false);
        
        And and = new And(a1, a2);
        
        Or or = new Or(and, a3);
        
        System.out.println(or.getTruthValue());
    }
}
