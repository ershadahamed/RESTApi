package me.ershad.controller;

import me.ershad.entity.Book;
import me.ershad.model.BookDeletedModel;
import me.ershad.model.BookModel;
import me.ershad.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping
    public List<Book> getAllBook(){
        return bookService.getAllBook();
    }

    @GetMapping("/by/isbln")
    public Book getBookByIsbln(@RequestBody BookModel isbln) {
        return bookService.getBookByIsbln(isbln.getIsbln());
    }

    @DeleteMapping
    public BookDeletedModel deleteBook(@RequestBody BookDeletedModel bookDeletedModel) {
        return bookService.deleteBook(bookDeletedModel);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

}
