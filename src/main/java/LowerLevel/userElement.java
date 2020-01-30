/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LowerLevel;

/**
 *
 * @author s148192
 */
public class userElement extends BinaryElement{

    userElement(Expression lhs, Expression rhs){
        super(lhs, rhs);
    }
    
    @Override
    public Boolean getTruthValue() {
        return true;
    }

    @Override
    public double getDoubleValue() {
        return 1.0;
    }
    
}
