package org.example.exceptions.exemple;

import java.io.*;

public class Main {

    /*
    Am un fisier care contine cuvinte. Doresc sa afisez numarul de aparitii ale fiecarui cuvant.
   // Ce trebuie sa facem:
   1) citim din fisier - cuvintele
   2) sa retinem pt fiecare cuvant nr de aparitii
   //v1 array - am pune fiecare cuvant cu nr de aparitii
   //v2 map<k,v> - key cuv - v de cate ori apare
     */

    public static void main(String[] args) throws IOException {
       WordCount wordCount = new WordCount("src/main/resources/words.txt");

   //     System.out.println(wordCount.getCuvantAparitii());
        System.out.println(wordCount.getNrAparitiiOrdonateCrescator());
    }

}
