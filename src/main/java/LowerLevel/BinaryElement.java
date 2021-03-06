/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LowerLevel;

/**
 *  Abstract binary operator class
 * @author s148192
 */
public abstract class BinaryElement extends Expression{
    private Expression lhs; // Left hand side of the expression
    private Expression rhs; // Right hand side of the expression
    
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
    
    public void setLhs(Expression lhs) {
        this.lhs = lhs;
    }
    
    public void setRhs(Expression rhs) {
        this.rhs = rhs;
    }
}
