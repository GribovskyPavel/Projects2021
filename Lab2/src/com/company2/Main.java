package com.company2;

import java.util.Scanner;
import java.util.Date;

/**
 * The main class of the program
 * */
public class Main {
    /**
     * Checks a number for evenness of its digits
     * @param number int parameter
     * @return Boolean function
     * */
    public static boolean AllDigitsEven(int number){
        int i=1;
        int n=String.valueOf(Math.abs(number)).length();
        while ((number%Math.pow(10,i))%2 == 0){
            i++;
            number/=10;
            if(i>n){
                return true;
            }
        }
        return false;
    }
    /**
     * Checks a number for an equal number of even and odd digits
     * @param number int parameter
     * @return Boolean function
     * */
    public static boolean EvenEqualOdd(int number){
        int countEvenDig=0;
        int countOddDig=0;
        int n=String.valueOf(Math.abs(number)).length();
        for (int i = 0; i < n ; i++) {
            if((Math.abs(number)%Math.pow(10,i+1))%2 == 0){
                countEvenDig++;
                number/=10;
            }
            else{
                countOddDig++;
                number/=10;
            }
        }
        if(countOddDig==countEvenDig){
            return true;
        }
        else {
            return false;
        }
    }

    /** Laboratory work 2
     * @author Hribovski Pavel
     * @param args String parameter for input via terminal
     * */
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.print("Laboratory work 2\nTo built first task enter - 1\tTo built second task enter - 2\nThe task number ");
        int choose = scanner.nextInt();
        if(choose==1){
            System.out.print("Enter the number n: ");
            int n = scanner.nextInt();
            int numberOfEven = 0;
            int numberOfStrange = 0;
            int []Arr = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Arr[" + i + "]: ");
                Arr[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                if (AllDigitsEven(Arr[i])) {
                    numberOfEven++;
                }
            }
            System.out.println("Amount of the numbers with even digits: " + numberOfEven);
            for (int i = 0; i < n; i++) {
                if (EvenEqualOdd(Arr[i])) {
                    numberOfStrange++;
                }
            }
            System.out.println("Amount of the numbers with equal amount of the even and odd digits: " + numberOfStrange+"\n");
            System.out.print("---Developed by Hribovski Pavel---\nTime of receipt of the task: Tue Feb 09 14:30:30 MSK 2021\n");
            Date date = new Date();
            System.out.println("Time of order of the task:   "+date.toString());
        }
        System.out.print("\nTo built second task enter - 2\nTo built(2-yes)? ");
        choose = scanner.nextInt();
        if(choose==2){
            try {
                System.out.print("Enter the number n (size of the square matrix): ");
                int n = scanner.nextInt();
                double [][]Arr = new double[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        Arr[i][j] = (int) (Math.random() * (2 * n + 1) - n);
                    }
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(Arr[i][j] + " ");
                    }
                    System.out.print("\n");
                }
                System.out.print("Enter the number k (size of the line matrix): ");
                int k = scanner.nextInt();
                if (k > n * n) {
                    throw new ArithmeticException("The number k must be less than n squared!");
                }
                System.out.print("Choose the way of the output of the line matrix:\nUp-Down: 1\tLeft-Right: 2\nEnter: ");
                int flag = scanner.nextInt();
                switch(flag){
                    case 2: {
                        for (int i = 0, max = 0; max < k; i++) {
                            if(i!=0) System.out.print("\n");
                            for (int j = 0; j < n && max < k; j++) {
                                System.out.print(Arr[i][j]+"  ");
                                max++;
                            }
                        }
                    break;
                    }
                    case 1: {
                        for (int i = 0, max = 0; max < k; i++) {
                            if(i!=0) System.out.print("\n");
                            for (int j = 0; j < n && max < k; j++) {
                                System.out.print(Arr[j][i] + "  ");
                                max++;
                            }
                        }
                        break;
                    }
                    default: System.out.println("You don't choose any way of output! ");
                }
            scanner.close();
            }
            catch(ArithmeticException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
