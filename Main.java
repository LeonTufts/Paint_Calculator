package com.company;

import java.io.StringBufferInputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*
        int myInt = 5;
        double myDouble = myInt;

        System.out.println(myInt);
        System.out.println(myDouble);

        byte q_1 = 14;
        char q_2 = 'Y';
        String q_3 = "Hello!";
        float q_4 = 2.5f;
        int q_5 = 307;
        int q_6 = -1;
        long q_7 = 438000000;
        boolean q_8 = false;

        System.out.println(q_1);
        System.out.println(q_2);
        System.out.println(q_3);
        System.out.println(q_4);
        System.out.println(q_5);
        System.out.println(q_6);
        System.out.println(q_7);
        System.out.println(q_8);

        String thanks = "Thank you,";
        String name = "miguel!";
        String order = "Your order number is #";
        int previousOrder = 715;

        System.out.println(thanks + " " + name.toUpperCase() + "\n" + order + (++previousOrder));
         */

        Scanner sc = new Scanner(System.in);
        System.out.print("How many walls do you want to paint? ");
        int numberOfWalls = sc.nextInt();
        float totalArea = 0;

        for (int i = 1; i <= numberOfWalls; i++) {
            System.out.print("What is the height of wall " + i + " (m)? ");
            float heightOfWall = sc.nextFloat();
            System.out.print("What is the width of wall " + i + " (m)? ");
            float widthOfWall = sc.nextFloat();
            float areaOfWall = heightOfWall * widthOfWall;
            totalArea = totalArea + areaOfWall;
        }

        System.out.print("Are there any voids in your walls (e.g. window, skirting boards, light switches etc.)? ");
        String yesNo = sc.next();
        yesNo = yesNo.toUpperCase();
        if (yesNo.equals("YES")) {
            System.out.println("How many voids are in your walls? ");
            int numberOfVoids = sc.nextInt();
            for (int i = 1; i <= numberOfVoids; i++) {
                System.out.println("What is the height of void " + i + " (m)? ");
                float heightOfVoid = sc.nextFloat();
                System.out.println("What is the width of void" + i + " (m)? ");
                float widthOfVoid = sc.nextFloat();
                float areaOfVoid = heightOfVoid * widthOfVoid;
                totalArea = totalArea - areaOfVoid;
            }
        }

        System.out.println("You have " + totalArea + "m^2 to cover.");

        double amountOfPaint = totalArea/6.5;

        System.out.println("You will need " + amountOfPaint + " litres of paint, assuming 1L of paint covers 6.5m^2.");
        System.out.println("How large are your paint buckets? 2.5l, 5l, 10l? ");

        float sizeOfBucket = sc.nextFloat();

        int bucket = 0;

        if (sizeOfBucket == 2.5){
            bucket += 1;
        } else if (sizeOfBucket == 5){
            bucket += 2;
        } else if (sizeOfBucket == 10){
            bucket += 3;
        }

        int numberOfBuckets = 0;

        switch(bucket){
            case 1:
                if (amountOfPaint%2.5 == 0){
                    numberOfBuckets = ((int)(amountOfPaint/2.5));
                }else{
                    numberOfBuckets = ((int)(amountOfPaint/2.5) + 1);
                }
                System.out.println("You'll need " + numberOfBuckets + " bucket(s) of paint.");
                break;
            case 2:
                if (amountOfPaint%2.5 == 0){
                    numberOfBuckets = ((int)(amountOfPaint/5));
                }else{
                    numberOfBuckets = ((int)(amountOfPaint/5) + 1);
                }
                System.out.println("You'll need " + numberOfBuckets + " bucket(s) of paint.");
                break;
            case 3:
                if (amountOfPaint%2.5 == 0){
                    numberOfBuckets = ((int)(amountOfPaint/10));
                }else{
                    numberOfBuckets = ((int)(amountOfPaint/10) + 1);
                }
                System.out.println("You'll need " + numberOfBuckets + " bucket(s) of paint.");
                break;
        }

    }

}
