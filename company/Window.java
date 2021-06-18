package com.company;

public class Window extends Voids{


    ///////////////////////////Attributes//////////////////////////



    ///////////////////////////Contributors////////////////////////

    public Window(double height, double width) {
        super(height, width);
    }


    //////////////////////////Methods//////////////////////////////

    public String toString(){
        return "This window is " + this.getHeight() + "m high and " + this.getWidth() + "m wide and has " + this.getArea() + "m^2 area.";
    }
}
