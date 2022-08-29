package me.ershad.service;

import me.ershad.entity.Book;
import me.ershad.model.BookDeletedModel;
import me.ershad.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    public List<Book> getAllBook() {
        return bookRepo.findAll();
    }

    public Book getBookByIsbln(String isbln) {
        return bookRepo.findByIsbln(isbln);
    }

    public BookDeletedModel deleteBook(BookDeletedModel bookDeletedModel) {
        Optional<Book> book = bookRepo.findById(bookDeletedModel.getId());
        BookDeletedModel bdm = new BookDeletedModel();
        bdm.setId(book.get().getId());
        bdm.setMsg("Book deleted");
        bdm.setTitle(book.get().getTitle());
        bookRepo.deleteById(bookDeletedModel.getId());
        return bdm;
    }

    public Book updateBook(Book book) {
        return bookRepo.save(book);
    }
}
