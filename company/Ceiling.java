package com.company;

public class Ceiling extends ShapeRectangle {

    ///////////////////////Attributes///////////////////////////////





    //////////////////////Constructors///////////////////////////////

    public Ceiling(double length, double width) {
        super(length, width);
    }



    //////////////////////Methods///////////////////////////////////

    public String toString(){
        return "The ceiling is " + this.getHeight() + "m long and " + this.getWidth() + "m wide and has " + this.getArea() + "m^2 area.";
    }
}
