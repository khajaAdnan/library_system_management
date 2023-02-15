package com.libraray.service;

import com.libraray.model.Book;
import com.libraray.model.LibraryHis;
import com.libraray.repository.BookRepo;
import com.libraray.repository.LibraryHisRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private LibraryHisRepo libraryHisRepo;

//    public BookService(BookRepo bookRepo) {
//        this.bookRepo = bookRepo;
//    }

//    public BookService(LibraryHisRepo libraryHisRepo) {
//        this.libraryHisRepo = libraryHisRepo;
//    }

    public Book addBook(Book book) {
       return bookRepo.save(book);

    }

    public List<Book> getAllBooks(){

        return bookRepo.findAll();
    }

    public Book getBookById(UUID id){

        return bookRepo.findById(id).orElse( null);
    }

    public void deleteBook(UUID id) {
        bookRepo.deleteById(id);
    }


    public Book updateBook(Book book) {
        AtomicReference<Book> bookAtomicReference = new AtomicReference<>();
        Optional<Book> bookOptional = bookRepo.findById(book.getId());
        bookOptional.ifPresent(data -> {
            data.setBookName(book.getBookName());
            data.setAuthor(book.getAuthor());
            data.setStandard(book.getStandard());
            data.setSubject(book.getSubject());
            bookAtomicReference.set(bookRepo.save(data));
        });
        return bookAtomicReference.get();

    }
    public LibraryHis issueBook( UUID bookId,UUID studentId, Date returndate) {
        AtomicReference<Book> bookAtomicReference = new AtomicReference<>();
        Optional<Book> bookOptional = bookRepo.findById(bookId);
        bookOptional.ifPresent(data -> {
            data.setIssued(true);

            bookAtomicReference.set(bookRepo.save(data));
        });
        AtomicReference<LibraryHis> libraryHisAtomicReference = new AtomicReference<>();

        LibraryHis tempObj = new LibraryHis();
        tempObj.setBookId(bookId);
        tempObj.setStudentId(studentId);
        tempObj.setIssueDt(new Date());
        tempObj.setReturnDt(returndate);

        libraryHisRepo.save(tempObj);


        return libraryHisRepo.save(tempObj);
    }
}
