package com.cisco.mongoDao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-context.xml", "classpath:spring/spring-mongo.xml"})
public class PersonMongoImplTest {
//    @Resource
//    private PersonMongoImpl personMongo;

    @Test
    public void testMongoTemplate() {
    }
}