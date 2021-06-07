package by.bsu.lab10;
import java.util.ArrayList;

public class NumberCollection{
    static class MyNumber{
        private double number;

        public MyNumber() {
            this.number = 0;
        }
        public MyNumber(double number) {
            this.number = number;
        }

        public double getNumber() {
            return number;
        }
        public void setNumber(double number) {
            this.number = number;
        }

        @Override
        public String toString() {
            return "MyNumber{" +
                    "number=" + number +
                    '}';
        }
    }
    private final ArrayList<MyNumber> Numbers;

    public NumberCollection() {
        Numbers = new ArrayList<>();
    }

    public boolean add(MyNumber number){
        return Numbers.add(number);
    }
    public MyNumber remove(int index){
        return Numbers.remove(index);
    }
    public MyNumber findClosestValue(MyNumber number){
        double value;
        double minValue = Double.MAX_VALUE;
        MyNumber result = new MyNumber();
        for (MyNumber elem: Numbers) {
            if(elem.getNumber()==number.getNumber()){
                continue;
            }
            value = Math.abs(number.getNumber()- elem.getNumber());
            if(value<minValue){
                minValue = value;
                result.setNumber(elem.getNumber());
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "NumberCollection{" +
                "Numbers=" + Numbers +
                '}';
    }
}
