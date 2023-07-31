package org.example.concurency;

public class MyThread extends Thread {

    @Override
    public void run() {
        //conexiuni la server sau la db
        //citire / scriere fisiere
        System.out.println(Thread.currentThread().getName());

    }
}
