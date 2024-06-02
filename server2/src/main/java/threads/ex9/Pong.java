package threads.ex9;

import java.util.concurrent.TimeUnit;

public class Pong implements Runnable{
    private Ball ball;

    public Pong(Ball ball) {
        this.ball = ball;
    }

    @Override
    public void run() {
        try {
            ////возвращает true, если поток был прерван, но переводит булевую interrupted обратно в false
            while (!Thread.interrupted()) {
                System.out.println("Pong");
                TimeUnit.MILLISECONDS.sleep(2000);
                ball.waitForPing();  //while (ping = false) wait()
                ball.pong();         //ping = false, notify
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
