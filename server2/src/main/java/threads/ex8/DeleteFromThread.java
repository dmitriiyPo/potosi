package threads.ex8;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DeleteFromThread implements Runnable {
    private List<Integer> list;
    private ReentrantLock lock;
    private Condition condition;

    public DeleteFromThread(List<Integer> list, ReentrantLock lock, Condition condition) {
        this.list = list;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {

        System.out.println(" DeletedThread Threads is open " + Thread.currentThread() + " " + Thread.currentThread().getState());

            for (int i = 0; i < 10000; i++) {

                try {
                    lock.lock();
                    System.out.println("delete");
                    if (list.isEmpty()) {
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Random r = new Random();
                    int index = r.nextInt(list.size());
                    list.remove(index);


                } finally {
                    lock.unlock();
                }
            }

            if (list.isEmpty()) {
                System.out.println("We removed all elements from list.");
            }

    }
}
