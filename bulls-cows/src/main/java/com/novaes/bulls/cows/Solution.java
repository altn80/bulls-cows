/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.bulls.cows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author andre
 */
public class Solution {

    public String getHint(String secret, String guess) {
        if(secret.length() == 0) {
            return "0A0B";
        }
        List<String> listSecret = Arrays.stream(secret.split("")).collect(Collectors.toList());
        List<String> listGuess = Arrays.stream(guess.split("")).collect(Collectors.toList());
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
                listSecret.remove(i);
                listGuess.remove(i);
            }
        }
        for (int i = 0; i < listGuess.size(); i++) {
            if (listSecret.contains(listGuess.get(i))) {
                listSecret.remove(listSecret.indexOf(listGuess.get(i)));
                cows++;
            }
        }
        return bulls
                + "A" + cows
                + "B";
    }

    public static void main(String[] args) {
        String secret = "1123";
        String guess = "0111";
        System.out.println(new Solution().getHint(secret, guess));
    }

}
