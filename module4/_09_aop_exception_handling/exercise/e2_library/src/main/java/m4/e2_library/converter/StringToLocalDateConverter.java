/*
package m4.e2_library.converter;

import m4.e2_library.util.CommonUtil;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class StringToLocalDateConverter implements Converter<String, LocalDate> {
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(CommonUtil.DATE_FORMAT);
    @Override
    public LocalDate convert(String source) {
        if (source.isEmpty()) {
            return null;
        }

        try {
            return LocalDate.parse(source, dateFormatter);
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException("invalid date format. Please use this pattern\""
                    + CommonUtil.DATE_FORMAT + "\"");
        }
    }
}
*/
