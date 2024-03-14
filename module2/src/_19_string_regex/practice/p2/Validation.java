package _19_string_regex.practice.p2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static final String ACCOUNT_REGEX = "^[_a-z0-9]{6,}$";
    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean isAccount(String val){
        pattern= Pattern.compile(ACCOUNT_REGEX);
        matcher= pattern.matcher(val);
        return matcher.matches();
    }
}
