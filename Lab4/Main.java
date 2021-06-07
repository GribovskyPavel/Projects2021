package by.bsu.mmf.Lab4;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import by.bsu.mmf.Lab4.PartA.*;
import by.bsu.mmf.Lab4.PartB.*;

public class Main {
    public static int inputForInt(Scanner sc) throws ArithmeticException,InputMismatchException{
        int number;
        if(sc.hasNextInt()){
            number = sc.nextInt();
            if(number<1){
                throw new ArithmeticException("The number of things must be positive and integer!");
            }
        }
        else {
            System.out.println("You entered something wrong!");
            throw new InputMismatchException();
        }
        return number;
    }
    public static String wordUpLettersEng(String str){
        String newWord = "";
        for (int i = 0; i < str.length(); i++) {
            int code = (str.charAt(i))-32;
            if(i==0){
                code = (str.charAt(i));
            }
            char ch = (char)code;
            newWord+=ch;
        }
        return newWord;
    }
    public static void main(String[] args) {
        System.out.println("----- Laboratory works №№ 4-5-6 -----");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("""
                    In order to choose
                    The Part A(LW 4) enter - 1,
                    The Part B(LW 4) enter - 2,
                    The Part C(LW 5) enter - 3,
                    The Part A(LW 6) enter - 4,
                    The Part B(LW 6) enter - 5,
                    The Part C(LW 6) enter - 6;
                    Enter here:\s""");
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
                    int numberStyles = 8;
                    final int gb = 1024 * 1024;
                    switch (flag2) {
                        case "1": {
                            diskSize = 4 * gb;
                        }
                        break;
                        case "2": {
                            diskSize = 7 * gb;
                        }
                        break;
                        default: {
                            System.out.println("You entered something wrong!\nYour size - 3Gb(created automatically)");
                            diskSize = 3 * gb;
                        }
                    }
                    System.out.print("Enter the number of songs: ");
                    numberSongs = inputForInt(scanner);
                    Music[] Music = new Music[numberSongs];
                    MusicAction.randomInitMusicObj(Music);

                    Thread thr = new Thread(new MusicThread(Music));
                    thr.start();
                    Thread.sleep(3);
                    //MusicAction.outputArrMusicObj(Music);
                    System.out.println("---The whole time---");
                    System.out.println("The whole time of playing: " + MusicAction.wholeTimeOfSongsArrMusicObj(Music) + "sec");
                    int memoryAll = MusicAction.wholeMemoryOfSongsArrMusicObj(Music);
                    System.out.println("Disk status: " + MusicAction.memoryInStView(memoryAll) + "/" + MusicAction.memoryInStView(diskSize));
                    if (memoryAll > diskSize) {
                        System.out.println("Writing failed! Not enough memory on the disk!");
                    } else {
                        System.out.println("Writing successful!");
                    }

                    MusicAction.sortByStyle(Music, numberStyles);

                    System.out.print("Enter the left fixed value in seconds: ");
                    fixedLengthLeft = inputForInt(scanner);
                    System.out.print("Enter the right fixed value in seconds: ");
                    if (scanner.hasNextInt()) {
                        fixedLengthRight = scanner.nextInt();
                        if (fixedLengthRight < 0) {
                            throw new ArithmeticException();
                        }
                        if (fixedLengthRight < fixedLengthLeft) {
                            int buf;
                            buf = fixedLengthRight;
                            fixedLengthRight = fixedLengthLeft;
                            fixedLengthLeft = buf;
                        }
                    } else {
                        System.out.println("You entered something wrong!");
                        throw new InputMismatchException();
                    }
                    MusicAction.outputWithValueArrMusicObj(Music, fixedLengthLeft, fixedLengthRight);

                    // ----- Part B -----
                    System.out.println("----- Part B -----");
//                    try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Songs.xml"))){
//                        for (Music song : Music) {
//                            output.writeObject(song);
//                        }
//                    }
//                    try(ObjectInputStream input = new ObjectInputStream(new FileInputStream("Songs.xml"))){
//                        for (Music song : Music) {
//                            Music newSong = (Music) input.readObject();
//                            System.out.println(newSong);
//                        }
//
                    String fileName = "Songs.xml";
                    Connector connector = new Connector(fileName);
                    connector.toSerializeInFile(Music);
                    connector.toDeserializeFromFile(Music);
                }
                case "3" -> {
                    System.out.println("--- Part C ---");
                    BufferedReader reader = null;
                    try {
//                      File file = new File("Data.txt");
//                      if(!file.exists()){
//                          file.createNewFile();
//                      }
//                      PrintWriter writer = new PrintWriter(file);
//                      writer.println("Testing");
//                      writer.close();
                        reader = new BufferedReader(new FileReader("Data.txt"));
                        String s;
                        int counter = 0;
                        int arrSize;
                        double sum = 0;
                        while ((s = reader.readLine()) != null){
                            counter++;
                            System.out.println(s);
                        }
                        arrSize = counter/2;
                        reader = null;
                        reader = new BufferedReader(new FileReader("Data.txt"));
                        double [] Arr = new double[arrSize];
                        for (int i = 0; i < arrSize; i++) {
                            Arr[i] = Double.parseDouble(reader.readLine());
                            reader.readLine();
                            sum += Arr[i];
                        }
                        System.out.println("The sum of these numbers: " + sum);
                        System.out.println("The middle value of these numbers: " + (sum/arrSize+sum%arrSize));
                    }
                    catch (IOException | NumberFormatException | ArrayIndexOutOfBoundsException io){
                        System.out.println("Exception: " + io);
                    }
                    finally {
                        try {
                            assert reader != null;
                            reader.close();
                        }
                        catch (IOException | NullPointerException io){
                            System.out.println("Exception: " + io);
                        }
                    }
                }
                case "4" -> {
                    System.out.println("--- Part A ---");
                    String nameFileInput = "StringIn.txt";
                    String nameFileOutput = "StringsOut.txt";
                    try(BufferedReader readerBegin = new BufferedReader(new FileReader("Files.txt"))){
                        nameFileInput = readerBegin.readLine();
                        nameFileOutput = readerBegin.readLine();
                    }
                    catch (IOException in) {
                        System.out.println("Exception: " + in);
                    }
                    File file = new File(nameFileInput);
                    File fileOutput = new File(nameFileOutput);
                    try (PrintWriter writer = new PrintWriter(file);
                         PrintWriter writerOut = new PrintWriter(fileOutput);
                         Scanner scanner1 = new Scanner(System.in);
                         BufferedReader reader = new BufferedReader(new FileReader(nameFileInput))) {
                        int size;
                        int flag2 = 0;
                        int max = 0;
                        int indexMax = 0;
                        int stringCounter = 0;
                        String str;
                        String result;
                        System.out.print("Enter the number of strings: ");
//                        if (scanner.hasNextInt()) {
//                            size = scanner.nextInt();
//                            if (size < 0) {
//                                throw new ArithmeticException();
//                            }
//                        } else {
//                            System.out.println("You entered something wrong!");
//                            throw new InputMismatchException();
//                        }
                        size = inputForInt(scanner);
                        for (int i = 0; i < size; i++) {
                            System.out.print("String["+i+"]: ");
                            str = scanner1.next();
                            writer.println(str);
                        }
                        writer.close();
                        while ((str = reader.readLine()) != null) {
                            for (int i = 0; i < str.length(); i++) {
                               if(48 <= (int)str.charAt(i) && (int)str.charAt(i) < 58){
                                    flag2++;
                                    if(flag2>max) {
                                        max=flag2;
                                        indexMax = i-max+1;
                                    }
                                    continue;
                               }
                               flag2 = 0;
                            }
                            result = str.substring(indexMax,indexMax+max);
                            System.out.print("The longest substring of digits in String["+stringCounter+"]: ");
                            System.out.println(result);
                            writerOut.println(result);
                            max = indexMax = flag2 = 0;
                            stringCounter++;
                        }
                    } catch (IOException in) {
                        System.out.println("Exception: " + in);
                    }
                }
                case "5" -> {
                    System.out.println("--- Part B ---");
                    Music song = new Music(300,500,"Freedom");
                    try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Songs.dat"))){
                        output.writeObject(song);
                    }
                    try(ObjectInputStream input = new ObjectInputStream(new FileInputStream("Songs.dat"))){
                        Music newSong = (Music) input.readObject();
                        System.out.println(newSong);
                    }
                }
                case "6" -> {
                    System.out.println("--- Part C ---");
                    File dir = new File("resources");
                    if(!dir.exists()){
                        dir.mkdir();
                    }
                    File file = new File("resources/StudentsOutput.txt");
                    if(!file.exists()){
                        file.createNewFile();
                    }
                    try(BufferedReader reader = new BufferedReader(new FileReader("Students.txt"));
                        Writer writer = new PrintWriter("resources/StudentsOutput.txt")){
                        String str;
                        String name;
                        String allFileContent = "";
                        int allMarks = 0;
                        int amountOfMarks = 0;
                        ArrayList<String> Names = new ArrayList<>();
                        while ((str = reader.readLine()) != null){
                            allFileContent=allFileContent.concat(str+"\n");
                            name = str;
                            str = reader.readLine();
                            allFileContent=allFileContent.concat(str+"\n");
                            for (int i = 0; i < str.length(); i++) {
                                if(48 < str.charAt(i) && str.charAt(i) < 58){
                                    allMarks+=str.charAt(i)-48;
                                    amountOfMarks++;
                                }
                            }
                            double markMedium = allMarks/amountOfMarks+allMarks%amountOfMarks;
                            if(markMedium > 7){
                                Names.add(name);
                            }
                            allMarks = amountOfMarks = 0;
                        }
                        for (String student: Names) {
                            System.out.println(student);
                            allFileContent=allFileContent.replace(student,wordUpLettersEng(student));
                        }
                        writer.write(allFileContent);
                    }
                    catch (IOException in) {
                         System.out.println("Exception: " + in);
                    }
                }
                default -> System.out.println("You entered something wrong!");
            }
        } catch (InputMismatchException | ArithmeticException | OutOfMemoryError | MusicException | IOException | ClassNotFoundException | InterruptedException in) {
            System.out.println("Exception: " + in);
        }
    }
}
