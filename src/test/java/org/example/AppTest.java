package org.example;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.example.App.squareTwoNumbers;
import static org.example.App.sumNumber;
import static org.testng.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {

    public void currentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }

    @BeforeClass
    void beforeClass() {
        System.out.println("Before class");
        currentTime();
    }
    @AfterClass
    void afterClass() {
        System.out.println("After class");
        currentTime();
    }
    //тут напишем тест с Датапровайдерами
    @DataProvider (name = "sumProvider")
    Object [][] DataProvider () {
        return new Object[][] {
                {10, 30, 40},
                {0, 0, 0},
                {-10, 10, 0}
        };
    }
    @DataProvider (name = "squareProvider")
    Object [][] squareDataProvider () {
        return new Object[][] {
                {2, 4},
                {1, 1},
                {-1, 1},
                {0, 0}
        };
    }
    @Test (dataProvider = "squareProvider")
    void testSquare (int first, int expected) {
        int square = squareTwoNumbers(first);
        System.out.println(square);
        assertEquals(square, expected);
    }

    //сейчас напишем тест, который проверяет, что метот AppTest корректно складывает числа
    @Test (dataProvider = "sumProvider")
     void testSum( int arg1, int arg2, int expected){
        int sum = sumNumber(arg1, arg2);
        System.out.println(sum);
        assertEquals(sum, expected);
    }


}
