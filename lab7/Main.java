package by.bsu.lab7;
import java.util.InputMismatchException;
import java.util.Scanner;

//        В данных лабораторных работах предусмотреть вложенный класс
//        подходящий по смыслу своего варианта,
//        а также анонимный класс.
//        5. Создать класс Department с внутренним классом,
//        с помощью объектов которого можно хранить информацию
//        обо всех должностях отдела и обо всех сотрудниках,
//        когда-либо занимавших конкретную должность.

public class Main {

    public static int inputForInt(Scanner sc) throws ArithmeticException,InputMismatchException{
        int number;
        if(sc.hasNextInt()){
            number = sc.nextInt();
            if(number<1){
                throw new ArithmeticException("The number of posts must be positive and integer!");
            }
        }
        else {
            System.out.println("You entered something wrong!");
            throw new InputMismatchException();
        }
        return number;
    }
    public static void main(String[] args) {

	    try(Scanner sc = new Scanner(System.in)) {

            System.out.println("----- Laboratory work №7 -----");
            System.out.print("Enter the number of posts in the class Department: ");
            int numberOfPosts;
            int numberOfWorkers;
            int index;
            numberOfPosts = inputForInt(sc);
            System.out.print("Enter the number of workers in the class Department: ");
            numberOfWorkers = inputForInt(sc);

            Department init = new Department(sc){
                @Override
                public void setNumberOfPosts(int numberOfPosts) throws DepartmentException {
                    super.setNumberOfPosts(numberOfPosts);
                }
            };
            init.setNumberOfPosts(numberOfPosts);
            Department.setPosts(sc);

            Department []Workers = new Department[numberOfWorkers];
            for (Department worker: Workers) {
                worker = new Department(sc);
            }
            System.out.print("Enter the index of the field from the list " + Department.getPosts().toString()+"\n(in order to get information about all objects with this field)\nEnter: ");
            index = inputForInt(sc);
            String str = Department.getPosts().get(index-1);
            init.showObjectsWithFixedPost(str);
        }
	    catch (DepartmentException | InputMismatchException | ArithmeticException | IndexOutOfBoundsException ex){
            System.out.println("Exception: " + ex);
        }
    }
}
