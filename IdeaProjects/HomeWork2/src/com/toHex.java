package com;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class toHex {
    public static void main(String[] Args) throws FileNotFoundException {
        Scanner scanny = new Scanner(System.in);
        System.out.println("Enter number");
        Integer num =  Integer.parseInt(scanny.next());

        System.out.println(num.toHexString(num));
    }
}
