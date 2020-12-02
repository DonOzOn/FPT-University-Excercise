/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Object.Book;
import java.awt.List;
import java.awt.TextArea;
import java.awt.TextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import javax.sql.rowset.spi.XmlReader;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import jdk.internal.org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Don OzOn
 */
public class Main {

    static Frame fa = new Frame();


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws org.xml.sax.SAXException {
        // TODO code application logic here\
        fa.setVisible(true);
        String filePath = "C:\\Users\\Don OzOn\\OneDrive\\Documents\\NetBeansProjects\\Main\\src\\XML\\Book.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("Book");
            //now XML is loaded as Document in memory, lets convert it to Object List
            ArrayList<Book> empList = new ArrayList<Book>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                empList.add(getEmployee(nodeList.item(i)));
            }
            //lets print Employee list information
            for (Book emp : empList) {
                System.out.println(emp.toString());
            }
        } catch (ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        }
        String value = fa.getCBCatergory().getSelectedItem().toString();
        switch(value){
            case "ID":
                
                
            case "Catergory":
                
            case "Name":
        }

    }
    

    private static Book getEmployee(Node node) {
        //XMLReaderDOM domReader = new XMLReaderDOM();
        Book emp = new Book();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            emp.setName(getTagValue("Name", element));
            emp.setAuthor(getTagValue("Author", element));
            emp.setISBN(getTagValue("ISBN", element));
            emp.setPrice(getTagValue("Price", element));
            emp.setSold(getTagValue("Sold", element));
            emp.setStock(getTagValue("Stock", element));

        }

        return emp;
    }

    private static String getTagValue(String tag,Element element) {
        NodeList nodeList;
        nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

}
