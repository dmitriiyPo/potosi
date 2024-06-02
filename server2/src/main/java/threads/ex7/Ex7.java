package threads.ex7;

public class Ex7 {

    public static void main(String[] args) throws InterruptedException {

        Ball ball = new Ball();

        System.out.println(" Main Threads is open " + Thread.currentThread() + " " + Thread.currentThread().getState());

        Thread ping = new Thread(new Ping(ball));
        Thread pong = new Thread(new Pong(ball));

        ping.start();
        pong.start();

        ping.join();
        pong.join();

    }
}
