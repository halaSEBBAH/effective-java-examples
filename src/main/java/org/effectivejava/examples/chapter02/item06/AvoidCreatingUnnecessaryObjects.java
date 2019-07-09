package org.effectivejava.examples.chapter02.item06;

public class AvoidCreatingUnnecessaryObjects {
    void stringLitteral() {
        // The statement creates a new String instance each time it is executed
        String hello = new String("Hello"); // "Hello"
    }

    void booleanLitteral() {
        // The statement creates a new Boolean instance each time it is executed
        Boolean b = new Boolean("true");
    }



    void patternRecompilation(String input) {
        String regex = "^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$";
        input.matches(regex);
    }

    // Much  slow!
    void boxingPrimitives() {
        long sum = 0;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
    }
}
