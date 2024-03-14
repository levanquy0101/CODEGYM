package _19_string_regex.exercise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E1_ValidationClassName {
    public static void main(String[] args) {
        String regex = "[CAP]\\d{4}\\w*[GHIKLM]";
//        String regex= "[CAP]\\d{4}\\w*[G|H|I|K|L|M]";
        String className = "P0318G";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(className);
        System.out.println(className + " is " + matcher.matches());
    }
}
