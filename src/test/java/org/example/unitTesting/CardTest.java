package org.example.unitTesting;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class CardTest {
    private Card cardTest;

    @Before
    public void setUp() throws Exception {
        String date_string = "26-08-2023";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse(date_string);
        cardTest = new Card("1234", date, "Mihai Popescu", 12345678);
    }

    @After
    public void tearDown() throws Exception {
        cardTest = null;
    }

    @Test
    public void test_cardCareIban() {
        assertEquals("1234", cardTest.getIban());
        //   assertNotNull(cardTest.getIban());
    }

    @Test
    public void test_cardValid() {
        assertTrue(cardTest.esteValid(new Date()));
    }

    @Test
    public void test_cardNuEsteValid() throws ParseException {
        String date_string = "26-04-2023";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse(date_string);
        cardTest = new Card("1234", date, "Mihai Popescu", 12345678);

        assertFalse(cardTest.esteValid(new Date()));
    }
}