package threads.ex3;

public class TwoThread implements Runnable{
    @Override
    public void run() {
        System.out.println(" TwoThread Threads is open " + Thread.currentThread() + " " + Thread.currentThread().getState());
    }
}
