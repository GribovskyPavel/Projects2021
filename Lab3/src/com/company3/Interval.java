package com.company3;
/**
 * The class Interval is used to work with intervals, half-intervals and segments
 * @author pavelgribovsky
 */
public class Interval {
    /**
     * @params left, right, leftIsEmpty, rightIsEmpty
     * @return double, double, boolean, boolean
     */
    private double left;
    private double right;
    private boolean leftIsEmpty;
    private boolean rightIsEmpty;

    public Interval() {
        this.left = 0;
        this.right = 1;
        this.rightIsEmpty = true;
        this.leftIsEmpty = true;
    }
    public Interval(double left, double right,boolean leftIsEmpty, boolean rightIsEmpty) {
        this.left = left;
        if( left < right ) {
            this.right = right;
        }
        else{
            this.left = right;
            this.right = left;
        }
        this.rightIsEmpty = rightIsEmpty;
        this.leftIsEmpty = leftIsEmpty;
    }

    public void setLeft(double left) {
        this.left = left;
    }
    public void setRight(double right) {
        this.right = right;
    }

    public double getLeft() {
        return left;
    }
    public boolean getRightIsEmpty() {
        return rightIsEmpty;
    }
    public boolean getLeftIsEmpty() {
        return leftIsEmpty;
    }
    public double getRight() {
        return right;
    }

    public void setLeftArg(double left){
        this.left = left;
    }
    public void setRightArg(double right){
        this.right = right;
    }
    public void setLeftIsEmptyArg(boolean leftIsEmpty) {
        this.leftIsEmpty = leftIsEmpty;
    }
    public void setRightIsEmptyArg(boolean rightIsEmpty) {
        this.rightIsEmpty = rightIsEmpty;
    }

    public String ToString(){
      return "Class: Interval\nObject: "+this+"\nLeft point: "+this.left+"\nRight point: "+this.right+"\nType of the left point: "+this.leftIsEmpty+"\nType of the right point: "+this.rightIsEmpty;
    }

    public Interval intersect(Interval inter){
        if(inter.getLeft()<this.left && inter.getRight()>this.right){
            return this;
        }
        if(inter.getLeft()<this.left && inter.getRight()<this.right && this.left<inter.getRight() ){
            Interval interval = new Interval(this.left,inter.getRight(),this.leftIsEmpty,inter.rightIsEmpty);
            return interval;
        }
        if(inter.getLeft()>this.left && inter.getRight()>this.right && inter.getLeft()<this.right){
            Interval interval = new Interval(inter.getLeft(),this.right,inter.leftIsEmpty,this.rightIsEmpty);
            return interval;
        }
        if(inter.getLeft()>this.left && inter.getRight()<this.right){
            return inter;
        }
        return this;
    }
    public Interval union(Interval inter){
        if(inter.getLeft()<this.left && inter.getRight()>this.right){
            return inter;
        }
        if(inter.getLeft()<this.left && inter.getRight()<this.right && this.left<inter.getRight()){
            Interval interval = new Interval(inter.getLeft(),this.right,inter.getLeftIsEmpty(),this.rightIsEmpty);
            return interval;
        }
        if(inter.getLeft()>this.left && inter.getRight()>this.right && inter.getLeft()<this.right){
            Interval interval = new Interval(this.left,inter.getRight(),this.leftIsEmpty,inter.getRightIsEmpty());
            return interval;
        }
        if(inter.getLeft()>this.left && inter.getRight()<this.right){
            return this;
        }
        return this;
    }

    public Interval multiply(double number){
        Interval inter = new Interval();
        inter.setLeftArg(this.left*number);
        inter.setRightArg(this.right*number);
        inter.setLeftIsEmptyArg(this.leftIsEmpty);
        inter.setRightIsEmptyArg(this.rightIsEmpty);
        return inter;
    }
    public Interval divide(double number){
        Interval inter = new Interval();
        inter.setLeftArg(this.left/number+this.left%number);
        inter.setRightArg(this.right/number+this.right%number);
        inter.setLeftIsEmptyArg(this.leftIsEmpty);
        inter.setRightIsEmptyArg(this.rightIsEmpty);
        return inter;
    }
}
