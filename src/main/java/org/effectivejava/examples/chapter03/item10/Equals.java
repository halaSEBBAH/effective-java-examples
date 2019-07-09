package org.effectivejava.examples.chapter03.item10;

import java.util.Objects;

public class Equals {
    class ReflexivityViolation {
        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }

    class SymetryViolated {

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
        }
    }

    class TransitivityViolated {
        class Point {
            private final int x;
            private final int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object o) {
                if (!(o instanceof Point))
                    return false;
                Point p = (Point) o;
                return p.x == x && p.y == y;
            }
        }


        class ColorPoint extends Point {
            private final String color;

            public ColorPoint(int x, int y, String color) {
                super(x, y);
                this.color = color;
            }

            // Broken - violates transitivity!
            @Override
            public boolean equals(Object o) {
                if (!(o instanceof Point))
                    return false;
// If o is a normal Point, do a color-blind comparison
                if (!(o instanceof ColorPoint))
                    return o.equals(this);
// o is a ColorPoint; do a full comparison
                return super.equals(o) && ((ColorPoint) o).color == color;
            }
        }
    }

    // ColorPoint(0, 0, red) ##  Point(0, 0) ## ColorPoint(0, 0, green)

}
