package com.company3;
import java.util.UUID;
/**
 * The class Book is used to classify and collect information about the books
 * @author pavelgribovsky
 */
public class Book {
    /**
     * @params name, authors, pubHouse, type, id, year, pages, price
     * @return String, String, String, String, String, int, int, double
     */
    private String name;
    private String authors;
    private String pubHouse;
    private String type;
    private String id;
    private int year;
    private int pages;
    private double price;

    public Book() {
        this.id = UUID.randomUUID().toString();
        this.name = "\0";
        this.authors = "\0";
        this.pubHouse = "\0";
        this.type = "\0";
        this.year = 0;
        this.pages = 0;
        this.price = 0;
    }
    public Book( String name, String authors, String pubHouse, String type, int year, int pages, double price) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.authors = authors;
        this.pubHouse = pubHouse;
        this.type = type;
        this.year = year;
        this.pages = pages;
        this.price = price;
    }

    public void setAuthors(String authors){
        this.authors = authors;
    }
    public String getAuthors(){
        return this.authors;
    }

    public void setName(String name){
       this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setPubHouse(String pubHouse){
        this.pubHouse = pubHouse;
    }
    public String getPubHouse(){
        return this.pubHouse;
    }

    public void setYear(int year){
        this.year = year;
    }
    public int getYear(){
        return this.year;
    }

    public Book[] objectArr(int number){
        Book [] Arr = new Book[number];
        for (int i = 0; i < number; i++) {
            Arr[i] = new Book();
        }
        return Arr;
    }

    public String ToString(){
      return "Class: Book\nName: "+this.name+"\nAuthors: "+this.authors+"\nPubHouse: "+this.pubHouse+"\nType: "+this.type+"\nId: "+this.id+"\nYear: "+this.year+"\nPages: "+this.pages+"\nPrice: "+this.price;
    }
}
