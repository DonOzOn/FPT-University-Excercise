/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sax;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author Don OzOn
 */
public class JAXParser {

    List<Book> books;
    boolean isName = false;
    boolean isAuthor = false;
    boolean isPrice = false;

    public JAXParser() {
        books = new ArrayList<>();
    }

    public void parseFile(String filepath) {
        try {
            XMLInputFactory inFact = XMLInputFactory.newFactory().newInstance();
            XMLEventReader evenRead = inFact.createXMLEventReader(new FileReader(filepath));
            Book book = new Book();
            while (evenRead.hasNext()) {
                XMLEvent event = evenRead.nextEvent();
                switch (event.getEventType()) {
                    case XMLEvent.START_DOCUMENT:
                        System.out.println("<?xml version =dasd");
                        break;
                    case XMLEvent.END_DOCUMENT:
                        System.out.println("End doccument");
                        break;
                    case XMLEvent.START_ELEMENT:
                        StartElement startEle = event.asStartElement();
                        String startElementName = startEle.getName().getLocalPart();
                        if (startElementName.equalsIgnoreCase("Book")) {
                            Iterator<Attribute> attribute = startEle.getAttributes();
                            String id = attribute.next().getValue();
                            book.setId(id);
                        } else if (startElementName.equalsIgnoreCase("Name")) {
                            isName = true;
                        } else if (startElementName.equalsIgnoreCase("Author")) {
                            isAuthor = true;
                        } else if (startElementName.equalsIgnoreCase("Price")) {
                            isPrice = true;
                        }
                        break;
                    case XMLEvent.END_ELEMENT:
                        EndElement endEle = event.asEndElement();
                        if (endEle.getName().getLocalPart().equalsIgnoreCase("Book")) {
                            books.add(book);
                            book = new Book();
                        }
                        break;
                    case XMLEvent.CHARACTERS:
                        Characters cha = event.asCharacters();
                        String data = cha.getData();
                        if (isName) {
                            book.setName(data);
                            isName = false;
                        }
                        if (isAuthor) {
                            book.setAuthor(data);
                            isAuthor = false;
                        }
                        if (isPrice) {
                            book.setPrice(data);
                            isPrice = false;
                        }
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeFile(List<Book> books, String filepath) {
        try {
            StringWriter stringWrite = new StringWriter();
            XMLOutputFactory outFact = XMLOutputFactory.newFactory().newInstance();
            XMLStreamWriter streanWrite = outFact.createXMLStreamWriter(new FileOutputStream(filepath));
            streanWrite.writeStartDocument();
            streanWrite.writeCharacters("\n");
            streanWrite.writeStartElement("Books");
            for (Book book : books) {
                streanWrite.writeCharacters("\n\t");
                streanWrite.writeStartElement("Book");
                streanWrite.writeAttribute("id", book.getId());
                //write
                streanWrite.writeCharacters("\n\t\t");
                streanWrite.writeStartElement("Name");
                streanWrite.writeCharacters(book.getName());
                streanWrite.writeEndElement();
                streanWrite.writeCharacters("\n\t\t");
                streanWrite.writeStartElement("Author");
                streanWrite.writeCharacters(book.getAuthor());
                streanWrite.writeEndElement();
                streanWrite.writeCharacters("\n\t\t");
                streanWrite.writeStartElement("Price");
                streanWrite.writeCharacters(book.getPrice());
                streanWrite.writeEndElement();
                streanWrite.writeCharacters("\n\t");
                streanWrite.writeEndElement();
            }
            streanWrite.writeCharacters("\n");
            streanWrite.writeEndElement();
            streanWrite.writeEndDocument();
            streanWrite.flush();
            streanWrite.close();
        } catch (Exception e) {
        }
    }
}
