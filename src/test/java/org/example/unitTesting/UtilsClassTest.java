package org.example.unitTesting;

import org.junit.*;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.*;

public class UtilsClassTest {
    private UtilsClass testObject;

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("before class - usually used to open the connection to db/ server");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");

        testObject = new UtilsClass();
    }

    @Test
    public void test_sum_numere_success() {
        int result = testObject.sum(2,3);
        assertEquals(5, result);
    }

    @Test
    public void test_trimFirstChars_success_if_first_2_chars_AA() {
        String result = testObject.trimFirstChars("AABC");
        assertEquals("BC", result);
    }

    @Test
    public void test_trimFirstChars_success_if_first_word_1_char() {
        String result = testObject.trimFirstChars("D");
        assertEquals("D", result);
    }

    @Test
    public void test_areFirstLastTwoCharsIdentical_success() {
        boolean result = testObject.areFirstLastTwoCharsIdentical("AABAA");
        assertTrue( result);
    }

    @Test
    public void test_areFirstLastTwoCharsIdentical_fails() {
        boolean result = testObject.areFirstLastTwoCharsIdentical("AABCC");
        assertFalse( result);
    }

    @Test
    public void test_retrieveNumberOfEvenElements_success() {
        List<Integer> list = Arrays.asList(2,1,6,5,7,9);

        int result = testObject.retrieveNumberOfEvenElements(list);
        assertEquals(2, result);
    }

    @Test
    public void test_retrieveNumberOfEvenElements_null_list_returns_0() {
        List<Integer> list = null;

        int result = testObject.retrieveNumberOfEvenElements(list);
        assertEquals(0, result);
    }

//    @Test
//    public void metodaTest1() {
//        System.out.println("metodaTest1");
//    }
//
//    @Test
//    public void metodaTest2() {
//        System.out.println("metodaTest2");
//    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
        testObject = null;
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("afterClass usually used to close the connection to db/ server");
    }
}