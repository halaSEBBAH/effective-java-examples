package org.effectivejava.examples.chapter07.item42;


import java.util.function.DoubleBinaryOperator;

public enum BasicOperation {
    // Without lambdas, we have to rewrite "apply" method for each symbol

    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String symbol;
    private final DoubleBinaryOperator operator;

    BasicOperation(String symbol, DoubleBinaryOperator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public double apply(double x, double y) {
        return operator.applyAsDouble(x, y);
    }


}
