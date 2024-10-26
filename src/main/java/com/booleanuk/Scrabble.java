package com.booleanuk;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Scrabble {
    HashMap<Character, Integer> letterValues = new HashMap<>();
    Stack<Character> multiplierStack = new Stack<>();
    Boolean isDouble = false;
    Boolean isTriple = false;
    Boolean validGame = true;

    int score = 0;


    public Scrabble(String word) {
        setLetterValues();
        word = word.toUpperCase();
        recur(word);
    }

    public void recur(String s) {

        if (s.equals("")) {
            if (isTriple || isDouble){
                this.score = 0;
                System.out.println("Score: " + score);
            }
            else {
                System.out.println("Score: " + score);
            }
        }
        else if (!letterValues.containsKey(s.charAt(0))){
            this.score = 0;
            System.out.println("Score: " + score);
        }


        else {
            char currentChar = s.charAt(0);
            if (currentChar == '[' ) {
                multiplierStack.push(currentChar);
                isTriple = true;
            }

            if (currentChar == '{' ) {
                multiplierStack.push(currentChar);
                isDouble = true;
            }

            if (currentChar == ']' ) {
                if (multiplierStack.isEmpty() || !isMatchingBracket(multiplierStack.pop(), currentChar)) {
                    validGame = false;
                    System.out.println("Not valid");
                    return;
                }
                isTriple = false;
            }

            if (currentChar == '}' ) {
                if (multiplierStack.isEmpty() || !isMatchingBracket(multiplierStack.pop(), currentChar)) {
                    validGame = false;
                    System.out.println("Not valid");
                    return;
                }
                isDouble = false;
            }

            int currScore = getValue(s.charAt(0));

            if(isTriple && isDouble){
                this.score += currScore * 3 * 2;
            }
            else if (isTriple){
                this.score += currScore * 3;
            } else if (isDouble) {
                this.score += currScore * 2;

            } else {
                this.score += currScore;
            }


            recur (s.substring(1));
        }
    }
    private boolean isMatchingBracket(char open, char close) {

        return (open == '{' && close == '}') || (open == '[' && close == ']');

    }

    public void setLetterValues(){

        //Game vals
        letterValues.put('[', 0);
        letterValues.put(']', 0);
        letterValues.put('{', 0);
        letterValues.put('}', 0);

        // A, E, I, O, U, L, N, R, S, T = 1
        letterValues.put('A', 1);
        letterValues.put('E', 1);
        letterValues.put('I', 1);
        letterValues.put('O', 1);
        letterValues.put('U', 1);
        letterValues.put('L', 1);
        letterValues.put('N', 1);
        letterValues.put('R', 1);
        letterValues.put('S', 1);
        letterValues.put('T', 1);

        //D, G = 2
        letterValues.put('D', 2);
        letterValues.put('G', 2);

        // B, C, M, P = 3
        letterValues.put('B', 3);
        letterValues.put('C', 3);
        letterValues.put('M', 3);
        letterValues.put('P', 3);

        //F, H, V, W, Y = 4
        letterValues.put('F', 4);
        letterValues.put('H', 4);
        letterValues.put('V', 4);
        letterValues.put('W', 4);
        letterValues.put('Y', 4);

        //K = 5
        letterValues.put('K', 5);

        //J, X = 8
        letterValues.put('J', 8);
        letterValues.put('X', 8);

        //Q, Z = 10
        letterValues.put('Q', 10);
        letterValues.put('Z', 10);
    }

    public int getValue(Character c){
        return letterValues.get(c);
    }

    public int score() {
        return this.score;
    }
}

