package com.api.book.bootrestbook.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.Dao.BookRepository;
import com.api.book.bootrestbook.model.Book;

@Component
public class BookService {
    
    // private static List<Book> list = new ArrayList<>();

    // static{

    //     list.add(new Book(10,"book1", "axc"));
    //     list.add(new Book(12,"book2", "abd"));
    //     list.add(new Book(13,"book3", "jkd"));
    //     list.add(new Book(16,"book4", "hjdj"));

    // }

    @Autowired
    private BookRepository bookRepository;
    //getting the book data
    public List<Book> getAllBooks(){
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }
    public Book getBookById(int id){
        Book book = null;
        try {
            book = bookRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    //adding the book
    public Book addBook(Book b){
        Book book = this.bookRepository.save(b);
        return book;
    }

    // deleting the book data
    public void deletedBook(int bid){
        bookRepository.deleteById(bid);
    }

    //updating book data
    public void updateBook(Book book, int id){
        book.setId(id);
        bookRepository.save(book);
    }

}
