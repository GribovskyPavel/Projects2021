package by.bsu.lab7;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Department {
    private static int numberOfPosts;
    private static ArrayList <String> Posts;
    private static ArrayList <Department> WorkerPosts;
    private Employee employee;

    static class Employee{
        int experience;
        double salary;
        String postEmployee;

        public Employee(){
            this.experience = 0;
            this.salary = 0;
            this.postEmployee = null;
        }
        public Employee(int experience, double salary, String postEmployee) throws DepartmentException {
            if(experience < 0 || salary < 0){
                throw new DepartmentException("The fields salary and experience are not negative!");
            }
            this.experience = experience;
            this.salary = salary;
            this.postEmployee = postEmployee;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "experience=" + experience +
                    ", salary=" + salary +
                    ", postEmployee='" + postEmployee + '\'' +
                    '}';
        }

        public int getExperience() {
            return experience;
        }
        public String getPostEmployee() {
            return postEmployee;
        }
        public double getSalary() {
            return salary;
        }
    }

    public Department(Scanner scanner) throws DepartmentException {
        if(Posts==null){
            Posts = new ArrayList<>();
        }
        if(WorkerPosts==null){
            WorkerPosts = new ArrayList<>();
        }
        if(numberOfPosts!=0) {
            System.out.println("--- Entering the information about worker ---");
            String post;
            int experience;
            double salary;
            System.out.print("Enter the experience of the worker: ");
            if(scanner.hasNextInt()){
                experience = scanner.nextInt();
            }
            else {
                System.out.println("You entered something wrong!");
                throw new InputMismatchException();
            }
            System.out.print("Enter the salary of the worker: ");
            if(scanner.hasNextDouble()){
                salary = scanner.nextDouble();
            }
            else {
                System.out.println("You entered something wrong!");
                throw new InputMismatchException();
            }
            System.out.print("Enter the post of the worker: ");
            post = scanner.next();
            Employee employee = new Employee(experience, salary, post);
            this.employee = employee;
            System.out.println("Information about the worker: " + employee);
            for (String element: Posts) {
                if(element.equals(this.employee.postEmployee)){
                    WorkerPosts.add(this);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Department{" +
                "employee=" + employee +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return employee.equals(that.employee);
    }
    @Override
    public int hashCode() {
        return Objects.hash(employee);
    }

    public static ArrayList<String> getPosts() {
        return Posts;
    }
    public static void setPosts(Scanner sc) {
        String str;
        for (int i = 0; i < numberOfPosts; i++) {
            System.out.print("Enter the post №"+i+": ");
            str = sc.next();
            Posts.add(str);
        }
        System.out.println("Chosen posts: " + Posts);
    }
    public void setNumberOfPosts(int numberOfPosts) throws DepartmentException {
        if(numberOfPosts<=0){
            throw new DepartmentException("The numberOfPosts must be positive!");
        }
        Department.numberOfPosts = numberOfPosts;
    }

    public void showObjectsWithFixedPost(String post){
        for (Department worker: WorkerPosts) {
            if(post.equals(worker.employee.getPostEmployee())){
                System.out.println("Worker with post "+post+": "+worker);
            }
        }
    }
}
