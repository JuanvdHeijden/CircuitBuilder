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
public abstract class UnaryElement extends Expression{
    private Expression rhs;
    
    public UnaryElement(Expression rhs){
        this.rhs = rhs;
    }
    
    public Expression getRhs() {
        return rhs;
    }
    
    public void setRhs(Expression rhs) {
        this.rhs = rhs;
    }
}
