/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author instructor
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Node list = mLR(100000);
        
        printList(list);
        
    }
    
    public static void printList(Node start){
        if (start != null){
            System.out.println(start.data);
            printList(start.next);
        }
    }
    
    public static Node mLR(int n){
        if (n == 0){
            return null;
        }else{
            Node newNode = new Node(n-1);
            newNode.next = mLR(n - 1);
            return newNode;
        }
    }
    
    public static Node makeList(int n){
        Node start = new Node(0);
        Node cursor = start;
        for (int i=1; i<n; i++){
            Node newNode = new Node(i);
            cursor.next = newNode;
            cursor = cursor.next;
        }
        return start;
    }
    
}
