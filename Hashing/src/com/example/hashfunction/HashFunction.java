package com.example.hashfunction;

import java.util.Arrays;

public class HashFunction {

    String[] theArray;
    int arraySize;

    public static void main(String[] args){

    HashFunction hashIt = new HashFunction(10);

    String[] intsToAdd = {"64", "12", "84", "1", "31", "63", "99", "14", "38"};

    hashIt.hashFunction(intsToAdd, hashIt.theArray);

    hashIt.displayTheHash(hashIt.theArray);

    }

    public void hashFunction(String[] intsForArray, String[] theArray){

        for(int n= 0; n < intsForArray.length; n++){

            String newVal = intsForArray[n];

            int arrayIndex = Integer.parseInt(newVal) % 10;

            System.out.println("Mod Index = " + arrayIndex + " for value " + newVal);

            while(theArray[arrayIndex] != "0"){

                arrayIndex++;

                System.out.println("Collision Try " + arrayIndex + " Instead");

                arrayIndex %= arraySize;
            }

            theArray[arrayIndex] = newVal;

        }

    }

    HashFunction(int size){

        arraySize = size;
        theArray = new String[size];
        Arrays.fill(theArray,"0");
    }

    public void displayTheHash(String[] theArray){

        System.out.println(Arrays.toString(theArray));

    }

}
