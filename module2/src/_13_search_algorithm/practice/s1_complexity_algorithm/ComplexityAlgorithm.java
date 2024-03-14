package _13_search_algorithm.practice.s1_complexity_algorithm;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ComplexityAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        /*int[] frequentChar = new int[255];
        for (int i = 0; i < inputString.length(); i++) {           //{2}
            *//* Tìm ví trí tương ứng của ký tự trong bảng ASCII *//*
            int ascii = inputString.charAt(i);               //{3}
            *//* Tăng giá trị tần suất *//*
            frequentChar[ascii] += 1;                             //{4}
        }

        int max = 0;                                             //{5}
        char character = (char) 255; *//* empty character *//*      //{6}
        for (int j = 0; j < 255; j++) {                         //{7}
            if (frequentChar[j] > max) {                        //{8}
                max = frequentChar[j];                          //{9}
                character = (char) j;                           //{10}
            }
        }

        System.out.println("The most appearing letter is '" + character + "' with a frequency of " + max + " times");*/

        String[] a = inputString.replace(" ","").toLowerCase().split("");
        TreeMap<Character,Integer> t= new TreeMap<>();
        int tmp=1;
        for (int i = 0; i < a.length; i++) {
            char c= a[i].charAt(0);
            if(!t.containsKey(c)) t.put(c,tmp);
            else {
//                t.replace(c,tmp+ 1);
                t.put(c, tmp+ 1);
            }
        }

        Map.Entry<Character,Integer> r= t.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get();
        System.out.println(r);
    }
}
