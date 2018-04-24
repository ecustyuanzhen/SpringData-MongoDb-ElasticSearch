package com.cisco.dao;

import com.cisco.entity.Book;
import com.cisco.repository.BookRepository;
import org.elasticsearch.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-context.xml"})
public class MyTest {

    @Resource
    private BookRepository bookRepository;
    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;

    @Resource
    MongoRepository mongoRepository;

    /**
     * 测试mongo的mongotempt和mongorepository方法；
     * mongo版本3.2.19      通过
     */
//    @Test
//    public void testMongo(){
//
//        Person person1 = new Person(1,"zhenghaiyong",25);
//        mongoRepository.insert(person1);
//        System.out.println(personMogoImpl.findForRequery(1).get(3));
//
//    }

    /**
     * 测试elasticsearch的elasticsearchtempt和elasticsearchrepository方法；
     * elasticsearch版本1.4.4  通过
     */
    @Test
    public void testElasticSearch(){

        /**
         * 使用tempt单个插入、批量插入
         */
//        List<IndexQuery> queryList = new ArrayList<IndexQuery>();
//        for (int i=1;i<100;i++){
//            Book book = new Book(i,"book"+i);
//            IndexQuery indexQuery = new IndexQueryBuilder().withId(book.getId()).withObject(book).withIndexName("book").withType("book").build();
//            queryList.add(indexQuery);
//        }
//        elasticsearchTemplate.bulkIndex(queryList);
//        Book book = new Book(1,"yuanz");
//        IndexQuery indexQuery = new IndexQueryBuilder().withId(book.getId()).withObject(book).withIndexName("bookindex").withType("book").build();
//        elasticsearchTemplate.index(indexQuery);
//        List<Book> list = bookRepository.findById(1);
//        System.out.println(bookRepository.findById(1).get(0));
        /**
         * 使用repository批量插入
         */
        List<Book> list = new ArrayList<Book>();
        for(int i=1;i<100;i++){
            Book book = new Book(i,"book"+i);
            list.add(book);
        }
        bookRepository.save(list);
    }

    @Test
    public void testMongoEs(){
        /**
         * 测试elasticsearch和mongoDb数据互传
         */
        Iterable<Book> iterable =  bookRepository.findAll();  //查找elasticsearch里面所有数据
        List<Book> list = Lists.newArrayList(iterable);
        mongoRepository.save(list);
        list = mongoRepository.findAll();//查找mongo里所有数据
        bookRepository.save(list);
    }
}