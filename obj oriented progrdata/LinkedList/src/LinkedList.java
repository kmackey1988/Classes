/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author instructor
 */
public class LinkedList {
    private Node head;
    
    public LinkedList(){
        head = null;
    }
    
    public void append(String data){
        Node tmp = new Node(data);
        Node pointer = head;
        if (pointer == null){
            pointer = tmp;// exactly the same as
            //head = tmp;
        }else{
            while (pointer.getNext() != null){
                pointer = pointer.getNext();
            }
            // pointer now points to the last
            // item in the list (aka, the thing
            // that has a next that points to null
            pointer.setNext(tmp);
        }
    }
    
    // remove
    
    // replace
    
    // search
    
    // length
    
}
