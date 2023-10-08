package org.example;

public class Main {
    public static void main(String[] args) {

        String encoded1 = "t2st3ng";

        System.out.println("Encoded1: " + encoded1);
        System.out.println("Decoded1: " + Decoder.decodeVowels(encoded1));

        String word = "hello";
        String replacedWord = Decoder.decodeConsonant(word);
        System.out.println("Original word: " + word);
        System.out.println("Word with consonants replaced: " + replacedWord);
    }
}