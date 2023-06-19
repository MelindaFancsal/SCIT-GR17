package org.example.collections;

public class ArrayMain {

    public static void main(String[] args) {

        // afisareElementePareArrayUnidim();
        // afisareElementeArrayBidimens();
        //afisareElementeArrayTridimens();


        initializareSiParcurgereArrayDePersoane();

        Person person = new Hired("Ana", 30, 2000);
     //   person.getSalar();

        Hired hired =  new Hired("Ana", 30, 2000);
      //  hired.getSalar()
    }

    private static void initializareSiParcurgereArrayDePersoane() {
        Person[] persons = new Person[3];
        persons[0] = new Unemployed(30, "Mihai");
        persons[1] = new Hired("Andrei", 35, 2000);
        persons[2] = new Student("UTCN", "Cristi", 20);

        for (Person person: persons) {
            System.out.println(person.getName());
        }

    }

    private static void afisareElementeArrayTridimens() {
       int[][][] array = new int [2][2][2];
               //{
//                 {{1, 2, 3}, {5, 6, 7}, {8, 9, 10}},
//                {{11, 12, 13}, {14, 15, 17}, {18, 19, 20}}
//        };

        array[0][0][0] = 1;
        array[0][0][1] = 2;

        array[0][1][0] = 4;
        array[0][1][1] = 5;

        array[1][0][0] = 6;
        array[1][0][1] = 7;

        array[1][1][0] = 8;
        array[1][1][1] = 9;


        for (int i=0; i<= array.length-1; i++) {
            System.out.println("index i : " + i);

           // int [][] arrayJ = array[i];
            for (int j=0; j<=array[i].length-1; j++) {
                System.out.println("index j: "+ j);

             //   int [][] arrayK = array[j];
                for (int k = 0; k<=array[j].length-1; k++) {
                    System.out.println("index k "+ k);

                    System.out.println(array[i][j][k]);
                }
            }
        }
    }

    private static void afisareElementeArrayBidimens() {
        int[][] matrice = new int[2][3];
        matrice[0][0] = 1;
        matrice[0][1] = 2;
        matrice[0][2] = 3;
        matrice[1][0] = 4;
        matrice[1][1] = 5;
        matrice[1][2] = 6;

        for (int i = 0; i <= matrice.length - 1; i++) {
            System.out.println("------------Linia : --------" + i);

            int[] arrayDePeLiniaX = matrice[i];
            for (int j = 0; j <= arrayDePeLiniaX.length - 1; j++) {
                System.out.println("coloana: " + j);

                System.out.println(matrice[i][j]);

            }

        }

    }

    private static void afisareElementePareArrayUnidim() {
        int[] arrayUnidimen = {
                1, 2, 3, 4
        };

        //1) doresc afisarea elementelor de pe pozitia para din array
        int i = 0;
        while (i < arrayUnidimen.length) {
            if (i % 2 == 0) {
                System.out.println(arrayUnidimen[i]);
            }
            i++;
        }
    }
}
