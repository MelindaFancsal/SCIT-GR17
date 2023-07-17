package org.example.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PairChallange {
    private static Logger logger = Logger.getLogger(PairChallange.class.getName());

    public static void main(String[] args) {
        logger.info("start main");
        /*Am manusi si sosete. Vreau sa le pun perechi.In cazul in care nu corespund numerele sau culorile la perechi,
        progrmul va returna un mesaj de eroare
         */

        //obiecte: manusa, soseta, le vom pune perechi si vom valida marirea si culoarea

        Manusa manusa1 = new Manusa(20, "verde");
        Manusa manusa2 = new Manusa(21, "rosu");

        Perechi<Manusa> verificaPerechi = new Perechi<>(manusa1, manusa2);
        try {
            verificaPerechi.verifica();
        } catch (PairNotMatchingException e) {
            logger.log(Level.SEVERE, e.getMessage());

            switch (e.getErrorType()) {
                case MARIME -> System.out.println("nu corespund marimile");
                case CULOARE -> System.out.println("nu corespind culorile");
            }
        }

        Soseta soseta1 = new Soseta(39, "negru");
        Soseta soseta2 = new Soseta(39, "negru");

        Perechi<Soseta> verificaSosete = new Perechi<>(soseta1, soseta2);
        try {
            verificaSosete.verifica();
            System.out.println("sunt identice");
        } catch (PairNotMatchingException e) {
            switch (e.getErrorType()) {
                case MARIME -> System.out.println("nu corespund marimile");
                case CULOARE -> System.out.println("nu corespind culorile");
            }
        }

        logger.info("end main");
    }
}
