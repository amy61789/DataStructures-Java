package com.example.palindrometest;

import java.util.Scanner;
import java.util.Stack;

public class PalindromeTest {

    final static String isMsg = " IS a palindrome";

    final static String isNotMsg = " is NOT a palindrome";

    public static void main(String args[]) {
        System.out.println("A palindrome is a word that reads the same forwards as backwards!");
        System.out.println("Would you like to test your word to see if it is a palindrome?");
        System.out.println("Please type 'stop' when you would like to exit.");

        Integer check = 0;

        while (check != 3) {
            check = PalindromeTestWrapper();
            if (check == 1) {
                System.out.println(isMsg);
            } else if (check == 2) {
                System.out.println(isNotMsg);
            } else if(check == 3) {
                System.out.println("Thanks for testing palindromes!");
                break;
            }
        }
    }

    public static int PalindromeTestWrapper() {

        System.out.println("Here we go, enter a word to test: ");

        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine().toLowerCase();

        if(userInput.equals("stop")){
            return 3;
        }

        Boolean checkPalindrome = isPalindrome(userInput);

        if(checkPalindrome == true){
            return 1;
        }else{
            return 2;
        }

    }

    public static Boolean isPalindrome(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        String reverse = "";

        while (!stack.isEmpty()) {
            reverse = reverse + stack.pop();
        }

        if (s.equals(reverse)) {
            return true;
        }else {
            return false;
        }
    }
}
