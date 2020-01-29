/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factories;

import LowerLevel.Expression;
import LowerLevel.Not;
import LowerLevel.UnaryElement;

/**
 *  Concrete factory for all unary elements
 * @author s148192
 */
public class UnaryElementFactory implements UnaryAbstractFactory<UnaryElement>{

    @Override
    public UnaryElement create(String elementType, Expression rhs) {
        if(elementType.equalsIgnoreCase("Not")){
            return new Not(rhs);
        }
        return null;
    }    
}
