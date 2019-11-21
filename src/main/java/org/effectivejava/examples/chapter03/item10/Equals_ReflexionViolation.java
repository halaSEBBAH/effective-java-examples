package org.effectivejava.examples.chapter03.item10;

import java.util.Objects;

public class Equals_ReflexionViolation {

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
