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
public class person {
    String name;
    int age;
    person(){}
    person(String xname,int xage){
        name=xname;
        age=xage;
    }
    public String toString(){
        String s="(" + name +"-----"+ age+")";
        return(s);
    }
}
