package org.effectivejava.examples.chapter02.item06;

public class AvoidCreatingUnnecessaryObjects {
    void stringLitteral() {
        String hello = new String("Hello");
    }

    void booleanLitteral() {
        Boolean b = new Boolean("true");
    }

    void patternRecompilation(String input) {
        String regex = "^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$";
        input.matches(regex);
    }

    void boxingPrimitives() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
    }
}
