package com.cisco.repository;

import com.cisco.entity.Book;
//import com.cisco.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
@EnableElasticsearchRepositories(basePackages = "com.cisco.repository")
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {

    List<Book> findById(int id);
    void deleteById(int id);
    //List<Book> findAllBook();
//
//    List<Book> findByNameOrPrice(String name, Float price);
//
//    @Query("{\"bool\" : {\"must\" : {\"term\" : {\"price\" : \"?0\"}}}}")
//    Page<Book> findByPrice(Float price, Pageable pageable);
}
