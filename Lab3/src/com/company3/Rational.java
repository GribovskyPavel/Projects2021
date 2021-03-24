package com.company3;
/**
 * The class Rational is used to work with rational numbers
 * @author pavelgribovsky
 */
public class Rational {
    /**
     * @params Numerator, Denominator
     * @return double, double
     */
    double Numerator;
    double Denominator;

    public Rational() {
        this.Numerator = 0;
        this.Denominator = 1;
    }
    public Rational(double numerator, double denominator) {
        this.Numerator = numerator;
        this.Denominator = denominator;
        if(this.Denominator == 0){
            throw new ArithmeticException("Division by zero!");
        }
    }

    public void setNumerator(double numerator) {
        this.Numerator = numerator;
    }
    public void setDenominator(double denominator) {
        this.Denominator = denominator;
    }

    public double getNumerator() {
        return Numerator;
    }
    public double getDenominator() {
        return Denominator;
    }
}
