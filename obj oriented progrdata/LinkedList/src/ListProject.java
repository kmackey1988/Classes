
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author instructor
 */
public class ListProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        Node names = null; // >>> names = []
        
        names = new Node("Luke"); // >>> names.append("Luke")
        
        Node tempNode = new Node("Obi Wan");
        names.setNext(tempNode); // >>> names.append("Obi-Wan")
        
        Node variableName = new Node("Han Solo");
        tempNode.setNext(variableName);
        
        Node anotherNode = new Node("Chewbacca");
        variableName.setNext(anotherNode);
        */
        LinkedList names = new LinkedList();// empty list
        
        names.append("Luke");
        names.append("Obi Wan");
        names.append("Han Solo");
        names.append("Chewbacca");
        
        names.remove("Han Solo");
        names.search("Darth Vader");
        names.replace(1, "Yoda");
        names.replace("Obi Wan", "Yoda");
        
        int numNames = names.length();
        
    }
    
}
