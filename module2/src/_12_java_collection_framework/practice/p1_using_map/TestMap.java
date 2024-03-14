package _12_java_collection_framework.practice.p1_using_map;

import java.util.*;

public class TestMap {
    public static void main(String[] args) {
//        When there is no need to maintain any order of elements and we are working on single threaded environment. (best-performance)
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Smith", 30);
        hashMap.put("Anderson", 31);
        hashMap.put("Lewis", 29);
        hashMap.put("Cook", 29);
        System.out.println("Display entries in HashMap");
        System.out.println(hashMap);

//        Use LinkedHashMap: When there is a need to maintain insertion order of elements and we are working on single threaded environment
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 31);
        linkedHashMap.put("Lewis", 29);
        linkedHashMap.put("Cook", 29);
        System.out.println("Display entries in insertion order of key");
        System.out.println(linkedHashMap);

//        Use TreeMap: When there is a need to maintain ascending order of elements and we are working on single threaded environment
        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("Display entries in ascending order of key");
        System.out.println(treeMap);

//        Descending Order or Reverse Order Map
        Map<String, Integer> reverseTreeMap = new TreeMap<>(Comparator.reverseOrder());
        reverseTreeMap.putAll(hashMap);
        System.out.println(reverseTreeMap);

        System.out.println("\nThe age for " + "Lewis is " + linkedHashMap.get("Lewis"));
    }
}
