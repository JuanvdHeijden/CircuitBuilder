/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factories;

import LowerLevel.Expression;

/**
 *  Abstract factory for all binary elements
 * @author s148192
 */
public interface BinaryAbstractFactory<T> {
    T create(String elementType, Expression lhs, Expression rhs);
}