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
public abstract class BinaryElement extends Expression{
    private Expression lhs;
    private Expression rhs;
    
    public BinaryElement(Expression lhs, Expression rhs){
        this.lhs = lhs;
        this.rhs = rhs;
    }
    
    public Expression getLhs() {
        return lhs;
    }
    
    public Expression getRhs() {
        return rhs;
    }
}
