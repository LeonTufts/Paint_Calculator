package com.company;


import java.util.Locale;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Please answer the following per colour you wish to use.");

        Room roomA = new Room();

        double totalArea = 0;

        System.out.println("How many walls does your room have? ");
        int numberOfWalls = sc.nextInt();

        for (int i = 1; i <= numberOfWalls; i++) {
            System.out.println("What is the height of wall " + i + " (m) ");
            double wallHeight = sc.nextDouble();
            System.out.println("What is the width of wall " + i + " (m) ");
            double wallWidth = sc.nextDouble();
            Walls wall = new Walls(wallHeight, wallWidth);

            double thisWallArea = wall.getArea();

            System.out.println("Does this wall have any voids (e.g. Windows, doors or light switches)? ");
            String yesNo = yesNoVerifier();

            if (yesNo.equals("YES")) {
                System.out.println("How many voids (windows, doors, light switches) are on this wall?");
                int numberOfVoids = sc.nextInt();
                for (int j = 1; j <= numberOfVoids; j++) {
                    System.out.println("Which of [w]indows, [l]ight switches or [d]oors does it have (enter one)? ");
                    String wallVoid = sc.next();
                    wallVoid = wallVoid.toUpperCase();
                    boolean validAnswer = wallVoid.equals("W") || wallVoid.equals("L") || wallVoid.equals("D");
                    while (!validAnswer) {
                        System.out.println("Please enter either W, L or D.");
                        wallVoid = sc.next();
                        wallVoid = wallVoid.toUpperCase();
                        validAnswer = wallVoid.equals("W") || wallVoid.equals("L") || wallVoid.equals("D");
                    }
                    if (wallVoid.equals("W")) {

                        System.out.println("What is the height of this window (m)? ");
                        double height = sc.nextDouble();
                        System.out.println("What is the width of this window (m) ? ");
                        double width = sc.nextDouble();
                        Window window = new Window(height, width);
                        wall.addWindow(window);


                    } else if (wallVoid.equals("L")) {

                        System.out.println("What is the height of this light switch (m) ? ");
                        double height = sc.nextDouble();
                        System.out.println("What is the width of this light switch (m) ? ");
                        double width = sc.nextDouble();
                        Light_Switch light_switch = new Light_Switch(height, width);
                        wall.addLightSwitches(light_switch);

                    } else {

                        System.out.println("What is the height of this door (m) ? ");
                        double height = sc.nextDouble();
                        System.out.println("What is the width of this door (m) ? ");
                        double width = sc.nextDouble();
                        Door door = new Door(height, width);
                        wall.addDoors(door);

                        System.out.println("Is this door being painted? ");
                        yesNo = yesNoVerifier();
                        if(yesNo.equals("YES")){

                            totalArea = totalArea + 2*door.getArea();

                        }

                    }
                }
            }

            roomA.addWall(wall);

            }

        System.out.println("Are you painting your ceiling? ");
        String yesNo = yesNoVerifier();

        if(yesNo.equals("YES")){
            System.out.println("How long is your ceiling? ");
            double ceilingLength = sc.nextDouble();
            System.out.println("How wide is your ceiling? ");
            double ceilingWidth = sc.nextDouble();
            Ceiling ceiling = new Ceiling(ceilingLength, ceilingWidth);
            roomA.addCeiling(ceiling);
        }

        totalArea = totalArea + roomA.areaOfRoom();

        System.out.println(roomA.toString());
        System.out.println(totalArea);

        }

    public static String yesNoVerifier()
    {
        String yesNo = sc.next();

        yesNo = yesNo.toUpperCase();
        boolean validAnswer = yesNo.equals("YES") || yesNo.equals("NO");

        while (!validAnswer) {
            System.out.println("Please enter either Yes or No.");
            yesNo = sc.next();
            yesNo = yesNo.toUpperCase();
            validAnswer = yesNo.equals("YES") || yesNo.equals("NO");
        }

        return yesNo;
    }



}
