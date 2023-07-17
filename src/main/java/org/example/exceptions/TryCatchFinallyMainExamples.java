package org.example.exceptions;

import java.io.IOException;

public class TryCatchFinallyMainExamples {
    public static void main(String[] args) {
        //afisarea in luni a varstei
        //  exampleAgeInMonths();
        //exemplu didactic
        //NOTE!! ATENTIE intre cele doua cuvinte cheie: throw si throws!!
       // System.out.println(didacticExampleFinally());

        errorExample();
        checkedException();
        uncheckedException();

    }

    private static void errorExample() {
        //Error o sublasa a Throwable care indica probleme serioase ce nu trebuie prinse (pronleme de memorie sau stackoverflow)
    }

    private static void uncheckedException() {
        Integer a = null;
        Integer b = 5;

        Integer sum = a+b;
    }

    private static void checkedException() {
        try {
            readFromFile();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void readFromFile() throws IOException {
        throw new IOException("eroare fisier");
    }

    private static int didacticExampleFinally() {
        try {
            System.out.println("Beginning of try");
            throw new RuntimeException();
            //    System.out.println("End of try");
            //   return 1;
        } catch (RuntimeException e) {
            System.out.println("Inside catch");
            return 2;
        } finally {
            System.out.println("Inside finally");
            return 3; //not a good idea to have return in finally block. This block is used for close connection; reset objecss
        }
    }

    private static void exampleAgeInMonths() {
        try {
            ageInMonths(-1);
        } catch (NumberFormatException e) {
            System.out.println("first program argument needs to be an int");
        } catch (IllegalArgumentException e) {
            System.out.println("exception occured: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("runtime exception: " + e.getMessage());
        }
    }


    private static int ageInMonths(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("age should be >0");
        }

        return age * 12;
    }
}
