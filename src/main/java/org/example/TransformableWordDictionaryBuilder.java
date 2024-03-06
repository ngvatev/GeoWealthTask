package org.example;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class TransformableWordDictionaryBuilder {
    private final Set<String> dictionary;

    public TransformableWordDictionaryBuilder(Set<String> dictionary) {
        this.dictionary = dictionary;
    }

    public Set<String> build() {
        Set<String> transformableWordDictionary = new HashSet<>();

        dictionary.stream()
            .sorted(Comparator.comparing((String::length)))
            .filter(word -> hasTransformableSubWord(transformableWordDictionary, word))
            .forEach(transformableWordDictionary::add);

        return transformableWordDictionary;
    }

    private boolean hasTransformableSubWord(Set<String> transfromableWordDictionary, String word) {
        if (word.length() == 1) {
            return true;
        }

        for (int i = 0; i < word.length(); ++i) {
            String subWord = removeCharacter(word, i);
            if (transfromableWordDictionary.contains(subWord)) {
                return true;
            }
        }
        return false;
    }

    private String removeCharacter(String word, int indexToRemove) {
        StringBuilder sb = new StringBuilder(word);
        sb.deleteCharAt(indexToRemove);
        return sb.toString();
    }

}
