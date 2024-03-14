package m4.e2_library.exeception;

public class BookBorrowException extends RuntimeException {
    public BookBorrowException(String message) {
        super(message);
    }
}
