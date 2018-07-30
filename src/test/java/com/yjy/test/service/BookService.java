package com.yjy.test.service;

import com.yjy.test.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * {@code @Autowired}: 先按类型，后按名称
 */
@Service
public class BookService {

    //    @Qualifier("bookDao")
    @Autowired
    private BookDao bookDao;

//    @Autowired
//    private BookDao bookDao2;

    public void print() {
        System.out.println(bookDao);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BookService{");
        sb.append("bookDao=").append(bookDao);
        sb.append('}');
        return sb.toString();
    }

//    @Override
//    public String toString() {
//        final StringBuilder sb = new StringBuilder("BookService{");
//        sb.append("bookDao2=").append(bookDao2);
//        sb.append('}');
//        return sb.toString();
//    }

}
