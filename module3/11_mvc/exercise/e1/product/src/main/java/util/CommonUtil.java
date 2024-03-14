package util;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtil {
    public static int toInt(String val){
//        Pattern pattern= Pattern.compile("\\d+(\\.\\d+)?");
//        Matcher matcher= pattern.matcher("");
//        return Optional.ofNullable(val).filter(f-> !f.isEmpty() && matcher.matches()).map(Integer::parseInt).orElse(0);
        return Optional.ofNullable(val).filter(f-> !f.isEmpty()).map(Integer::parseInt).orElse(0);
    }
}
