package threads.ex2;

public class Ex2 {

    public static void main(String []args) throws InterruptedException {

        Thread one_thread = new Thread(new OneThread());

        System.out.println(" Main Threads is open " + Thread.currentThread() + " " + Thread.currentThread().getState());

        one_thread.start();

        try{

            one_thread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" OneThread Threads " + one_thread.getState());

        System.out.println(" Main Threads " + Thread.currentThread().getState());


    }
}
