package m4.e2_library.service;

import m4.e2_library.model.Book;
import m4.e2_library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }
}
