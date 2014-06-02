package com;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TriangleArea {

    public static Integer[] GetPoints() {
        Scanner reader = new Scanner(System.in);
        List<Integer> triangle = new ArrayList<Integer>();
        Integer[] returnValue = new Integer[]{};
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter next point");
            System.out.println("Enter X");
            triangle.add(Integer.parseInt(reader.next()));
            System.out.println("Enter Y");
            triangle.add(Integer.parseInt(reader.next()));
        }
        returnValue = triangle.toArray(returnValue);
        return returnValue;
    }

    public static void main(String[] args){
        Integer[] points = GetPoints();
        double area = (points[0]*(points[3] - points[5]) + points[2]*(points[5] - points[1]) + points[4]*(points[1] - points[3]) )/2;
        DecimalFormat Formatter = new DecimalFormat("#");
        System.out.println(Formatter.format(Math.abs(area)));
    }
}
