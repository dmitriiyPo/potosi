package threads.ex6;

import java.util.List;

public class AddThread implements Runnable{

    private final List<Integer> list;

    public AddThread(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {

        System.out.println(" AddThread Threads is open " + Thread.currentThread() + " " + Thread.currentThread().getState());

        for (int i = 0; i < 10000; i++){
            synchronized (list){
                list.add((int) (Math.random() * 10000));
                list.notify();
            }
        }
    }
}
