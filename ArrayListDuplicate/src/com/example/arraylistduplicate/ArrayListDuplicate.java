package com.example.arraylistduplicate;

import java.io.*;
import java.util.*;

public class ArrayListDuplicate {

    public static void main(String[] args) {
        ArrayList<String> duplicates = new ArrayList<>();

        try(BufferedReader in = new BufferedReader(new FileReader("words.txt"))){
            String line;
            System.out.println("Array List before duplicate removal: \n");

            while(!((line = in.readLine()) == null)){
                System.out.println(line);
                String[] words = line.split(" ");
                for (String word : words
                     ) {
                    duplicates.add(word);
                }
            }

            System.out.println("\nArray List After duplicate removal: \n");
            duplicates.stream()
                    .distinct()
                    .forEach(d -> System.out.print(d + " "));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
