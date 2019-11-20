package org.effectivejava.examples.chapter05.item26;



import java.util.*;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;


public class AvoidRawDeclaration {

    public static void main(String... args) {
        examples().avoid_raw_type_declaration_example1();
        examples().avoid_raw_type_declaration_example2();
        examples().rare_cases_where_you_must_use_raws();

        String[] chain = (String[]) new Object[10];
    }


    private static AvoidRawDeclaration examples() {
        return new AvoidRawDeclaration();
    }

    void avoid_raw_type_declaration_example1() {
        List<String> strings = new ArrayList<>();

        // Uses raw type (List) - fails at runtime!
        unsafeAdd(strings, 42);
        // String s = strings.get(0);  code not safe, Cast Exception
    }

    void avoid_raw_type_declaration_example2() {
        // First thing, unsafeIntersect(...) signature is not restrictive.
        // e.g it accepts two sets with different nature
        unsafeUnion(Set.of("0", "1"), Set.of(FALSE, TRUE));
    }

    private void rare_cases_where_you_must_use_raws() {
        // cannot use class tokens : List<String>.class or List<?>.class
        Class<List> listClass = List.class;

        Collection empty = Collections.EMPTY_SET;
        // cannot use instanceof with generic types. e.g. "empty instanceof Set<Integer>"
        // Legitimate use of raw type - instanceof operator
        if (empty instanceof Set) { // Raw type
            Set<?> s = (Set<?>) empty; // Wildcard type
        }

    }

    private Set unsafeUnion(Set s1, Set s2) {
        // Not safe since you can put anything in s1/s2
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
        // Right alternative: <T> unsafeUnion(Set<T> s1, Set<T> s2)
    }

    private void unsafeAdd(List list, Object o) {
        list.add(o);
    }
}
