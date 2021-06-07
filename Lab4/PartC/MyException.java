package by.bsu.mmf.Lab4.PartC;
//        Создать собственный класс исключения. Предусмотреть
//        обработку исключений, возникающих при нехватке памяти,
//        отсутствии самого файла по заданному адресу, отсутствии
//        или некорректности требуемой записи в файле, недопустимом
//        значении числа (выходящим за пределы максимально допустимых значений) и т.д.

public class MyException extends Exception{
    public MyException(Throwable cause) {
        super(cause);
    }
    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
    public MyException(String message) {
        super(message);
    }
    public MyException() {
    }
}
