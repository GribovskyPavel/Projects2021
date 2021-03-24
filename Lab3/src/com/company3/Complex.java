package com.company3;

import java.text.DecimalFormat;

/**
 * The class Complex is used to work with complex numbers
 * @author pavelgribovsky
 */
public class Complex extends Rational{
    /**
     * @params Re, Im
     * @return Rational, Rational
     */
    Rational Re;
    Rational Im;

    public Complex(){
        Rational re = new Rational();
        this.Re = re;
        Rational im = new Rational();
        this.Im = im;
    }
    public Complex(Rational re, Rational im){
        this.Re = re;
        this.Im = im;
    }
    public Complex(double numerator, double denominator, double numerator2, double denominator2 ) {
        super(numerator, denominator);
        Rational re = new Rational(numerator, denominator);
        this.Re = re;
        Rational im = new Rational(numerator2, denominator2);
        this.Im = im;
    }

    public String ToString(){
        return "Class: Complex(extends from Rational)\nObject: "+this+"\nZ = ("+this.Re.getNumerator()+"/"+this.Re.getDenominator()+") + i("+this.Im.getNumerator()+"/"+this.Im.getDenominator()+")";
    }

    public String ToStringCount(){
        return "\nZ = ("+this.Re.getNumerator()/this.Re.getDenominator()+") + i("+this.Im.getNumerator()/this.Im.getDenominator()+")";
    }

    public Complex SuperAdd(Complex [] Cpx){
        double superNumRe = Cpx[0].Re.getNumerator();
        double superDenRe = Cpx[0].Re.getDenominator();
        double superNumIm = Cpx[0].Im.getNumerator();
        double superDenIm = Cpx[0].Im.getDenominator();
        for (int i = 1; i < Cpx.length; i++) {
            superNumRe = superNumRe * Cpx[i].Re.getDenominator() + Cpx[i].Re.getNumerator() * superDenRe;
            superDenRe *= Cpx[i].Re.getDenominator();
            superNumIm = superNumIm * Cpx[i].Im.getDenominator() + Cpx[i].Im.getNumerator() * superDenIm;
            superDenIm *= Cpx[i].Im.getDenominator();
        }
        Complex sum = new Complex(superNumRe,superDenRe,superNumIm,superDenIm);
        return sum;
    }
    public Complex SuperMulty(Complex [] Cpx){
        double superNumRe = Cpx[0].Re.getNumerator();
        double superDenRe = Cpx[0].Re.getDenominator();
        double superNumIm = Cpx[0].Im.getNumerator();
        double superDenIm = Cpx[0].Im.getDenominator();
        double bufferNumRe;
        double bufferDenRe;
        for (int i = 1; i < Cpx.length; i++) {
            bufferNumRe = superNumRe;
            superNumRe = superNumRe * Cpx[i].Re.getNumerator() * Cpx[i].Im.getDenominator() * superDenIm - superNumIm * Cpx[i].Im.getNumerator() * superDenRe * Cpx[i].Re.getDenominator();
            bufferDenRe = superDenRe;
            superDenRe = Cpx[i].Im.getDenominator() * superDenIm * superDenRe * Cpx[i].Re.getDenominator();
            superNumIm = bufferNumRe * Cpx[i].Re.getDenominator() * Cpx[i].Im.getNumerator() * superDenIm + Cpx[i].Re.getNumerator() * bufferDenRe * superNumIm * Cpx[i].Im.getDenominator();
            superDenIm = superDenRe;
        }
        Complex multy = new Complex(superNumRe,superDenRe,superNumIm,superDenIm);
        return multy;
    }
}
