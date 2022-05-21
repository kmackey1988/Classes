//kimberly mackey 
//cit272
//04/11/2021 
 

import java.util.Scanner;
public class Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // create scanner
        String input = ""; // for input

        System.out.println("Welcome to my calculator");
        System.out.println("Type <exit> to close program.");



        
        
           
        System.out.println("Type <quit> to exit the program...");  

        while(!input.equals("exit")) {
            System.out.println("Enter an expression"); // prompt user
            input = scanner.nextLine(); // read input
            String[] expression = input.split("\\s+"); // split input

            if(input.equals("quit")){
                System.out.println("Come again soon, Goodbye");
                System.exit(0);

            

                else {
                    if(!input.equals("exit")) {
                        // print invalid
                        System.out.println( isValidExpression(expression))+ "expression is invalid");
                    }
            }
         }
         if(isValidExpression(expression)) {
            // declare root node
            ENode root = new OperatorNode();
        
            // build the expression tree / assign to root
            root = buildExpressionTree(expression);
            
            // perform the calculation / get value of root node
            double result = root.value();
            
            // show the output
            System.out.println(result);
        }
    }
    
    
    public static boolean isAnOperator(char n) {
        switch (n) {
            case '*':
            case '/':
            case '+':
            case '-':
            case '^':
                return true;
            default:
                return false;
        }
    }    

    public static boolean isNumber(String string) {
        try {
            double d = Double.parseDouble(string);
        } 
        catch (NumberFormatException nfe) {
            return false;
        }
        return(true);
    }

    public static boolean isOperator(String string) {
        if(string.equals("^") ||
           string.equals("*") || 
           string.equals("/") ||
           string.equals("+") || 
           string.equals("-")  )  
        {
            return(true);
        }
        return(false);
    }

    public static boolean isValidExpression(String[] expression) {
        
        for(int i=0; i<expression.length; i++) {     
            
            if(i%2 == 0) {
                
                if(!isNumber(expression[i])) {
                    return(false);
                }
            }
            
            else {
                
                if(!isOperator(expression[i])) {
                    return(false);
                }
            }
        }
       
        return(true);


        public static ENode buildExpressionTree(String[] expression){
        
            Stack<ENode> operandStack = new Stack();
            Stack<String> operatorStack = new Stack();
            
            for(int i=0; i<expression.length; i++) {
                // if operand (even numbered index)
                if(i%2 == 0) {
                    NumberNode operand = new NumberNode(Double.parseDouble(expression[i]));
                    operandStack.push(operand);
                }
                // if operator (odd numbered index)
                else {
                    String operator = expression[i];
                    
                    if(operatorStack.isEmpty()) {
                        operatorStack.push(operator);
                    } else {
                        
                        String top = operatorStack.firstElement();
                        // if top has higher priority or equal to
                        if(priority(top) >= priority(operator)) {
                            // pop top operator off the stack
                            String temp = operatorStack.pop();
    
                            // create OperatorNode with top
                            OperatorNode operatorNode = new OperatorNode(temp);
    
                            // pop top two operands right (first) then left
    
                            // set right
                            if(!operandStack.empty()) {   
                                ENode right = operandStack.pop();
                                operatorNode.setRight(right);
                            }
    
                            // set left
                            if(!operandStack.empty()) {
                                ENode left = operandStack.pop();
                                operatorNode.setLeft(left);
                            }
    
                           
                            operandStack.push(operatorNode);
                        }
                        int x = operatorStack.size();
                        if(x > 0) {
                            top = operatorStack.lastElement();
                            if(priority(top) >= priority(operator)) {
                               
                                String temp = operatorStack.pop();
    
                                
                                OperatorNode operatorNode = new OperatorNode(temp);
    
                                
                                if(!operandStack.empty()) {   
                                    ENode right = operandStack.pop();
                                    operatorNode.setRight(right);
                                }
    
                                
                                if(!operandStack.empty()) {
                                    ENode left = operandStack.pop();
                                    operatorNode.setLeft(left);
                                }
    
                                
                                operandStack.push(operatorNode);
                            }
                        }
    
                       
                        operatorStack.push(operator);
                    }
                }
            }
            
           
            while(!operatorStack.empty()) {
                String temp = operatorStack.pop();
                OperatorNode operatorNode = new OperatorNode(temp);
    
                
                if(!operandStack.empty()) {   
                    ENode right = operandStack.pop();
                    operatorNode.setRight(right);
                }
    
                
                if(!operandStack.empty()) {
                    ENode left = operandStack.pop();
                    operatorNode.setLeft(left);
                }
                operandStack.push(operatorNode);
            }
            ENode root = operandStack.pop();
            return(root);
        }
    }


  
}