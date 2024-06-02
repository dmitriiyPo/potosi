package threads.ex5;

import java.util.ArrayList;
import java.util.List;

public class Ex5 {

    public static void main(String[] args) throws InterruptedException {

        List<Integer> list = new ArrayList<>();
        ListManager lm = new ListManager(list);

        System.out.println(" Main Threads is open " + Thread.currentThread() + " " + Thread.currentThread().getState());

        Thread threadAdd = new Thread(new AddDeleteThread(lm, true));
        Thread threadDelete = new Thread(new AddDeleteThread(lm,false));

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
