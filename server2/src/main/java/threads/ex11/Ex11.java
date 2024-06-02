package threads.ex11;

import java.util.Date;

import static java.lang.Thread.sleep;

public class Ex11 {

    public static void main(String[] args) throws InterruptedException {

        System.out.println(" Main Threads is open " + Thread.currentThread() + " " + Thread.currentThread().getState());

        Date date = new Date();
        Formatter formatter = new Formatter(date);

        Thread thread_1 = new Thread(formatter);
        Thread thread_2 = new Thread(formatter);
        Thread thread_3 = new Thread(formatter);
        Thread thread_4 = new Thread(formatter);
        Thread thread_5 = new Thread(formatter);

        thread_1.start();
        thread_2.start();
        thread_3.start();
        thread_4.start();
        thread_5.start();

        thread_1.join();
        thread_2.join();
        thread_3.join();
        thread_4.join();
        thread_5.join();




//        System.out.println(" AddThread Threads " + threadAdd.getState());
//        System.out.println(" DeletedThread Threads " + threadDelete.getState());

    }
}
