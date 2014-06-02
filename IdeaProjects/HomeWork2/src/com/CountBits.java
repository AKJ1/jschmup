package com;

import java.util.Scanner;

/**
 * Created by Ace on 12.5.2014 г..
 */
public class CountBits {
    public static void main(String[] Args){
        Scanner scanny = new Scanner(System.in);
        System.out.println("Enter Number to Check");
        int enteredInt = Integer.parseInt(scanny.next());
        String toCheck = Integer.toBinaryString(enteredInt);
        System.out.println(toCheck);
        toCheck = toCheck.replaceAll("0", "");
        System.out.println(toCheck.length());
    }
}
