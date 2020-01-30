/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LowerLevel;

/**
 *  Variable class, contains a boolean "value"
 * @author s148192
 */
public class Variable extends Expression{
    private Boolean value;
    private double doubleValue;
    
    public Variable(Boolean value){
        this.value = value;
        if(value){
            doubleValue = 1.0;
        } else {
            doubleValue = 0.0;
        }
    }
    
    public Variable(double value){
        if(value < 0.0 || value > 1.0){
            throw new IllegalArgumentException("Please specify a value between 0.0 and 1.0");
        }
        this.doubleValue = value;
        if(value >= 0.5){
            this.value = true;
        } else{
            this.value = false;
        }
    }
    
    public Boolean getTruthValue(){
        return value;
    }
    
    public double getDoubleValue(){
        return doubleValue;
    }
    
    public void setBooleanValue(Boolean boolValue){
        this.value = boolValue;
        if(value){
            doubleValue = 1.0;
        } else {
            doubleValue = 0.0;
        }
    }
    
    public void setDoubleValue(double doubleValue){
        this.doubleValue = doubleValue;
        if(doubleValue >= 0.5){
            this.value = true;
        } else{
            this.value = false;
        }
    }
}
