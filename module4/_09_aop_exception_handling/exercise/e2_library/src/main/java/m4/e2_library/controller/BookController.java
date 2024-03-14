package m4.e2_library.controller;

import m4.e2_library.model.Book;
import m4.e2_library.model.User;
import m4.e2_library.service.BookService;
import m4.e2_library.service.BorrowService;
import m4.e2_library.service.UserService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import static m4.e2_library.util.CommonUtil.*;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final UserService userService;
    private final BorrowService borrowService;

    public BookController(BookService bookService, UserService userService, BorrowService borrowService) {
        this.bookService = bookService;
        this.userService = userService;
        this.borrowService = borrowService;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "book";
    }

    @PostMapping("/{bookId}")
    public String borrow(@PathVariable("bookId") Book book, User user, RedirectAttributes redirect) {
        redirect.addFlashAttribute("msg", borrowService.borrow(book, user) ? MESSAGE_BORROW_SUCCESS: MESSAGE_BORROW_ERROR);
        return "redirect:/books";
    }

    @PutMapping
    public String brought(@RequestParam String code, RedirectAttributes redirect) throws Exception {
        redirect.addFlashAttribute("msg", borrowService.dueBack(code) ? MESSAGE_BROUGHT_SUCCESS: MESSAGE_BROUGHT_ERROR);
        return "redirect:/books";
    }
}
