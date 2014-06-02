package com;

import java.util.*;

public class SmallestNumber {
    public static double GetSmallest(){
        List<Double> intList = new ArrayList<Double>();
        Scanner reader = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter Number");
            intList.add(Double.parseDouble(reader.next()));
        }
        return Collections.min(intList);
    }

    public static void main(String[] args){
        double smallest = GetSmallest();
        System.out.println(smallest);
    }
}
