package com.company;

import java.util.ArrayList;

public class Walls extends ShapeRectangle {

    ///////////////////////////Attributes/////////////////

    private ArrayList<Window> windows;
    {
        windows = new ArrayList<Window> ();
    }

    private ArrayList<Door> doors;
    {
        doors = new ArrayList<Door> ();
    }

    private ArrayList<Light_Switch> light_switches;
    {
        light_switches = new ArrayList<Light_Switch> ();
    }

    ///////////////////////////Constructors///////////////

    public Walls(double height, double width) {
        super(height, width);
    }

    ////////////////////////Methods///////////////////////

    public String toString(){

        StringBuilder sb = new StringBuilder();

        sb.append("This wall is " + this.getHeight() + "m high and " + this.getWidth() + "m wide and has " + this.getArea() + "m^2 area. \n");

        for(Window b: windows){
            sb.append(b.toString() + "\n");
        }
        for(Door c: doors){
            sb.append(c.toString() + "\n");
        }
        for(Light_Switch d: light_switches){
            sb.append(d.toString() + "\n");
        }

        return sb.toString();
    }

    public void addWindow(Window w){
        windows.add(w);
    }

    public void addDoors(Door d){
        doors.add(d);
    }

    public void addLightSwitches(Light_Switch l){
        light_switches.add(l);
    }

    public double areaOfWindows(){
        double areaOfWindows = 0;

        for(Window a: windows){
            areaOfWindows = areaOfWindows + a.getArea();
        }
        return areaOfWindows;
    }

    public double areaOfDoors(){
        double areaOfDoors = 0;

        for(Door a: doors){
            areaOfDoors = areaOfDoors + a.getArea();
        }
        return areaOfDoors;
    }

    public double areaOfLightSwitches(){
        double areaOfLightSwitches = 0;

        for(Light_Switch a: light_switches){
            areaOfLightSwitches = areaOfLightSwitches + a.getArea();
        }
        return areaOfLightSwitches;
    }




}
