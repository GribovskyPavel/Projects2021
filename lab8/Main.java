package by.bsu.lab8;
//        [lab8 Task]
//   + 5. Написать функциональный интерфейс с методом, который принимает
//        две строки и возвращает тоже строку. Написать реализацию
//        такого интерфейса в виде лямбды, которая возвращает ту строку,
//        которая длиннее.

//        Разработать проект управления процессами на основе создания
//        и реализации интерфейсов для следующих предметных областей:
//   + 5. Авиарейс.
//        Возможности:
//        1) получить или изменить различную
//        информацию о рейсе: номер рейса, пункт назначения, марка судна,
//        статус судна (загрузка, разгрузка, заправка, в пути, в ремонте,
//        готов к вылету, требуется ремонт);
//        2) узнать среднее время рейса;
//        3) узнать снаряженную массу;
//        4) узнать количество топлива;
//        5) отправить в пункт назначения;
//        6) отремонтировать;
//        7) заправить;
//        8) загрузить;
//        9) разгрузить;
//        10) узнать хрупкость/ценность груза;
//        Добавить дополнительные возможности для грузового
//        и пассажирского рейса.

//     +  Создать и реализовать интерфейсы, также использовать наследование
//        и полиморфизм для следующих предметных областей:
//     5. interface Mobile → abstract class Siemens Mobile → class Model.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("----- Laboratory work №8 -----");
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("""
                    In order to choose
                    The Part A enter - 1,
                    The Part B enter - 2,
                    The Part C enter - 3,
                    Enter here:\s""");
            String flag = sc.next();
            switch (flag) {
                case "1" -> {
                    System.out.println("----- Part A -----");
                    StringContainable object = (str1, str2) -> str1.length()>=str2.length() ? str1 : str2;
                    System.out.println(object.contain("InputMismatchException","Laboratory"));
                    System.out.println(object.contain("something","You"));
                }
                case "2" -> {
                    System.out.println("----- Part B -----");
                    Flight ship1 = new FlightInfo();
                    ship1.setNumberOfFlight(12345);
                    ship1.setDestination("New York");
                    ship1.setBrand("Airbus");
                    System.out.println(ship1.getNumberOfFlight());
                    System.out.println(ship1.getDestination());
                    System.out.println(ship1.getBrand());
                    System.out.println(ship1);

                    ship1 = new FlightAction(false,false,false, true, true,false);
                    ship1.PassengersOrFreight();
                    ship1.setFuelBool(true);
                    ship1.setRepairBool(false);
                    ship1.setLoadBool(false);
                    System.out.println(ship1);
                }
                case "3" -> {
                    System.out.println("----- Part C -----");
                    Model mobile = new Model();
                    System.out.println(mobile);
                    mobile.choosingVersionSiemensMobile(sc);
                    mobile.start();
                    mobile.setStatus(sc);
                    mobile.connectWithComputer();
                    mobile.connectWithDatabase();
                    mobile.connectWithNetwork();
                    mobile.exportData("Info 123456");
                    mobile.currentStatus();
                    mobile.setViruses(false);
                    System.out.println(mobile);
                    mobile.disConnectWithComputer();
                    mobile.disConnectWithDatabase();
                    mobile.disConnectWithNetwork();
                    mobile.finish();
                }
                default -> System.out.println("You entered something wrong!");
            }
        }
        catch (InputMismatchException | ArithmeticException ex){
            System.out.println("Exception: " + ex);
        }
    }
}
