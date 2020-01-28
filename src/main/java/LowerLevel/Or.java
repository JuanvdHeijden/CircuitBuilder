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
public class Or extends BinaryElement{
    @Override
    public Boolean getTruthValue(){
        return (lhs.getTruthValue() || rhs.getTruthValue());
    }
}
