// this code contains the necessary fix for the program to work synchronously

import java.util.*;
import java.io.*;
import java.net.*;

public class Question3 {
    public static void main(String[] args) throws Throwable{
        Economy myeconomy = new Economy();

        Thread t1 = new Thread(new Producer(myeconomy));
        Thread t2 = new Thread(new Consumer(myeconomy));

        t2.start();
        t1.start();
    }
}

class Producer implements Runnable{
    Economy e;

    Producer(Economy e) {
        this.e = e;
    }

    public void run() {
        try {
            e.producer();
        } catch(Throwable t) {}
    }
}

class Consumer implements Runnable {
    Economy e;

    Consumer(Economy e) {
        this.e = e;
    }

    public void run() {
          try {
              e.consumer();
          } catch(Throwable t) {}
    }
}

class Economy {
    boolean product = false;

    synchronized public void producer() throws Throwable {
        System.out.println("Running producer");
        while(true) {
            if(product) {
                try {
                    System.out.println("Producer: Too much product exists. Gonna wait...");
                    wait();
                } catch(Throwable t) {
                  t.printStackTrace();
                }
            }

            System.out.println("Producer: Making more product now.");
            product = true;
            notifyAll();
            Thread.sleep(1000);
            System.out.println("Producer ending");
        }
    }

    synchronized public void consumer() throws Throwable {
        System.out.println("Running Consumer");
        while(true){
            if(!product) {
                try {
                    System.out.println("Consumer: No products available to consume. Gonna wait...");
                    wait();
                } catch(Throwable t) {
                  t.printStackTrace();
                }
            }

            System.out.println("Consumer: Now consuming product");
            product = false;

            notifyAll();
            Thread.sleep(10);
            System.out.println("Consumer ending");
        }
    }
}
