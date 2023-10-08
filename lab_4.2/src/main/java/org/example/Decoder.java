package org.example;

import java.util.HashMap;

public class Decoder {


    public static String decodeVowels(String str) {


        HashMap<Character, Character> vowels = new HashMap<>();
        vowels.put('1', 'a');
        vowels.put('2', 'e');
        vowels.put('3', 'i');
        vowels.put('4', 'o');
        vowels.put('5', 'u');

        StringBuilder decoded = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (vowels.containsKey(ch)) {
                decoded.append(vowels.get(ch));
            } else {
                decoded.append(ch);
            }
        }
        return decoded.toString();
    }

    public static String decodeConsonant(String word) {
        char[] consonants = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k',
                'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w',
                'x', 'y', 'z'};
        StringBuilder result = new StringBuilder(word);

        for (int i = 0; i < result.length(); i++) {
            char c = result.charAt(i);
            if (isConsonant(c, consonants)) {
                char nextConsonant = getNextConsonant(c, consonants);
                result.setCharAt(i, nextConsonant);
            }
        }

        return result.toString();
    }

    public static boolean isConsonant(char c, char[] consonants) {
        for (char consonant : consonants) {
            if (c == consonant) {
                return true;
            }
        }
        return false;
    }

    public static char getNextConsonant(char c, char[] consonants) {
        int currentIndex = -1;
        for (int i = 0; i < consonants.length; i++) {
            if (c == consonants[i]) {
                currentIndex = i;
                break;
            }
        }

        int nextIndex = (currentIndex + 1) % consonants.length;
        return consonants[nextIndex];
    }


}

