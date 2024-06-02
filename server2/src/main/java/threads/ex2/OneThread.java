package threads.ex2;

public class OneThread implements Runnable {

    @Override
    public void run() {
        System.out.println(" OneThread Threads is open " + Thread.currentThread() + " " + Thread.currentThread().getState());
    }
}
