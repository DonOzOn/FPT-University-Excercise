/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databinding;

import generated.Bookstore;
import generated.Bookstore.Book;
import java.io.File;
import java.util.HashSet;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Don OzOn
 */
public class DataBinding {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JAXBException {
        // TODO code application logic here
        try {
            JAXBContext context = JAXBContext.newInstance(Bookstore.class);
            Unmarshaller unmar = context.createUnmarshaller();
            Bookstore books = (Bookstore) unmar.unmarshal(new File("Bookstore.xml"));
            for (int i = 0; i < books.getBook().size(); i++) {
                System.out.println(books.getBook().get(i));
            }
            Marshaller mar = context.createMarshaller();
            Book newbook = new Book("Song", "ABC", 124, "3");
            books.getBook().add(newbook);
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mar.marshal(books, new File("Bookstore.xml"));
            for (int i = 0; i < books.getBook().size(); i++) {
                System.out.println(books.getBook().get(i));
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

}
