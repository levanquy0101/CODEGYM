package m4.e2_library.handler;

import m4.e2_library.exeception.BookBorrowException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class BookBorrowExceptionHandler {
    @ExceptionHandler(BookBorrowException.class)
    public ModelAndView errorBorrowPage(BookBorrowException e) {
        return new ModelAndView("/error", "message", e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView errorBroughtPage(Exception e) {
        return new ModelAndView("/error","message", e.getMessage());
    }
}
