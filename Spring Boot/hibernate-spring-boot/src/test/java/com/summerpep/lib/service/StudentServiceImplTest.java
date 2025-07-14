package com.summerpep.lib.service;

import com.summerpep.model.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

// this will do autowiring, dependency injection
@SpringBootTest
class StudentServiceImplTest {
    @Autowired
    StudentServiceImpl studentService;

    @Autowired
    ConfigurableApplicationContext context;
    @BeforeEach
    void setUp() {
        studentService=new StudentServiceImpl();
    }

    @AfterEach
    void tearDown() {
        studentService=null;
    }

    @Test
    void testFindById() {
    }

    @Test
    void testAdd() {
    }
}