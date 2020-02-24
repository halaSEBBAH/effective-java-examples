package org.effectivejava.examples.chapter06.item34;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Season {

    // Not good
    static final String AUTUMN = "autumn";
    static final String WINTER = "winter";
    static final String SPRING = "spring";
    static final String SUMMER = "summer";

    public static void main(String... args) {
        List<Seasons> seasons = List.of(Seasons.AUTUMN, Seasons.SPRING, Seasons.SUMMER, Seasons.WINTER);
        seasons.stream().sorted().forEach(System.out::println);

        Map<String, Seasons> values = new HashMap<>();

        for (Seasons s : Seasons.values()) {
            values.put(s.toString(), s);
        }
    }


    // Recommended
    enum Seasons {
        AUTUMN("AU"), WINTER("AU"), SPRING("AU"), SUMMER("AU");


        String code;
        Seasons(String code) {
            this.code = code;
        }
        // Bonus: Enum constructors aren’t permitted to access the enum’s static fields.
        // This restriction is necessary because static fields have not yet been initialized
        // when enum constructors run.

        /**

         private static final Map<String, Seasons> values = new HashMap<>();

         Seasons(String code) {
         values.put(code, this);
         }

         public static Seasons from(String code) {
         values.get(code);
         }
         **/
    }


}
