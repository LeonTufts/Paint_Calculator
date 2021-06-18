package com.company;


import java.util.ArrayList;


public class Room {


    ///////////////////////////Attributes/////////////////

    private ArrayList<Walls> walls;
    {
        walls = new ArrayList<Walls> ();
    }


    private ArrayList<Ceiling> ceiling;
    {
        ceiling = new ArrayList<Ceiling> ();
    }


    ///////////////////////////Constructors///////////////






    ////////////////////////Methods///////////////////////

    /////Adding each shape to the room

    public void addWall(Walls w){
        walls.add(w);
    }

    public void addCeiling(Ceiling c){
        ceiling.add(c);
    }

    ////////String of each shapes attributes

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Walls a: walls){
            sb.append(a.toString() + "\n");
        }

        for(Ceiling e: ceiling){
            sb.append(e.toString() + "\n");
        }
        return sb.toString();
    }

    ///////Area of each shape

    public double areaOfWalls(){
        double areaOfWalls = 0;

        for(Walls a: walls){
            areaOfWalls = areaOfWalls + a.getArea();
            areaOfWalls = areaOfWalls - a.areaOfDoors();
            areaOfWalls = areaOfWalls - a.areaOfWindows();
            areaOfWalls = areaOfWalls - a.areaOfLightSwitches();
        }
        return areaOfWalls;
    }

    public double areaOfCeiling(){
        double areaOfCeiling = 0;

        for(Ceiling c: ceiling){
            areaOfCeiling = areaOfCeiling + c.getArea();
        }
        return areaOfCeiling;
    }

    public double areaOfRoom(){
        double areaOfRoom = 0;

        areaOfRoom = areaOfWalls() + areaOfCeiling();

        return areaOfRoom;
    }

}
