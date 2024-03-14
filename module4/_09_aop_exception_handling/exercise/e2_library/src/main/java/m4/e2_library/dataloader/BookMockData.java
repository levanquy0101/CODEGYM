package m4.e2_library.dataloader;

import m4.e2_library.model.Book;
import m4.e2_library.service.BookService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BookMockData implements ApplicationListener<ContextRefreshedEvent> {
    private final BookService bookService;

    public BookMockData(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(event.getApplicationContext().getParent() == null){
            if(bookService.findAll().isEmpty()){
                for (int i = 1; i < 5; i++) {
                    Book book = new Book();
                    book.setTitle("title"+ i);
                    book.setPreface("preface" +i);
                    book.setQuantity(i);
                    book.setAuthor("author"+i);
                    book.setImgUrl("imgUrl"+i);
                    book.setPublishedOn(LocalDate.now());
                    bookService.save(book);
                }
            }
        }
    }
}
