/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

/**
 *
 * @author Don OzOn
 */
public class Book {

    private String Name;
    private String Author;
    private String ISBN;
    private String Price;
    private String Sold;
    private String Stock;

    public Book(String Name, String Author, String ISBN, String Price, String Sold, String Stock) {
        this.Name = Name;
        this.Author = Author;
        this.ISBN = ISBN;
        this.Price = Price;
        this.Sold = Sold;
        this.Stock = Stock;
    }
    public Book()

    {

    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPrice() {
        return Price;
    }

    @Override
    public String toString() {
        return "Book{" + "Name=" + Name + ", Author=" + Author + ", ISBN=" + ISBN + ", Price=" + Price + ", Sold=" + Sold + ", Stock=" + Stock + '}';
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getSold() {
        return Sold;
    }

    public void setSold(String Sold) {
        this.Sold = Sold;
    }

    public String getStock() {
        return Stock;
    }

    public void setStock(String Stock) {
        this.Stock = Stock;
    }

}
