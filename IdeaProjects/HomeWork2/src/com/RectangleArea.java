package com;

import java.util.Scanner;

public class RectangleArea {

    public static void main(String[] args) {
        int[] Sides = new int[2];
        Scanner scanny = new Scanner(System.in);
        for (int i = 0; i < Sides.length; i++) {
            System.out.println("Enter Side:");
            Sides[i] = Integer.parseInt(scanny.next());
        }
        int Area = Sides[1] * Sides[0];
        System.out.println(Area);
    }
}