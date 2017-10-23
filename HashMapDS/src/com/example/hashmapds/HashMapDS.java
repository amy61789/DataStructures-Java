package com.example.hashmapds;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class HashMapDS {

    public static void main(String[] args){

        Map<String, Integer> agileMap = new HashMap<>();

        try(BufferedReader in = new BufferedReader(new FileReader("agile_manifesto.txt"))){
            String line;
            System.out.println("Agile Manifesto \n");

            while(!((line = in.readLine()) == null)){
                System.out.println(line);
                String[] words = line.trim().replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

                for(int i = 0; i < words.length; i++){
                    if(agileMap.containsKey(words[i])){
                        agileMap.put(words[i], agileMap.get(words[i]) + 1);
                    }else{
                        agileMap.put(words[i], 1);
                    }
                }

            }

            Set<Map.Entry<String, Integer>> entries = agileMap.entrySet();
            System.out.println("\nHashMap before sorting: \n");
            for(Map.Entry<String, Integer> entry : entries){
                System.out.println(entry.getKey() + " => " + entry.getValue()); }

            TreeMap<String, Integer> sorted = new TreeMap<>(agileMap);
            Set<Map.Entry<String, Integer>> mappings = sorted.entrySet();

            System.out.println("\nHashMap after sorting by keys alphabetically: \n");
            for(Map.Entry<String, Integer> mapping : mappings){
                System.out.println(mapping.getKey() + " => " + mapping.getValue()); }


            System.out.print("\nHashMap after sorting by values in descending order: \n");
            for(Map.Entry<String, Integer> s: sortByValue(agileMap).entrySet()){
                System.out.println(s.getKey() + " => " + s.getValue());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K,V> map){
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new

                ));
    }

}

