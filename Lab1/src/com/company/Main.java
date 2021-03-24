package com.company;
import java.util.Scanner;

public class Main {
    public static int MaxElem(int [] Arr, int length){
        int max = 0;
        int index = 0;
        for (int i = 0; i < length; i++) {
            if(Math.abs(max)<Math.abs(Arr[i])){
                max=Arr[i];
                index=i;
            }
        }
        return index;
    }
    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число n: ");
        int n = scanner.nextInt();
        int []Arr = new int[n];
	    for(int i=0 ; i<n ; i++){
            System.out.print("Arr["+i+"]: ");
            Arr[i]=scanner.nextInt();
        }
        System.out.println("Введенный массив:");
        for(int i=0 ; i<n ; i++) {
            System.out.print(Arr[i] + " ");
        }
        System.out.println("\nОтсортированный по убыванию модулей методом 'пузырька' массив:");
        int variable;
        for (int j = 0; j < n; j++) {
            variable=Arr[n-j-1];
            Arr[n-j-1]= Arr[MaxElem(Arr,n-j)];
            Arr[MaxElem(Arr,n-j)]=variable;
        }
        for(int i=n-1 ; i>=0 ; i--) {
            System.out.print(Arr[i] + " ");
        }
        scanner.close();
 	    System.out.print("\n");
    }
}
