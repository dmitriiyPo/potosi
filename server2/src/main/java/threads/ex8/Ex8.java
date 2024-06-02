package threads.ex8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Ex8 {

    public static void main(String[] args) throws InterruptedException {

        List<Integer> list = new ArrayList<>();
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();


        System.out.println(" Main Threads is open " + Thread.currentThread() + " " + Thread.currentThread().getState());


        Thread threadAdd = new Thread(new AddByThread(list, lock, condition));
        Thread threadDelete = new Thread(new DeleteFromThread(list, lock, condition));


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
