package com.libraray.controller;

import com.libraray.model.Book;
import com.libraray.model.LibraryHis;
import com.libraray.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/get/all/books")
    public List<Book> getAllBook() {
        return bookService.getAllBooks();
    }

    @GetMapping("/get/book/{id}")
    public Optional<Book> getByBookId(@PathVariable UUID id) {
        return Optional.ofNullable(bookService.getBookById(id));
    }

    @PostMapping("/add/book")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping("/update/book")
    public Book updateBook(@RequestBody Book book){

        return bookService.updateBook(book);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable UUID id){
        bookService.deleteBook(id);
    }

    @PutMapping("/issue/book")
    public LibraryHis issueBook(@RequestParam UUID bookId, @RequestParam UUID studentId, @RequestParam String date) throws  ParseException {
        DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date returnDate = sdf.parse(date);
        return bookService.issueBook(bookId,studentId,returnDate);
    }

}



