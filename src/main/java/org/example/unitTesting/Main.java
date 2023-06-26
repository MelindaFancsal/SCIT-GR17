package org.example.unitTesting;

import java.util.prefs.BackingStoreException;

public class Main {

    /*
    O persoana are mai multe carduri. Se duce la un bancomat si doreste sa extraga o anumita suma de pe cardul de BT.
    In situatia in care nu are banii pe card, POS ul ii va returna o chitanta cu mesajul "Nu aveti suficienti bani". In
    cazul in care are banii pe card, pe chitanta se va afisa mesajul "Ati retras suma x, Mai aveti pe card suma y"

    Pas1 - obiecte:
     - Card, Bancomat, ContBancar, Chitanta, Persoana
     Pas 2:
     - compozitie
     */

    public static void main(String[] args) {

        Banca banca = new Banca("BT");
     //   banca.clienti
    }
}
