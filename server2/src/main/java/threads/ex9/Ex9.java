package threads.ex9;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ex9 {

    public static void main(String[] args) throws InterruptedException {

        Lock lock = new ReentrantLock();
        Ball ball = new Ball(lock);

        Thread ping = new Thread(new Ping(ball));
        Thread pong = new Thread(new Pong(ball));

        ping.start();
        pong.start();

        ping.join();
        pong.join();

    }
}
