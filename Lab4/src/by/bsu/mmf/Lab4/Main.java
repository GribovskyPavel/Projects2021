package by.bsu.mmf.Lab4;
import java.util.InputMismatchException;
import java.util.Scanner;
import by.bsu.mmf.Lab4.PartA.*;
import by.bsu.mmf.Lab4.PartB.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("----- Laboratory works №№ 4-5 -----");
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("To choose the Part A enter - 1, the Part B - 2\nEnter here: ");
            String flag = scanner.next();
            switch (flag) {
                case "1" -> {
                    System.out.println("--- Part A ---");
                    Planet earth = new Planet("Earth");
                    System.out.println(earth.toString());
                    System.out.print("\n");
                    //Ocean class test
                    Ocean ocean = new Ocean(3);
                    Ocean ocean2 = new Ocean(0);
                    System.out.println(ocean.equals(ocean2));
                    System.out.println(ocean.hashCode());
                    System.out.println(ocean.toString());
                    System.out.println(ocean2.equals(ocean));
                    System.out.println(ocean2.hashCode());
                    System.out.println(ocean2.toString());
                    System.out.print("\n");
                    //Island class test
                    Island island = new Island(0);
                    Island island2 = new Island(0);
                    System.out.println(island.equals(island2));
                    System.out.println(island.hashCode());
                    System.out.println(island.toString());
                    System.out.println(island2.equals(island));
                    System.out.println(island2.hashCode());
                    System.out.println(island2.toString());
                    System.out.print("\n");
                    //Mainland class test
                    Mainland mainland = new Mainland(0);
                    Mainland mainland2 = new Mainland(0);
                    System.out.println(mainland.equals(mainland2));
                    System.out.println(mainland.hashCode());
                    System.out.println(mainland.toString());
                    System.out.println(mainland2.equals(mainland));
                    System.out.println(mainland2.hashCode());
                    System.out.println(mainland2.toString());
                    System.out.print("\n");
                    //Planet class test
                    Planet planet2 = new Planet("Venus", 1, 2, 3);
                    Planet planet3 = new Planet("Mercury", 1, 2, 3);
                    System.out.println(planet2.equals(planet3));
                    System.out.println(planet2.hashCode());
                    System.out.println(planet2.toString());
                    System.out.println(planet3.equals(planet2));
                    System.out.println(planet3.hashCode());
                    System.out.println(planet3.toString());
                }
                case "2" -> {
                    System.out.println("--- Part B ---");
                    System.out.print("Select the size of the disk in gigabytes:\n---Disk 4Gb--- Enter: 1\n---Disk 7Gb--- Enter: 2\nEnter here: ");
                    String flag2 = scanner.next();
                    int diskSize;
                    int numberSongs;
                    int fixedLengthLeft;
                    int fixedLengthRight;
                    switch (flag2) {
                        case "1": {
                            diskSize = 4*1024*1024;
                        }
                        break;
                        case "2": {
                            diskSize = 7*1024*1024;
                        }
                        break;
                        default: {
                            System.out.println("You entered something wrong!\nYour size - 3Gb(created automatically)");
                            diskSize = 3*1024*1024;
                        }
                    }
                    System.out.print("Enter the number of songs: ");
                    if (scanner.hasNextInt()) {
                        numberSongs = scanner.nextInt();
                        if(numberSongs<0){
                            throw new ArithmeticException();
                        }
                    } else {
                        System.out.println("You entered something wrong!");
                        throw new InputMismatchException();
                    }
                    Music[] Music = new Music[numberSongs];
                    MusicAction.randomInitMusicObj(Music);
                    MusicAction.outputArrMusicObj(Music);
                    System.out.println("---The whole time---");
                    System.out.println("The whole time of playing: " + MusicAction.wholeTimeOfSongsArrMusicObj(Music) + "sec");
                    int memoryAll = MusicAction.wholeMemoryOfSongsArrMusicObj(Music);
                    System.out.println("Disk status: "+MusicAction.memoryInStView(memoryAll)+"/"+MusicAction.memoryInStView(diskSize));
                    if(memoryAll>diskSize){
                        System.out.println("Writing failed! Not enough memory on the disk!");
                    }
                    else{
                        System.out.println("Writing successful!");
                    }
                    MusicAction.sortByStyle(Music);
                    System.out.print("Enter the left fixed value in seconds: ");
                    if (scanner.hasNextInt()) {
                        fixedLengthLeft = scanner.nextInt();
                        if(fixedLengthLeft<0){
                            throw new ArithmeticException();
                        }
                    } else {
                        System.out.println("You entered something wrong!");
                        throw new InputMismatchException();
                    }
                    System.out.print("Enter the right fixed value in seconds: ");
                    if (scanner.hasNextInt()) {
                        fixedLengthRight = scanner.nextInt();
                        if(fixedLengthRight<0){
                            throw new ArithmeticException();
                        }
                        if(fixedLengthRight<fixedLengthLeft){
                            int buf;
                            buf=fixedLengthRight;
                            fixedLengthRight=fixedLengthLeft;
                            fixedLengthLeft=buf;
                        }
                    } else {
                        System.out.println("You entered something wrong!");
                        throw new InputMismatchException();
                    }
                    MusicAction.outputWithValueArrMusicObj(Music, fixedLengthLeft, fixedLengthRight);
                }
                default -> System.out.println("You entered something wrong!");
            }
        }
        catch (InputMismatchException in){
            scanner.close();
            System.out.println("InputMismatchException!");
        }
        catch (ArithmeticException ar){
            scanner.close();
            System.out.println("ArithmeticException!");
        }
        catch (MusicException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}
