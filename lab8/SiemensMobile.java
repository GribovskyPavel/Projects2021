package by.bsu.lab8;

import java.util.Scanner;

abstract public class SiemensMobile implements Mobile{
    public String version;

    void choosingVersionSiemensMobile(Scanner sc){
        System.out.print("""
                --- Choosing the Siemens mobile version ---
                Enter 1 - "Siemens A31"
                Enter 2 - "Siemens E10"
                Enter 3 - "Siemens M30"
                Enter 4 - "Siemens S3 Com"
                Enter 5 - "Siemens AL21"
                Enter 6 - "Siemens C4"
                Enter 7 - "Siemens CX65"
                """);
        System.out.print("Enter here: ");
        String flag = sc.next();
        switch (flag) {
            case "1"-> version = "Siemens A31";
            case "2"-> version = "Siemens E10";
            case "3"-> version = "Siemens M30";
            case "4"-> version = "Siemens S3 Com";
            case "5"-> version = "Siemens AL21";
            case "6"-> version = "Siemens C4";
            case "7"-> version = "Siemens CX65";
            default -> System.out.println("You entered something wrong!");
        }
    }
}
