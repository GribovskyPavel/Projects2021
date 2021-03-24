package com.company3;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * The main class in the program
 * @author pavelgribovsky
 */
public class Main {
    /**
     * The function returns the value of the int type (entering via console)
     * @param scan Scanner
     * @return int
     * @throws InputMismatchException If you dont enter the value of the type int
     */
    public static int isInt(Scanner scan){
        int n;
        if(scan.hasNextInt()) {
            n = scan.nextInt();
            return n;
        }
        else{
            throw new InputMismatchException("You are mistaken! You should entered the int number");
        }
    }
    /**
     * The function returns the value of the double type (entering via console)
     * @param scan Scanner
     * @return double
     * @throws InputMismatchException If you dont enter the value of the type double
     */
    public static double isDouble(Scanner scan){
        double n;
        if(scan.hasNextDouble()) {
            n = scan.nextDouble();
            return n;
        }
        else{
            throw new InputMismatchException("You are mistaken! You should entered the double number");
        }
    }
    /**
     * The main function in the program
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Laboratory work 3. Classes");
            System.out.print("Choose the Task:\nPart A - 1, Part B - 2, Part C - 3, Exit - something other\nEnter here: ");
            String flag = sc.nextLine();
            switch (flag) {
                case "1":
                    System.out.println("--- Part A ---");
                {
                    System.out.print("Choose the Task:\nFirst SubTask - 1, Second SubTask - 2, Third SubTask - 3, Exit - something other\nEnter here: ");
                    String flag1 = sc.nextLine();
                    switch (flag1) {
                        case "1": {
                                System.out.println("--- First SubTask ---");
                                System.out.print("Enter the number of objects of the class Book: ");
                                int n;
                                n = isInt(sc);
                                String name;
                                String authors;
                                Book[] Arr = new Book[n];
                                for (int i = 0; i < n; i++) {
                                    Arr[i] = new Book();
                                    System.out.print("Enter name: ");
                                    name = sc.next();
                                    Arr[i].setName(name);
                                    System.out.print("Enter authors: ");
                                    authors = sc.next();
                                    Arr[i].setAuthors(authors);
                                    System.out.print("\n");
                                }
                                System.out.print("Enter the author's name: ");
                                String Author = sc.next();
                                for (int i = 0; i < n; i++) {
                                    if (Author.equals(Arr[i].getAuthors())) {
                                        System.out.println("\nAuthors: " + Arr[i].getAuthors() + "\nName: " + Arr[i].getName());
                                    }
                                }
                            }
                        break;
                        case "2": {
                            System.out.println("--- Second SubTask ---");
                            {
                                System.out.print("Enter the number of objects of the class Book: ");
                                int n;
                                n = isInt(sc);
                                String name;
                                String pubHouse;
                                Book[] Arr = new Book[n];
                                for (int i = 0; i < n; i++) {
                                    Arr[i] = new Book();
                                    System.out.print("Enter name: ");
                                    name = sc.next();
                                    Arr[i].setName(name);
                                    System.out.print("Enter pubHouse: ");
                                    pubHouse = sc.next();
                                    Arr[i].setPubHouse(pubHouse);
                                    System.out.print("\n");
                                }
                                System.out.print("Enter the name of the house of publishing: ");
                                String PubHouse = sc.next();
                                for (int i = 0; i < n; i++) {
                                    if (PubHouse.equals(Arr[i].getPubHouse())) {
                                        System.out.println("\nPubHouses: " + Arr[i].getPubHouse() + "\nName: " + Arr[i].getName());
                                    }
                                }
                            }
                        }
                        break;
                        case "3": {
                                System.out.println("--- Third SubTask ---");
                                System.out.print("Enter the number of objects of the class Book: ");
                                int n;
                                n = isInt(sc);
                                String name;
                                int year;
                                Book[] Arr = new Book[n];
                                for (int i = 0; i < n; i++) {
                                    Arr[i] = new Book();
                                    System.out.print("Enter name: ");
                                    name = sc.next();
                                    Arr[i].setName(name);
                                    System.out.print("Enter year: ");
                                    year = sc.nextInt();
                                    Arr[i].setYear(year);
                                    System.out.print("\n");
                                }
                                System.out.print("Enter the year: ");
                                int Year;
                                Year = isInt(sc);
                                for (int i = 0; i < n; i++) {
                                    if (Year < Arr[i].getYear()) {
                                        System.out.println("\nAfter the year " + Year + ": " + Arr[i].getYear() + "\nName: " + Arr[i].getName());
                                    }
                                }
                            }
                        break;
                        default:
                            System.out.println("You entered something other!");
                    }
                }
                break;
                case "2":
                    System.out.println("--- Part B ---");
                {
                    System.out.print("Enter the number of objects of the class Interval: ");
                    int number;
                    number = isInt(sc);
                    double left;
                    double right;
                    Interval[] Inter = new Interval[number];
                    for (int i = 0; i < number; i++) {
                        Inter[i] = new Interval();
                        System.out.print("Inter[" + i + "]:\n");
                        System.out.print("Enter the left point: ");
                        left = sc.nextDouble();
                        Inter[i].setLeft(left);
                        System.out.print("Enter the right point: ");
                        right = sc.nextDouble();
                        Inter[i].setRight(right);
                    }
                    double min = Inter[0].getLeft();
                    double max = Inter[0].getRight();
                    for (int i = 1; i < number; i++) {
                        if (Inter[i].getLeft() < min) {
                            min = Inter[i].getLeft();
                        }
                        if (Inter[i].getRight() > max) {
                            max = Inter[i].getRight();
                        }
                    }
                    System.out.println("The max distance between the furthest points among the all Intervals: " + Math.abs(max - min));
                    System.out.println("Testing methods");
                    Interval int1 = new Interval(6, 9, false, false);
                    Interval int2 = new Interval(-20, 5, true, true);
                    Interval result1 = int1.intersect(int2);
                    System.out.println(result1.ToString() + "\n");
                    Interval result2 = int1.union(int2);
                    System.out.println(result2.ToString() + "\n");
                    Interval result3 = int1.multiply(32);
                    System.out.println(result3.ToString() + "\n");
                    Interval result4 = int1.divide(3);
                    System.out.println(result4.ToString() + "\n");
                }
                break;
                case "3":
                    System.out.println("--- Part C ---");
                {
                    System.out.print("Enter the number of the objects of the class Complex: ");
                    int number;
                    number = isInt(sc);
                    double numRe;
                    double denRe;
                    double numIm;
                    double denIm;
                    Complex[] Cpx = new Complex[number];
                    for (int i = 0; i < number; i++) {
                        Cpx[i] = new Complex();
                        System.out.print("Cpx[" + i + "]:\n");
                        System.out.print("Initialize numerator of Re part: ");
                        numRe = isDouble(sc);
                        Cpx[i].Re.setNumerator(numRe);
                        System.out.print("Initialize denominator of Re part: ");
                        denRe = isDouble(sc);
                        Cpx[i].Re.setDenominator(denRe);
                        System.out.print("Initialize numerator of Im part: ");
                        numIm = isDouble(sc);
                        Cpx[i].Im.setNumerator(numIm);
                        System.out.print("Initialize denominator of Im part: ");
                        denIm = isDouble(sc);
                        Cpx[i].Im.setDenominator(denIm);
                        System.out.println(Cpx[i].ToString());
                    }
                    System.out.print("\n");
                    Complex obj = new Complex();
                    obj = obj.SuperAdd(Cpx);
                    System.out.println(obj.ToStringCount());
                    obj = obj.SuperMulty(Cpx);
                    System.out.println(obj.ToStringCount());
                }
                break;
                default:
                    System.out.println("You entered something other!");
            }
            sc.close();
        }
        catch (ArithmeticException ex){
            System.out.println("Arithmetic error!");
            sc.close();
        }
        catch (InputMismatchException ex1){
            System.out.println("InputMismatchException!");
            sc.close();
        }
        catch (Error ex2){
            System.out.println("Error!");
            sc.close();
        }
    }
}
