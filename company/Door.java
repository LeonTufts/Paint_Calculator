package com.company;

public class Door extends Voids{

    ///////////////////////////Attributes//////////////////////////



    ///////////////////////////Contributors////////////////////////

    public Door(double height, double width) {
        super(height, width);
    }



    //////////////////////////Methods//////////////////////////////

    public String toString(){
        return "This door is " + this.getHeight() + "m high and " + this.getWidth() + "m wide and has " + this.getArea() + "m^2 area.";
    }
}
