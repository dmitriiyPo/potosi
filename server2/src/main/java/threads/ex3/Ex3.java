package threads.ex3;

public class Ex3 {

    public static void main(String []args) throws InterruptedException {

        Thread two_thread = new Thread(new TwoThread());
        Thread three_thread = new Thread(new ThreeThread());
        Thread four_thread = new Thread(new FourThread());

        System.out.println(" Main Threads is open " + Thread.currentThread() + " " + Thread.currentThread().getState());


        two_thread.start();
        three_thread.start();
        four_thread.start();

        try{

            two_thread.join();
            three_thread.join();
            four_thread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" TwoThread Threads " + two_thread.getState());
        System.out.println(" ThreeThread Threads " + three_thread.getState());
        System.out.println(" FourThread Threads " + four_thread.getState());

        System.out.println(" Main Threads is open " + Thread.currentThread() + " " + Thread.currentThread().getState());

    }
}
