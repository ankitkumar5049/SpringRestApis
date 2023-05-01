package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.model.Book;

@Component
public class BookService {
    
    private static List<Book> list = new ArrayList<>();

    static{

        list.add(new Book(10,"book1", "axc"));
        list.add(new Book(12,"book2", "abd"));
        list.add(new Book(13,"book3", "jkd"));
        list.add(new Book(16,"book4", "hjdj"));

    }

    //getting the book data
    public List<Book> getAllBooks(){
        return list;
    }
    public Book getBookById(int id){
        Book book = null;
        book = list.stream().filter(e->e.getId()==id).findFirst().get();
        return book;
    }

    //adding the book
    public Book addBook(Book b){
        list.add(b);
        return b;
    }

    // deleting the book data
    public void deletedAllBooks(){
        list.clear();
    }
    public void deletedBook(int bid){
        list = list.stream()
                .filter(book->book.getId()!=bid).
                collect(Collectors.toList());
    }

    //updating book data
    public void updateBook(Book book, int id){
        list = list.stream().map(b->{
            if(b.getId()==id){
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }

}
