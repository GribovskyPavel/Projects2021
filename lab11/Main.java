package by.bsu.lab11;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static int inputForInt(Scanner sc) throws ArithmeticException,InputMismatchException{
        int number;
        if(sc.hasNextInt()){
            number = sc.nextInt();
            if(number<1){
                throw new ArithmeticException("The number of objects must be positive and integer!");
            }
        }
        else {
            System.out.println("You entered something wrong!");
            throw new InputMismatchException();
        }
        return number;
    }
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("----- Laboratory work №11 -----");
            MyResource[] Stations = new MyResource[2];

            System.out.print("Entering the max number of threads(buses)\nEnter here: ");
            int numberBus1 = inputForInt(scanner);
            Stations[0] = new MyResource("Ploshcha Peramogi",numberBus1);
            System.out.print("Entering the max number of threads(buses)\nEnter here: ");
            int numberBus2 = inputForInt(scanner);
            Stations[1] = new MyResource("Ploshcha Svobody",numberBus2);
            for (int i = 0; i < 20; i++) {
                Thread thread1 = new Thread(new MyThread(Stations[i%2]));
                thread1.setName("Bus #"+(i+1)+" "+Stations[i%2].getBusStation());
                thread1.start();
            }
        }
        catch (InputMismatchException | ArithmeticException | MyThreadException ex){
            System.out.println("Exception: "+ex);
        }
    }
}
