package org.example.unitTesting;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ContBancarTest {
    private ContBancar contBancarTest;

    @Before
    public void setUp() throws Exception {
        contBancarTest = new ContBancar("1234");
    }

    @After
    public void tearDown() throws Exception {
        contBancarTest = null;
    }

    @Test
    public void test_getCardList_dacaAdaugCard_cardulEsteInLista() {
        Card card = new Card("2345", new Date(), "Mihai P", 1234567890);
        contBancarTest.atasezCard(card);

        List<Card> cardList = contBancarTest.getCardList();
        assertTrue(cardList.contains(card));
    }

    @Test
    public void test_getCardList_ContBancarNuAreCarduriAtasateInitial(){
        List<Card> cardList = contBancarTest.getCardList();
        assertTrue(cardList.isEmpty());
    }

    @Test
    public void test_adaugaBani_pentruParamIntrarePozitiv() {
        contBancarTest.adaugBani(10);
        double suma = contBancarTest.getSum();
        assertEquals(10, suma, 0);
    }

    @Test
    public void test_adaugaBani_pentruParamIntrareNegativ_nuModificaSuma() {
        contBancarTest.adaugBani(-10);
        double suma = contBancarTest.getSum();
        assertEquals(0, suma, 0);
    }

    @Test
    public void test_scoateBanii_modificaSumaDeBaniDinCont() {
        //when
        contBancarTest.adaugBani(100);

        //then
        contBancarTest.scoateBanii(10);
        double suma = contBancarTest.getSum();
        assertEquals(90, suma, 0);
    }
}