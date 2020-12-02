/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testlist;

/**
 *
 * @author Don OzOn
 */
public class Node {
    person infor;
    Node next;
    Node(){
        
    }
    Node(person x,Node p){
        infor=x;
        next=p;
    }
    Node(person x){
        this(x,null);
    }
}
