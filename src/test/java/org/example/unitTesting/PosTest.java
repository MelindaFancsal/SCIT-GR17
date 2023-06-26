package org.example.unitTesting;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class PosTest {
    private Pos posTest;

    @Before
    public void setUp() throws Exception {
        CardMocked cardMocked = new CardMocked("1234", new Date(), "Mihai", 1234567890 );
        ContBancarMocked contBancarMocked = new ContBancarMocked("1234");
        contBancarMocked.adaugBani(100);
        contBancarMocked.atasezCard(cardMocked);

        Persoana mockedPersoana = new PersoanaMocked("Mihai");
        mockedPersoana.addContBancar(contBancarMocked);

        Banca mockedBanca = new BancaMocked("BT", Arrays.asList(mockedPersoana));
        posTest = new Pos();
        posTest.cunoasteBanca(mockedBanca);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void test_getListaBancaCunoscute_nuEsteGoala(){
      assertEquals(1, posTest.getListaBancaCunoscute().size());
    }

    @Test
    public void test_scoateBani_nuReturneazaNimicDacaCardBancaNuEInListaBanciPOS() {
        //when
        Card card = new Card("8907", new Date(), "Mihai", 1234567);

        //then
        Chitanta chitanta = posTest.scoateBani(card, 10);
        assertEquals(new Chitanta(),chitanta);
    }


    @Test
    public void test_scoateBani_returneazaChitanta() {
        //when
        Card card = new Card("1234", new Date(), "Mihai", 1234567890);

        //then
        Chitanta chitanta = posTest.scoateBani(card, 10);
        String mesaj = "10 90.0";
        assertEquals(mesaj,chitanta.getMesaj());
    }


    private static class BancaMocked extends Banca {

        public BancaMocked(String nume, List<Persoana> persoanaMockeds) {
            super(nume);
            this.clienti = persoanaMockeds;
        }
    }

    private static class PersoanaMocked extends Persoana {

        public PersoanaMocked(String nume) {
            super(nume);
        }
    }

    private static class ContBancarMocked extends ContBancar {

        public ContBancarMocked(String iban) {
            super(iban);
        }
    }

    private static class CardMocked extends Card {

        public CardMocked(String iban, Date expirationDate, String nume, int numarCard) {
            super(iban, expirationDate, nume, numarCard);
        }
    }


}