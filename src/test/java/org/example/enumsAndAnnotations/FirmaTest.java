package org.example.enumsAndAnnotations;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class FirmaTest {
    private Firma obiectTest;
    private Angajat mockAngajat, mockAngajat1;

    private String mockName = "TW";

    @Before
    public void setUp() throws Exception {
        obiectTest = new Firma(mockName);
        mockAngajat = new Angajat("alex", Gender.MASCULIN);
        mockAngajat1 = new Angajat("ana", Gender.FEMININ);
    }

    @After
    public void tearDown() throws Exception {
        obiectTest = null;
    }


    @ParameterizedTest(name = "{index} => a={0}")
    @MethodSource("sumProvider")
    public void test_addAngajati_withSuccess(Angajat mockAngajat) {
        //when
        obiectTest = new Firma(mockName);
        obiectTest.adaugaAngajat(mockAngajat);

        //then
        assertTrue( obiectTest.getListaAngajati().size()>0);
      //  assertEquals(1, obiectTest.getListaAngajati().size());

    }

    private static Stream<Arguments> sumProvider() {
        return Stream.of(
                Arguments.of(new Angajat("alex", Gender.MASCULIN)),
                Arguments.of(new Angajat("ana", Gender.FEMININ))
        );
    }

    @Test
    public void test_afisareAngajatiDupaSex_withSuccess() {
        //setup
        obiectTest.adaugaAngajat(mockAngajat);
        obiectTest.adaugaAngajat(mockAngajat1);

        //when
        List<Angajat> result = obiectTest.afisareAngajatiDupaSex(Gender.MASCULIN);

        //then
        assertEquals(1, result.size());
    }

    @Test
    public void test_afisareListaOrdonataAlfabetic_withSuccess() {
        //setup
        obiectTest.adaugaAngajat(mockAngajat);
        obiectTest.adaugaAngajat(mockAngajat1);

        //when
        List<Angajat> result = obiectTest.afisareListaOrdonataAlfabetic();

        //then
        assertEquals(2, result.size());
        assertEquals(mockAngajat, result.get(0));

    }
}