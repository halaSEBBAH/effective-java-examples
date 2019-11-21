package org.effectivejava.examples.chapter03.item10;

import org.effectivejava.examples.chapter03.old.item08.Color;

import java.util.Objects;

public class Equals_TransitivityViolation {

    class Point {
        final int x;
        final int y;

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
            if (!(o instanceof Point)) return false;

            // If o is a normal Point, do a color-blind comparison
            if (!(o instanceof ColorPoint)) return o.equals(this);

            // o is a ColorPoint; do a full comparison
            return super.equals(o) && ((ColorPoint) o).color == color;
        }




    // because: ColorPoint(0, 0, red) ##  Point(0, 0) ## ColorPoint(0, 0, green)
    }

    // Solution
    public class ColoredPoint {
        private final Point point;
        private final Color color;

        public ColoredPoint(int x, int y, Color color) {
            this.point = new Point(x, y);
            this.color = Objects.requireNonNull(color);
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof ColoredPoint)) {
                return false;
            }
            ColoredPoint cp = (ColoredPoint) o;
            return cp.point.equals(point) && cp.color == color;
        }
    }
}
