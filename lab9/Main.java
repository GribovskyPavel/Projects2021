package by.bsu.lab9;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

//        Создать программу обработки текста учебника по программированию с использованием классов:
//        Символ, Слово, Предложение, Абзац, Лексема, Листинг, Знак препинания и др. Во всех задачах
//        с формированием текста заменять табуляции и последовательности пробелов одним пробелом.
//     5. В каждом предложении текста поменять местами первое слово с последним,
//        не изменяя длины предложения.

public class Main {
    public static void main(String[] args) {
        System.out.println("----- Laboratory works № 9 -----");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("""
                    In order to choose
                    The Part A enter - 1,
                    The Part B enter - 2,
                    The Part C enter - 3;
                    Enter here:\s""");
            String flag = scanner.next();
            switch (flag) {
                case "1" -> {
                    String filenameIn = "resources/DataIn.txt";
                    String filenameOut = "resources/DataOutput.txt";
                    try(BufferedReader reader = new BufferedReader(new FileReader(filenameIn));
                        FileWriter writer = new FileWriter(filenameOut)){
                        String allContent = "";
                        String buffer;
                        while ((buffer=reader.readLine())!=null) {
                            allContent += buffer;
                            allContent+="\n";
                        }
                        allContent = allContent.replace(" тексты "," тексты o Java ");
                        writer.write(allContent);
                    }
                }
                case "2" -> {
                    String filenameIn = "resources/DataInEng.txt";
                    String filenameOut = "resources/DataOutputEng.txt";
                    try(BufferedReader reader = new BufferedReader(new FileReader(filenameIn));
                        FileWriter writer = new FileWriter(filenameOut)){
                        String allContent = "";
                        String buffer;
                        String bufferChar = "";
                        int counter;
                        while ((buffer=reader.readLine())!=null) {
                            char ch;
                            for (int i = 0; i < buffer.length(); i++) {
                                ch = buffer.charAt(i);
                                bufferChar+=ch;
                                counter = 1;
                                if(counter + i >= buffer.length()) break;
                                while (ch == buffer.charAt(counter + i)) {
                                    counter++;
                                    bufferChar += ch;
                                    if(counter + i >= buffer.length()) break;
                                }
                                if(counter!=1) {
                                    buffer = buffer.replace(bufferChar, ch + String.valueOf(counter));
                                }
                                bufferChar = "";
                            }
                            allContent+=buffer;
                            allContent+="\n";
                        }
                        writer.write(allContent);
                    }
                }
                case "3" -> {
                    String filenameIn = "resources/DataInWords.txt";
                    String filenameOut = "resources/DataOutputWords.txt";
                    try(BufferedReader reader = new BufferedReader(new FileReader(filenameIn));
                        FileWriter writer = new FileWriter(filenameOut)){
                        Word sentenceBuffer = new Word("");
                        Symbol dot = new Symbol('.');
                        String buffer;
                        int indexBegin = 0;
                        int indexEnd;
                        int counter = 0;
                        while ((buffer=reader.readLine())!=null) {
                            for (int i = 0; i < buffer.length(); i++) {
                                if(buffer.charAt(i)==dot.getSymbol()){
                                    counter++;
                                }
                            }
                            for (int i = 0; i < counter; i++) {
                                indexEnd = buffer.indexOf(Character.toString(dot.getSymbol()));
                                sentenceBuffer.setWord(buffer.substring(indexBegin, indexEnd));
                                Sentence sentenceBufferReal = new Sentence(sentenceBuffer.getWord());

                                System.out.println(sentenceBufferReal.createSentence());
                                sentenceBufferReal.firstLastChange();

                                System.out.println(sentenceBufferReal.createSentence());
                                writer.write(sentenceBufferReal.createSentenceWithoutSpaces());
                                buffer=buffer.substring(indexEnd+1);
                            }
                            counter=0;
                        }

                    }
                }
                default -> System.out.println("You entered something wrong!");
            }
        }
        catch (InputMismatchException | ArithmeticException | IOException | IndexOutOfBoundsException ex){
            System.out.println("Exception: " + ex);
        }
    }
}
