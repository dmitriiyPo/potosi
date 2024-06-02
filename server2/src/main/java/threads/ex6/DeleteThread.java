package threads.ex6;

import java.util.List;
import java.util.Random;

public class DeleteThread implements Runnable{
    private List<Integer> list;

    public DeleteThread(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        System.out.println(" DeletedThread Threads is open " + Thread.currentThread() + " " + Thread.currentThread().getState());

        Random r = new Random();
        for (int i = 0; i < 10000; i++) {
            synchronized (list) {
                if (list.isEmpty()) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int k = r.nextInt(list.size());
                list.remove(k);
            }
        }
        if(list.isEmpty()) System.out.println("Work is done!");
    }
}
