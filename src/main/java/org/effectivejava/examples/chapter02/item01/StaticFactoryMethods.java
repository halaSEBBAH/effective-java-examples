package org.effectivejava.examples.chapter02.item01;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.time.Instant;
import java.util.*;
import java.util.stream.Stream;

class StaticFactoryMethods {

    class Advantages {

        void theyHaveNames() {
            BigInteger prime = BigInteger.probablePrime(3, new Random());
        }

        void controlInstanciation() {
            Set<Object> set = Collections.emptySet();
        }

        void hideSubtypes() {
            Set<Object> set1 = Collections.unmodifiableSet(new HashSet<>());
            Set<Object> set2 = Collections.synchronizedSet(new HashSet<>());

            // Performance concern: return an internal implementation depending on enum size
            EnumSet<Season> seasons = EnumSet.of(Season.SPRING, Season.SUMMER);
        }
    }

    class Limitations {
        void cannotSubclass() {
            //  no way to subclass: Collections.SynchronizedSet ...
        }
    }

    class Usage {
        void commonNames() {
            //from() -conversion-
            Date date = Date.from(Instant.now());

            //of() -aggregation-
            Stream<String> greeting = Stream.of("hello", "world");

            //create / newInstance() - create a new instance -
            Object usage = Array.newInstance(Usage.class);

            //type() -on companion class-
            List<Object> litany = Collections.list(new StringTokenizer(""));

        }
    }

    enum Season {
        AUTUMN, WINTER, SPRING, SUMMER
    }
}
