/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author instructor
 */
public class OperatorNode extends ENode{
    
    private String operator;
    private ENode left;
    private ENode right;
    
    // write two constructors.  one that takes no parameters
    public OperatorNode() {
        operator = null;
        left = null;
        right = null;
    }
    // one that takes a String
    public OperatorNode(String operator) {
        this.operator = operator;
        left = null;
        right = null;
    }

    // write getters and setters
    /**
     * @return the operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * @param operator the operator to set
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * @return the left
     */
    public ENode getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(ENode left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public ENode getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(ENode right) {
        this.right = right;
    }
    
    
    public double value(){
          
        double result = 0.0;
        
        left = this.getLeft();
        
        right = this.getRight();
        
        // perform the correct operation
        if(Calculator.isOperator(left.toString())) {
            left = this.getLeft();
            value();
        }
        
        if(Calculator.isOperator(right.toString())) {
            right = this.getRight();
            value();
        }
        else {
            switch(operator) {
                case "+": 
                    result = left.value() + right.value(); 
                    break;
                case "-": 
                    result = left.value() - right.value();
                    break;
                case "*": 
                    result = left.value() * right.value();
                    break;
                case "/": 
                    result = left.value() / right.value();
                    break;
                case "^": 
                    result = Math.pow(left.value(), right.value());
                    break;
                default:
                    return(0);
            }
        }
        return(result);
    }
}