package org.example.recap.ex6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();

        List<Integer> note1 = new ArrayList<>();
        note1.add(10);
        note1.add(4);

        List<Integer> note2 = new ArrayList<>();
        note2.add(4);
        note2.add(4);
        catalog.addElev(new Elev("Radu", "cvf", new HashMap<>() {{
            put("Matematica", note1);
            put("Romana", note2);

        }}));
        catalog.addElev(new Elev("Radu", "cvf", null));
        catalog.addElev(new Elev("Mihai", "abc", null));
        catalog.addElev(new Elev("Ana", "ops", null));
        catalog.addElev(new Elev("Ghita", "xcv", null));

//        System.out.println(catalog.returneazaEleviiOrdonatiAlfabetic());

//        System.out.println(catalog.returneazaEleviiOrdonatiDupaNrMatricol());

        catalog.afiseazaEleviiCareNuSuntCorigenti();
    }
}
