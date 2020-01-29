/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factories;

import LowerLevel.*;

/**
 *
 * @author s148192
 */
public class BinaryElementFactory implements BinaryAbstractFactory<BinaryElement>{

    @Override
    public BinaryElement create(String elementType, Expression lhs, Expression rhs) {
        if(elementType.equalsIgnoreCase("And")){
            return new And(lhs, rhs);
        } else if (elementType.equalsIgnoreCase("Or")){
            return new Or(lhs, rhs);
        }
        return null;
    }

    
}
