/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LowerLevel;

/**
 *  Or operator class
 * @author s148192
 */
public class Or extends BinaryElement{
    
    public Or (Expression lhs, Expression rhs) {
        super(lhs, rhs);
    }
    
    
    @Override
    public Boolean getTruthValue(){
        return (this.getLhs().getTruthValue() || this.getRhs().getTruthValue());
    }
    
    @Override
    public double getDoubleValue(){
        return (1 - ((1 -this.getLhs().getDoubleValue())*(1- this.getRhs().getDoubleValue())));
    }
}
