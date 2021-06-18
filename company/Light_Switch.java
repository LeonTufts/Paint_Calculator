package com.company;

public class Light_Switch extends Voids{

    ///////////////////////////Attributes//////////////////////////



    ///////////////////////////Contributors////////////////////////

    public Light_Switch(double height, double width) {
        super(height, width);
    }


    //////////////////////////Methods//////////////////////////////

    public String toString(){
        return "This light switch is " + this.getHeight() + "m high and " + this.getWidth() + "m wide and has " + this.getArea() + "m^2 area.";
    }
}
