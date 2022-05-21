public class RecursionExample {

    public static void main(String[] args) {
        int x = 3;

        //when this function is called the current program state
        // is pushed onto a "runtime stack"
        //printStuff(10);
        long result = factorial(14);
        // when it gets here, its going to push (save) the current code location
        // onto the runtime stack *answer question below* 0xf20034b1 (example memory location to return to)
        double y = Math.sqrt(44.2);
        // pull 0xf20034b1 off the runtime  stack and return to that code location. 
        
        //after calling math.sqrt, by jumping to that functions memory location, 
        //how does it know to come back to THIS memory location  and continue 
        // exccuting the program?
        System.out.println(result);
        //after the function is done, the old program state is popped
        //off the Runtime stack and we go back to what we were doing

        x = 0;
        
    }

    //factorial 
    // 0! =             1
    // 1! =             1
    // 2! =         2 * 1
    // 3! =     3 * 2 * 1
    // 4! = 4 * 3 * 2 * 1
    // 4! = 4 * 3!
    // n! = 1 * 2 * 3 * .... *n-1 *n
    // n! = n * (n-1)!

    public static long factorial(long n){
        if(n==0){
            return(1); // 0! => 1
        }else{
            return(n * factorial(n-1));
        }

    }

    public static void printStuff(int n){
        System.out.println("stuff");
        // push state onto the stack
        // remote and add into stopping point printStuff();

        //2 add a stopping point 

        //in order for recurison to work need two things:
            //1. a reducing (or sometimes increasing) data set (or point)
            //2. a base case that will be reached by the reduction or change.

        
        //base case n = 0 
        if (n>0){
            //data set or point reduces (or changes) in every recurive call
            printStuff(n-1);
        }

        //1.   a function that recalls itself is recursion, eventually it runs out of 
        //stack space which is why we see it print the stuff until it errors out
        //gets stack overflow error. 

    }


}