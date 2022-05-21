//Kimberly Mackey
//cit272
//04/07/2021 very late but better then never still trying to catch up

/*Using the language of your choice (Java or Python, ask if you want to use something else), write a recursive function that does the following:

-Take an integer as an argument

-Will add all number from 1 to n (the argument given to the function)

-Return an integer

In a main function, test this recursive function and print the result.

-Get an integer from the user

-Pass that integer to your recursive addition function

-Print the result 8 

Name the program recursion.py or Recursion.java.  As always, properly comment your code.  */


import java.util.Scanner;

public class Recursion {
    public static void main(String[] args) {
        int num;
        

        //Get number from usuer
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        num = scan.nextInt();

        //pass the int to your recursive addition function
        int result = doMath(num);

        //print result
        System.out.println(result);
        scan.close();

        
    }

    //recursive function
    public static int doMath(int n){
        

        //2 add a stopping point 
        
        //base case n = 0 
        if (n>0){
            //data set or point reduces (or changes) in every recurive call
            //add number from 1 to n
           return(n + doMath(n-1));
        }
        //Return an integer
        return n;



    }
    
}
