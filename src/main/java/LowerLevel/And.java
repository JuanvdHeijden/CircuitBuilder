/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LowerLevel;

/**
 * And operator class
 * @author s148192
 */
public class And extends BinaryElement{
    
    public And (Expression lhs, Expression rhs) {
        super(lhs, rhs);
    }
    
    @Override
    public Boolean getTruthValue(){
        return (this.getLhs().getTruthValue() && this.getRhs().getTruthValue());
    }
}
