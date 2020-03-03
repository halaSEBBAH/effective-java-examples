package org.effectivejava.examples.chapter10.item69;

public class ExceptionGuidelines {

    public static void main(String... args) {
        neverUseExceptionForControlFlow();
    }

    private static void neverUseExceptionForControlFlow() {
        // Horrible abuse of exceptions.
        Object[] data = new Object[10];
        try {
            int i = 0;

            while (true) {
                Object o = data[i++];
                //do something;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }
}
