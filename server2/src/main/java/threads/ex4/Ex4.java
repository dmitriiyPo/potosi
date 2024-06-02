package threads.ex4;

import java.util.ArrayList;
import java.util.List;

public class Ex4 {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();

        System.out.println(" Main Threads is open " + Thread.currentThread() + " " + Thread.currentThread().getState());

        Thread threadAdd = new Thread(new AddByThread(list));
        Thread threadDelete = new Thread(new DeleteFromThread(list));

        threadAdd.start();
        threadDelete.start();

        try {

            threadAdd.join();
            threadDelete.join();

            System.out.println(list);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" AddThread Threads " + threadAdd.getState());
        System.out.println(" DeletedThread Threads " + threadDelete.getState());

    }
}
