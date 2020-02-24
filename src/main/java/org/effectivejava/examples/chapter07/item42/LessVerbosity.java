package org.effectivejava.examples.chapter07.item42;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LessVerbosity {

    public static void main(String... args) {
        anonymousDeclaration();
        conciseDeclaration();
    }

    private static void anonymousDeclaration() {
        Collections.sort(List.of("CCC", "AAA", "EEE", "BBB"), new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    private static void conciseDeclaration() {
        List.of("CCC", "AAA", "EEE", "BBB").sort(Comparator.naturalOrder());
    }
}
