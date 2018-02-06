package org.effectivejava.examples.chapter02.item05.resourcefactory;

import org.effectivejava.examples.chapter02.item05.Lexicon;

import java.util.List;
import java.util.function.Supplier;

public class SpellChecker {
    private final Lexicon dictionary;

    //Only  factories is supplied by a third party
    public SpellChecker(Supplier<Lexicon> factory) {
        this.dictionary = factory.get();
    }

    public boolean isValid(String word) {
        return dictionary.isValid(word);
    }

    public List<String> suggestions(String typo) {
        return dictionary.suggestions(typo);
    }
}