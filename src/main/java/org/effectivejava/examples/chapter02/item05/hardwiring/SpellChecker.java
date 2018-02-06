package org.effectivejava.examples.chapter02.item05.hardwiring;

import org.effectivejava.examples.chapter02.item05.Lexicon;

import java.util.List;

public class SpellChecker {

    private final Lexicon dictionary = new Lexicon();

    private SpellChecker() {
        // Noninstantiable
    }


    public boolean isValid(String word) {
        return dictionary.isValid(word);
    }

    public List<String> suggestions(String typo) {
        return dictionary.suggestions(typo);
    }
}
