package by.bsu.lab10;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("----- Laboratory works № 10 -----");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("""
                    In order to choose
                    The Part A enter - 1,
                    The Part B enter - 2;
                    Enter here:\s""");
            String flag = scanner.next();
            switch (flag) {
                case "1" -> {
                    int numberElemFirst;
                    int numberElemSecond;
                    System.out.print("Enter the number of elements in the first stack\nEnter here: ");
                    numberElemFirst = scanner.nextInt();
                    System.out.print("Enter the number of elements in the second stack\nEnter here: ");
                    numberElemSecond = scanner.nextInt();
                    MyClass []Array1 = new MyClass[numberElemFirst];
                    MyClass []Array2 = new MyClass[numberElemSecond];
                    Stack<MyClass> MyStackFirst = new Stack<>();
                    Stack<MyClass> MyStackSecond = new Stack<>();
                    System.out.println("--- Objects for first stack ---");
                    for (int i = 0; i < numberElemFirst; i++) {
                        System.out.print("Initialize the object["+i+"]: ");
                        String buffer = scanner.next();
                        Array1[i] = new MyClass(buffer);
                        MyStackFirst.push(Array1[i]);
                    }
                    System.out.println("--- Objects for second stack ---");
                    for (int i = 0; i < numberElemSecond; i++) {
                        System.out.print("Initialize the object["+i+"]: ");
                        String buffer = scanner.next();
                        Array2[i] = new MyClass(buffer);
                        MyStackSecond.push(Array2[i]);
                    }
                    System.out.println(MyStackFirst);
                    System.out.println(MyStackSecond);
                    Stack<MyClass> BufStackFirst = new Stack<>();
                    Stack<MyClass> BufStackSecond = new Stack<>();
                    for (MyClass ignored : Array1) {
                        BufStackFirst.push(MyStackFirst.pop());
                    }
                    for (MyClass ignored : Array2) {
                        BufStackSecond.push(MyStackSecond.pop());
                    }
                    for (MyClass ignored : Array2) {
                        MyStackFirst.push(BufStackSecond.pop());
                    }
                    for (MyClass ignored : Array1) {
                        MyStackSecond.push(BufStackFirst.pop());
                    }
                    System.out.println("Change between stacks...\nResult");
                    System.out.println(MyStackFirst);
                    System.out.println(MyStackSecond);

                }
                case "2" -> {
                    NumberCollection Numbers = new NumberCollection();
                    NumberCollection.MyNumber number1 = new NumberCollection.MyNumber(109);
                    NumberCollection.MyNumber number2 = new NumberCollection.MyNumber(222);
                    NumberCollection.MyNumber number3 = new NumberCollection.MyNumber(334);
                    NumberCollection.MyNumber number4 = new NumberCollection.MyNumber(666);
                    NumberCollection.MyNumber number5 = new NumberCollection.MyNumber(999);
                    Numbers.add(number1);
                    Numbers.add(number2);
                    Numbers.add(number3);
                    Numbers.add(number4);
                    Numbers.add(number5);
                    System.out.println(Numbers);
                    Numbers.remove(3);
                    Numbers.remove(1);
                    System.out.println(Numbers);
                    NumberCollection.MyNumber obj = Numbers.findClosestValue(number2);
                    System.out.println(obj);

                }
                default -> System.out.println("You entered something wrong!");
            }
        }
        catch (InputMismatchException | ArithmeticException ex){
            System.out.println("Exception: "+ex);
        }
    }
}
