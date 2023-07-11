package org.example.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilePersoaneReader {

    public List<Persoana> citireFisierCVS(String fileName) throws IOException {
        List<Persoana> persoane = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            String[] tokens = line.split(" ");
            Persoana persoana = new Persoana(
                    tokens[0],
                    Integer.parseInt(tokens[1]),
                    Double.parseDouble(tokens[2])
            );

            persoane.add(persoana);
        }

        bufferedReader.close();

       // Arrays.sort(persoane, );
        return persoane;
    }
}
