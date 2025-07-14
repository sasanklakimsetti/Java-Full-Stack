package com.summerpep.algo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyPasswordAlgoTest {

    MyPasswordAlgo algo;

    @BeforeEach
    void setUp() {
        algo=new MyPasswordAlgo();
    }

    @AfterEach
    void tearDown() {
        algo=null;
    }

    @Test
    void testEncrypt() {
        String password="Password@Springboot";
        String actual=algo.encrypt(password);
        String expected= String.valueOf(new StringBuilder(password).reverse());
        assertEquals(expected,actual);
    }
}