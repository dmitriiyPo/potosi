package threads.ex4;

import java.util.List;

public class AddByThread implements Runnable {
    private List<Integer> list;

    public AddByThread(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {

        System.out.println(" AddThread Threads is open " + Thread.currentThread() + " " + Thread.currentThread().getState());

        for (int i = 0; i < 10000; i++) {
            synchronized (list) {
                list.add((int) (Math.random() * 10000));
                list.notify();
            }
        }
    }
}
