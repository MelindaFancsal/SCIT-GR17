package org.example.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Scanner;

public class IOMain {

    //1 byte = 8 biti
    //1 char = 16 biti

    //nonbuffer vs buffer stream reader - writer
    //nio - path , channel instead of stream
    //serializare obiecte

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        byteStreamExample();
        charStreamExample();
        scannerExample();
        nioExample();

        //TEME: DECORATOR PATTERN!!!
        //LIBRARIA GSON + ce este JSON??

        serializareObiecte();
    }

    private static void serializareObiecte() throws IOException, ClassNotFoundException {
        //am o lista de persoane cu nume, vasta, inaltime

        FilePersoaneReader fileObject = new FilePersoaneReader();

        List<Persoana> persoane = fileObject.citireFisierCVS("src/main/resources/persoane.cvs");

        System.out.println(persoane);

        //serializarea obiectului
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/main/resources/persoane.obj"));
        objectOutputStream.writeObject(persoane.get(0));


        //la client - gson library - serializare deserializare o alta varianta
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/main/resources/persoane.obj"));
        Persoana obiectDeserializat = (Persoana) objectInputStream.readObject();

        System.out.println(obiectDeserializat);
    }

    private static void nioExample() throws IOException {
        Path path = Paths.get("src/main/resources/input.txt");
        Path pathOutput = Paths.get("src/main/resources/output_nio.txt");

        FileChannel fileChannel = FileChannel.open(path);

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int bytesRead;

        while ((bytesRead = fileChannel.read(buffer)) != -1) {

            buffer.flip(); // make buffer ready for read

            byte[] destination = new byte[bytesRead];
            buffer.get(destination);

            Files.write(pathOutput, destination, StandardOpenOption.CREATE);

            buffer.clear(); // make buffer ready for writing
        }

        fileChannel.close();
    }

    private static void scannerExample() {
        String exemplu = "Hello, I am here";
        Scanner scan = new Scanner(exemplu);

        while (scan.hasNext()) {
            String result = scan.next();
            System.out.println(result);
        }

        scan.close();

        Scanner in = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = in.next();

        System.out.println("name is : " + name);

    }

    private static void charStreamExample() throws IOException {
        FileReader nonBufferReader = null;
        FileWriter nonBufferWriter = null;

        BufferedReader bufferReader = null;
        BufferedWriter bufferWriter = null;

        try {
            nonBufferReader = new FileReader("src/main/resources/input.txt");
            nonBufferWriter = new FileWriter("src/main/resources/output.txt", true);


            bufferReader = new BufferedReader(new FileReader("src/main/resources/input.txt"));
            bufferWriter = new BufferedWriter(new FileWriter("src/main/resources/output.txt", true));

            int c;

            while ((c = nonBufferReader.read()) != -1) {
                nonBufferWriter.write(c);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (nonBufferWriter != null) {
                nonBufferWriter.close();
            }

            if (nonBufferReader != null) {
                nonBufferReader.close();
            }
        }
    }

    private static void byteStreamExample() {
//        Instant startNonBuffer = Instant.now();
//
//        FileInputStream nonBufferedReader = new FileInputStream("src/main/resources/java.png");
//        FileOutputStream nonBufferWriter = new FileOutputStream("src/main/resources/copyJava.png", true);
//
//        copy(nonBufferedReader, nonBufferWriter);
//
//        Instant endNonBuffer = Instant.now();
//        Duration durationNonBuffer = Duration.between(startNonBuffer, endNonBuffer);
//
//        System.out.println("nonbuffer  " + durationNonBuffer);


        Instant start = Instant.now();

        try( BufferedInputStream bufferedReader = new BufferedInputStream(new FileInputStream("src/main/resources/java.png"));
             BufferedOutputStream bufferedWriter = new BufferedOutputStream(new FileOutputStream("src/main/resources/copyJava.png", true));
        ) {

            copy(bufferedReader, bufferedWriter);

            Instant end = Instant.now();

            Duration duration = Duration.between(start, end);

            System.out.println(duration);
        } catch (IOException ex) {
            System.out.println("eroare fisier: " + ex.getMessage());
        }

    }


    private static void copy(InputStream reader, OutputStream writer) throws IOException {
        int c;

        while ((c = reader.read()) != -1) {
            writer.write(c);
        }

        if (reader != null) {
            reader.close();
        }

        if (writer != null) {
            writer.close();
        }
    }
}
