package _19_string_regex.practice.p2;

import java.util.Arrays;

public class Test {
    public static final String[] validAccount = new String[] { "123abc_", "_abc123", "______", "123456","abcdefgh" };
    public static final String[] invalidAccount = new String[] { ".@", "12345", "1234_", "abcde" };

    public static void main(String[] args) {
        Arrays.asList(validAccount).forEach(e->System.out.println(e+ " is "+ Validation.isAccount(e)));
        Arrays.asList(invalidAccount).forEach(e->System.out.println(e+ " is "+ Validation.isAccount(e)));
    }
}
