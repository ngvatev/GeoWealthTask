package org.example;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TransformableWordDictionaryBuilderTest {

    @Test
    void whenHavingSingleCharacterWordsInDictionary_expectItToBePresentInTheDictionary() {
        Set<String> dictionarty = Set.of("QWE", "A", "AS", "I", "ASD");

        Set<String> transformableWordDictionary = new TransformableWordDictionaryBuilder(dictionarty).build();

        assertTrue(transformableWordDictionary.contains("A"));
        assertTrue(transformableWordDictionary.contains("I"));
    }

    @Test
    void whenHavingLongTransformableWordsInDictionary_expectAllTransformableSubWordsToBePresentInTheDictionary() {
        Set<String> transformableWords = Set.of("STARTLING", "STARTING", "STARING", "STRING", "STING", "SING", "SIN", "IN", "I");
        Set<String> nonTransformableWords = Set.of("OTHER", "RANDOM", "WORDS");
        Set<String> dictionarty = new HashSet<>(transformableWords);
        dictionarty.addAll(nonTransformableWords);

        Set<String> transfromableWordDictionary = new TransformableWordDictionaryBuilder(dictionarty).build();

        assertEquals(transformableWords, transfromableWordDictionary);
    }
}