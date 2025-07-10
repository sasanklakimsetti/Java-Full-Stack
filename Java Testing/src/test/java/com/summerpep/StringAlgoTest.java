package com.summerpep;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringAlgoTest {
    private StringAlgo obj;
//    This method runs before every test.
//    It ensures that each test has a fresh new StringAlgo object, avoiding any side effects from previous tests.
    @BeforeEach
    void setUp() {
        obj=new StringAlgo();
    }
//    This method runs after every test.
//    It helps clean up the test environment by setting obj to null. (Optional but good practice.)
    @AfterEach
    void tearDown() {
        // Clean-up if needed
        obj=null;
    }

    @Test
    void testShift2Chars() {
        String actual=obj.shift2Chars("hello");
        String expected="llohe";
        assertEquals(expected, actual); // It automatically checks expected vs actual and fails if they don’t match.
        System.out.println("Hello passed");
    }

    @Test
    void testShift2CharsBoundary(){
        String actual=obj.shift2Chars("a1");
        String expected="a1";
        assertEquals(expected, actual);
        System.out.println("a1 passed");
    }
    @Test
    void testShift2CharsException(){
        assertThrows(StringIndexOutOfBoundsException.class,()->{
            String actual=obj.shift2Chars("a");
        });  //It automatically checks that your code throws the right exception under the right conditions.
        System.out.println("a passed");
    }
}
