/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jdoolin
 */
public class NumberNode extends ENode{
    
    protected double value;
    
    public NumberNode(double v){
        value = v;
    }
    
    @Override
    public double value(){
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(double value) {
        this.value = value;
    }
}
