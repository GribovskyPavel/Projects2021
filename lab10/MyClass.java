package by.bsu.lab10;

public class MyClass {
    private String info;

    public MyClass(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "info='" + info + '\'' +
                '}';
    }
}
