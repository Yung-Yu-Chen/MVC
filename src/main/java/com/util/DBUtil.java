package com.util;

import com.bean.Book;
import java.util.HashMap;
import java.util.Map;

public class DBUtil {
    private static Map<String, Book> books=new HashMap<>();
    static {
        books.put("1",new Book("1","java leaning",20,"Bob"));
        books.put("2",new Book("2","python leaning",40,"Ted"));
        books.put("3",new Book("3","baseball leaning",22,"Ryan"));
        books.put("4",new Book("4","coffee leaning",44,"Tim"));
    }
    public static Map<String,Book> finaAllBook(){
        return books;
    }
    public static Book finaBookById(String id){
        return books.get(id);
    }
}
