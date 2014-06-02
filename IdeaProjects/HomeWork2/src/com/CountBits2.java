package com;

import java.util.Scanner;

public class CountBits2 {
    public static void main(String[] Args){
        Scanner scanny = new Scanner(System.in);
        System.out.println("Enter Number to Check");
        int enteredInt = Integer.parseInt(scanny.next());
        String toCheck = Integer.toBinaryString(enteredInt);
        System.out.println(toCheck);
        int counter = 0;
        for (int i = 0; i < toCheck.length()-1; i++) {
            if (toCheck.charAt(i) == toCheck.charAt(i+1)) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
