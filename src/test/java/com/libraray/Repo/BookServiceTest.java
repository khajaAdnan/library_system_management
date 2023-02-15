package com.libraray.Repo;

import com.libraray.model.Book;
import com.libraray.repository.BookRepo;
import com.libraray.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepo bookRepo;

    private BookService bookService;

    @BeforeEach
    void setUp(){
        this.bookService = new BookService(this.bookRepo);
    }

    @Test
    void getAllBooks() {
        bookService.getAllBooks();
        verify(bookRepo).findAll();
    }
    @Test
    void getBookById(){
        bookService.getBookById(UUID.fromString("61c53992-f0aa-4592-9740-70f7a0de5aa5"));
        assertThat(bookRepo.findById(UUID.fromString("61c53992-f0aa-4592-9740-70f7a0de5aa5")));
    }

    @Test
    void addBook(){
        Book book = new Book();
        book.setBookName("xyz");
        book.setAuthor("yhef");
        book.setSubject("serg");
        book.setStandard("3");
        book.setIssued(true);
        when(bookRepo.save(book)).thenReturn(book);
        assertEquals(book,bookService.addBook(book));
    }

    @Test
    void deleteBook(){
        Book book = new Book();
        book.setBookName("jseh");
        bookService.deleteBook(book.getId());
        verify(bookRepo , times(1)).deleteById(book.getId());
    }

    
}
