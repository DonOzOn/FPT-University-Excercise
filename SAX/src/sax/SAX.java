/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sax;

/**
 *
 * @author Don OzOn
 */
public class SAX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        JAXParser ja = new JAXParser();
        ja.parseFile("Bookstore.xml");
        for (int i = 0; i < ja.books.size(); i++) {
            System.out.println(ja.books.get(i));
        }
        ja.books.add(new Book("4","sjhdk","sdkashd","987"));
        ja.writeFile(ja.books, "newBook.xml");
    }
    
}
