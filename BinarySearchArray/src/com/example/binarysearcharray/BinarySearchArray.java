package com.example.binarysearcharray;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BinarySearchArray {

    public static void main(String[] args){

        ArrayList<Integer> importNumbers = new ArrayList<>();

        try(BufferedReader in = new BufferedReader(new FileReader("BS.txt"))){
            String line;
            Integer number;

            while(!((line = in.readLine()) == null)){
                number = Integer.parseInt(line);
                importNumbers.add(number);
            }

            Collections.sort(importNumbers);

            System.out.println("Hello! Welcome to the ArrayList Number Search!");
            Integer userInput = 1;

            while(!(userInput == 0)) {
                Scanner sc = new Scanner(System.in);
                System.out.println("If you would like to end the search, you can do so by entering in 0.");
                System.out.println("Enter in a numerical value for me to search for: ");
                userInput = sc.nextInt();

                Integer numberIndex = recursiveBS(importNumbers, 0, importNumbers.size(), userInput);

                if (numberIndex > -1 && !(userInput == 0)) {
                    System.out.println("The index of your number is: " + numberIndex);
                } else if(!(userInput == 0)){
                    System.out.println("I'm sorry, that number is not included in my Sorted Array List.");
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int recursiveBS(ArrayList<Integer> sortedArray, int start, int end, int userInput){

        if(start < end){
            int midPoint = (start + end) / 2;

            if(userInput < sortedArray.get(midPoint)) {
                return recursiveBS(sortedArray, start, midPoint, userInput);
            }else if (userInput > sortedArray.get(midPoint)){
                return recursiveBS(sortedArray, midPoint+1, end, userInput);
            }else {
                return sortedArray.indexOf(userInput);
            }
        }
        return (sortedArray.indexOf(userInput));
    }


}
