package org.effectivejava.examples.chapter03.item10;

import java.util.Objects;

public class Equals_SymmetryViolation {

    class CaseInsensitiveString {
        private final String value;

        public CaseInsensitiveString(String s) {
            this.value = Objects.requireNonNull(s);
        }

        // Broken - violates symmetry!
        @Override
        public boolean equals(Object o) {
            if (o instanceof CaseInsensitiveString) {
                return value.equalsIgnoreCase(((CaseInsensitiveString) o).value);

            }
            if (o instanceof String) {
                return value.equalsIgnoreCase((String) o);
            }
            return false;
        }

        // Mitigation
        public boolean workaround_equals(Object o) {
            if (o instanceof CaseInsensitiveString) {
                return value.equalsIgnoreCase(((CaseInsensitiveString) o).value);
            }

            return false;
        }
    }
}
