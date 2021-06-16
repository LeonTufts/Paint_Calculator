package com.company;

import java.io.StringBufferInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("How many walls do you want to paint? ");
        int numberOfWalls = sc.nextInt();

        float[][] walls = new float[numberOfWalls][3];
        float totalArea = 0;

        for (int i = 1; i <= numberOfWalls; i++) {
            System.out.print("What is the height of wall " + i + " (m)? ");
            float heightOfWall = sc.nextFloat();
            System.out.print("What is the width of wall " + i + " (m)? ");
            float widthOfWall = sc.nextFloat();
            float areaOfWall = heightOfWall * widthOfWall;
            float[] thisWall = {heightOfWall, widthOfWall, areaOfWall};
            walls[i-1] = thisWall;
            totalArea = totalArea + areaOfWall;
        }

        System.out.print("Are there any voids in your walls (e.g. window, skirting boards, light switches etc.)? ");

        String yesNo = yesNoVerifier();

        if (yesNo.equals("YES")) {
            System.out.println("How many voids are in your walls? ");
            int numberOfVoids = sc.nextInt();
            float[][] voids = new float[numberOfVoids][3];
            for (int i = 1; i <= numberOfVoids; i++) {
                System.out.println("Which wall is void " + i + " on? (e.g. 1, 2, 3...) ");
                int wallNumber = sc.nextInt();
                while (wallNumber > numberOfWalls){
                    System.out.println("You haven't entered that number of walls." + "\n" + "Please select a previously entered wall");
                    wallNumber = sc.nextInt();
                }
                System.out.println("What is the height of void " + i + " (m)? ");
                float heightOfVoid = sc.nextFloat();
                if (heightOfVoid>walls[wallNumber - 1][0]) {
                    System.out.println("Your void is taller than your wall.");
                    i = i - 1;
                    continue;
                }
                System.out.println("What is the width of void " + i + " (m)? ");
                float widthOfVoid = sc.nextFloat();
                if(widthOfVoid>walls[wallNumber - 1][1]){
                    System.out.println("Your void is wider than your wall.");
                    i = i - 1;
                    continue;
                }
                float areaOfVoid = heightOfVoid * widthOfVoid;
                float[] thisVoid = {heightOfVoid, widthOfVoid, areaOfVoid};
                walls[wallNumber-1][2] = walls[wallNumber-1][2] - areaOfVoid;
                totalArea = totalArea - areaOfVoid;
            }
        }

        System.out.println("You have " + totalArea + "m^2 to cover.");

        double amountOfPaint = totalArea/12;

        System.out.println("You will need " + amountOfPaint + " litres of paint, assuming 1L of emulsion paint covers 12m^2.");
        
        int[] numberOfBuckets = howManyBuckets(amountOfPaint);

        System.out.println("You will need: \n" + numberOfBuckets[0] + " |10 Litre buckets");
        System.out.println(numberOfBuckets[1] + " |5 Litre buckets");
        System.out.println(numberOfBuckets[2] + " |2.5 Litre buckets");

        System.out.println("Would you like to see a wall by wall breakdown? ");

        yesNo = yesNoVerifier();

        if (yesNo.equals("YES")){
            System.out.println(Arrays.toString(walls));
        }

    }

    public static String yesNoVerifier() {

        Scanner sc = new Scanner(System.in);
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

    public static int[] howManyBuckets(double amountOfPaint){

        int [] numberOfBuckets = new int[3];
        double paintLeft = amountOfPaint % 10;

        numberOfBuckets[0] = (int)paintLeft/10;

        if(paintLeft > 7.5){
            numberOfBuckets[0] = numberOfBuckets[0] + 1;
            return numberOfBuckets;
        } else if (paintLeft > 5){
            numberOfBuckets[1] = 1;
            numberOfBuckets[2] = 1;
            return numberOfBuckets;
        } else if (paintLeft > 2.5){
            numberOfBuckets[1] = 1;
            return numberOfBuckets;
        }else{
            numberOfBuckets[2] = 1;
            return numberOfBuckets;
        }

    }

}
