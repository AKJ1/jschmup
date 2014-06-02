package com;

import java.util.Scanner;

public class FormattingNumbers {


    public static int getInteger(){
        int number = -1;
        Scanner scanny = new Scanner(System.in);
        while(number < 0 || number > 500){
            System.out.println("Enter Int");
            number = Integer.parseInt(scanny.next());
        }
        return number;
    }
    public static float getFloat(){
        float number;
        Scanner scanny = new Scanner(System.in);
        System.out.println("Enter Float");
        number = Float.parseFloat(scanny.next());
        return number;
    }

    public static void main(String[] Args){
        int a = getInteger();
        float b = getFloat();
        float c = getFloat();
        System.out.print(String.format("|%-10s", Integer.toHexString(a)));
        System.out.print(String.format("|%10s", Integer.toBinaryString(a)).replace(' ', '0'));
        System.out.format("|%10.2f", b);
        System.out.format("|%-10.3f|", c);

    }

}
