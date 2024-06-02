package threads.ex3;

public class ThreeThread implements Runnable{
    @Override
    public void run() {
        System.out.println(" ThreeThread Threads is open " + Thread.currentThread() + " " + Thread.currentThread().getState());
    }
}
