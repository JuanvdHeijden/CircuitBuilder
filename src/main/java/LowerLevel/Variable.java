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
public class Variable extends Expression{
    private Boolean value;
    
    public Variable(Boolean value){
        this.value = value;
    }
    
    public Boolean getTruthValue(){
        return value;
    }
}
