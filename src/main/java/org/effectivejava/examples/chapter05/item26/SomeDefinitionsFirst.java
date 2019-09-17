package org.effectivejava.examples.chapter05.item26;

import java.util.List;

public class SomeDefinitionsFirst {

    public static void main(String... args) {
        List.of(
                new Definition().term("Parameterized type").example("List<String>"),
                new Definition().term("Actual type parameter").example("String"),
                new Definition().term("Generic type").example("List<T>"),
                new Definition().term("Formal type parameter").example("T"),
                new Definition().term("Unbounded wildcard type").example("List<?>"),
                new Definition().term("Raw type").example("List"),
                new Definition().term("Bounded type parameter").example("<T extends Number>"),
                new Definition().term("Recursive type bound").example("<T extends Comparable<T>>"),
                new Definition().term("Bounded wildcard type").example("List<? extends Number>"),
                new Definition().term("Generic method").example("static <T> List<T> asList(T[] a)")

        ).stream().forEach(Definition::log);
    }

    static class Definition {
        String word;
        String example;

        Definition term(String word) {
            this.word = word;
            return this;
        }

        Definition example(String example) {
            this.example = example;
            return this;
        }

        void log() {
            System.out.println(word + " ---> " + example);
        }
    }
}
