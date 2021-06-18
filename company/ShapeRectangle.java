package com.company;

import java.util.Scanner;

public abstract class ShapeRectangle {

    ///////////////////////////Attributes/////////////////

    private double height;
    private double width;



    ///////////////////////////Constructors///////////////

    public ShapeRectangle(double height, double width){
        this.height = height;
        this.width = width;
    }

    ////////////////////////Methods///////////////////////

    public double getArea(){
        return height*width;
    }

    public double getHeight(){
        return height;
    }

    public double getWidth(){
        return width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

}
