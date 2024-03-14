package _19_string_regex.practice.p1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static final String EMAIL_REGEX =   "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static Pattern pattern;
    private Matcher matcher;

    Validation(){
        pattern = Pattern.compile(EMAIL_REGEX);
    }
    boolean isEmail(String val){
        matcher= pattern.matcher(val);
        return matcher.matches();
    }
}
