package com.example.arraylisteven;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListEven {

    public static void main(String[] args){
        ArrayList<String> words = new ArrayList<>();
        words.add("elephant");
        words.add("mouse");
        words.add("cat");
        words.add("parrot");
        words.add("rabbit");
        words.add("tiger");
        words.add("monkey");

        System.out.println(Arrays.toString(words.toArray()));

        removeEvenLength(words);

        System.out.println(Arrays.toString(words.toArray()));
    }

    static void removeEvenLength(ArrayList<String> words){

        for(int i = 0; i < words.size(); i++){
            int wordLength = words.get(i).length();
            if(wordLength % 2 == 0)
                words.remove(i);
        }
    }
}
