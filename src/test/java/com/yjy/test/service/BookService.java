package com.yjy.test.service;

import com.yjy.test.dao.BookDao;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * {@code @Autowired}: 先按类型，后按名称，支持@Primary注解和required属性<br>
 * {@code @Resource}: 可指定byName或者byType<br>
 * {@code @Inject}: 和@Autowired类似，不同的是不支持required属性<br>
 */
@Service
public class BookService {

//    @Qualifier("bookDao")
//    @Autowired
//    private BookDao bookDao;

//    @Autowired
//    private BookDao bookDao2;

//    @Resource
//    private BookDao bookDao;

    @Inject
    private BookDao bookDao;

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
