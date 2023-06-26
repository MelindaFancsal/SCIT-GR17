package org.example.unitTesting;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.swing.event.CaretListener;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class PosTestV2 {
    private Pos posTest;
    private Banca mockedBanca;

    @Before
    public void setUp() throws Exception {
        mockedBanca = Mockito.mock(Banca.class);
        posTest = new Pos();
        posTest.cunoasteBanca(mockedBanca);
    }

    @After
    public void tearDown() throws Exception {
        posTest = null;
    }

    @Test
    public void test_getListaBancaCunoscute_areClienti() {
        //when

        //then
       assertTrue(posTest.getListaBancaCunoscute().size()==1);

    }
    @Test
    public void test_scoateBani_nuReturneazaNimicDacaCardBancaNuEInListaBanciPOS() {
        //when
        Persoana persoana = new Persoana("Mihai");
        persoana.addContBancar(new ContBancar("1234"));
        when(mockedBanca.getClienti()).thenReturn(List.of(persoana));

        Card card = new Card("8907", new Date(), "Mihai", 1234567);

        //then
        Chitanta chitanta = posTest.scoateBani(card, 10);
        assertTrue(chitanta.getMesaj().isEmpty());

    }

}
