package threads.ex8;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AddByThread implements Runnable {
    private List<Integer> list;
    private ReentrantLock lock;
    private Condition condition;

    public AddByThread(List<Integer> list, ReentrantLock lock, Condition condition) {
        this.list = list;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {

        System.out.println(" AddThread Threads is open " + Thread.currentThread() + " " + Thread.currentThread().getState());

        for (int i = 0; i < 10000; i++) {
            try{
                lock.lock(); //ожидает пока не будет наложена блокировка
                System.out.println("add");
                list.add(i);
                condition.signal();
            } finally{
                lock.unlock();
            }
        }
        if(list.size() == 10000){
            System.out.println("list is full");
        }
    }
}