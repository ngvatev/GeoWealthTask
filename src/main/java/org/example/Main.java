package org.example;

import java.util.List;
import java.util.Set;

public class Main {

    private static final int WORD_LENGTH = 11;

    // I needed to google the linguistic definition of a word that remain a word after a character has been removed.
    // I was not able to find a suitable name for such words.
    // Until a better name is found, we shall call such words "transformable".
    public static void main(String[] args) {
        Set<String> dictionary = new DictionaryProvider().downloadDictionary();
        dictionary.add("A");
        dictionary.add("I");

        Set<String> transformableWords = new TransformableWordDictionaryBuilder(dictionary).build();

        List<String> list = transformableWords.stream()
            .filter(word -> word.length() == WORD_LENGTH)
            .toList();
        System.out.println(list);
    }
}