package com;

import java.util.Scanner;

/**
 * Created by Ace on 14.5.2014 г..
 */
public class CheckPointsHouse {

    public static Double[] getPoints(){

        Scanner scanny = new Scanner(System.in);
        boolean correctInput = false;
        System.out.println("Enter Points [X Y]");

        String enteredPts = new String();
        String[] enteredArray = new String[]{};
        while (correctInput == false){
            enteredPts = scanny.nextLine();
            enteredArray = enteredPts.split(" ");
            if (enteredArray.length == 2){
                correctInput = true;
            }
            else {
                System.out.println("Incorrect Input!");
            }
        }
        Double[] Doubles = new Double[]{Double.parseDouble(enteredArray[0]), Double.parseDouble(enteredArray[1])};
        return Doubles;
    }

    public static void main(String[] args){
        while (true) {
            Double[] points = getPoints();
            double X = points[0];
            double Y = points[1];
            if (X < 22.5 && X > 12.5 && Y < 13.5 && Y > 8.5) {
                if (X > 17.5 && X < 20) {
                    System.out.println("Outside!");
                } else {
                    System.out.println("Inside!");
                }
            } else if (X < 22.5 && X > 12.5 && Y < 8.5 && Y > 3.5) {
                if (X <= 17.5 && X + Y < 21) {
                    System.out.println("Outisde!");
                } else if (X >= 17.5 && X - Y > 14) {
                    System.out.println("Outisde!");
                } else {
                    System.out.println("Inside!");
                }
            } else {
                System.out.println("Outisde!");
            }
        }
    }
}
