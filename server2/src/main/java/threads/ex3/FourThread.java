package threads.ex3;

public class FourThread implements Runnable{
    @Override
    public void run() {
        System.out.println(" FourThread Threads is open " + Thread.currentThread() + " " + Thread.currentThread().getState());
    }
}
