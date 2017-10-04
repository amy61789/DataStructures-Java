package com.program01.arrayaverage;

/*
Created by Amy.Funk 10/3/2017
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayAverage {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int[] numbers = new int[10];
        int i = 0;

        System.out.println("This program gives you the average of an array.");
        System.out.println("The user will be prompted to enter 10 numbers.");

        while (i < numbers.length){
            try {
                System.out.println("Please enter a number: ");
                numbers[i] = sc.nextInt();
                sum += numbers[i];
                i++;
            }
            catch (InputMismatchException e){
                System.out.println("Invalid Input.");
                sc.nextLine();
            }
        }

        double average = sum / numbers.length;

        System.out.println("Average value of array elements is: " + average);

    }
}
