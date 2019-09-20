package org.effectivejava.examples.chapter05.item28;

import java.util.List;
import java.util.Map;

public class PreferCollectionsOverArrays {

    static final int LENGTH = 100;

    public static void main(String... args) {
        examples().arrays_hierarchy_may_lead_to_unsafety();
        examples().cannot_create_array_generic_type();
        examples().unbounded_wildcard_parameter_can_be_used_in_arrays();
    }

    private static PreferCollectionsOverArrays examples() {
        return new PreferCollectionsOverArrays();
    }

    void arrays_hierarchy_may_lead_to_unsafety() {
        // Arrays are covariant (preserve inheritance):
        // i.e. if Child extends Parent, then Child[] extends Parent[].

        Object[] objectArray = new Long[1];
        objectArray[0] = "boom"; // Throws ArrayStoreException

        // Generic Collections are invariant (don't preserve inheritance):
        // i.e. if Child extends Parent, then List<Child> isn't a subtype of List<Parent>.

        // Using Collections, it raises issue at compile time:

        /**
         *  List<Object> numbers = new ArrayList<Number>();
         *  numbers.add("boom");
         */

    }

    void cannot_create_array_generic_type() {
        // Illegal:
        /**
         * new List<E>[];
         * new List<String>[];
         */

        // why? because:
        //  - In generics, type parameter are erased after compilation
        //  - Arrays, however, are reified. It means element type should be kept in byte-code (not erased)
        // Mix of two concepts leads to unsafe code.
        // Example (won't compile):

        /**
         * List<String>[] stringLists = new List<String>[1]; // Illegal, but assume it compiles
         *
         * List<Integer> intList = List.of(42); // Legal
         *
         * Object[] objects = stringLists; // Legal, because arrays are covariant
         *
         *
         * objects[0] = intList; // Legal, because parameter type is erased: objects[0] ( -becomes-> List[]) = intList( -becomes-> List[])
         *
         * String s = stringLists[0].get(0); // Cast Exception !
         */

        // Unsafe : arrays and generics don’t mix well
        Object[] objects = List.of(1, 2).toArray();
        objects[0] = "";

    }

    void unbounded_wildcard_parameter_can_be_used_in_arrays() {
        // Legal
        List<?>[] arrayOfLists = new List<?>[LENGTH];
        Map<?, ?>[] arrayOfMaps = new Map<?, ?>[LENGTH];
    }
}
