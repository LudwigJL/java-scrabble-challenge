package com.booleanuk;

import java.util.HashMap;

public class Scrabble {
    int score = 0;

    public Scrabble(String word) {

        HashMap<Character, Integer> letterValues = new HashMap<>();
        word = word.toUpperCase();

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

        for(int i = 0; i < word.length(); i++){
            if(letterValues.containsKey(word.charAt(i))){
                this.score += letterValues.get(word.charAt(i));
            }
        }
    }

    public int score() {
        return this.score;
    }
}
