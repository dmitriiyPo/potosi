package threads.ex9;

import java.util.concurrent.TimeUnit;

public class Ping implements Runnable{
    private Ball ball;

    public Ping(Ball ball) {
        this.ball = ball;
    }

    @Override
    public void run() {
        try {
            //возвращает true, если поток был прерван, но переводит булевую interrupted обратно в false
            while (!Thread.interrupted()) {
                System.out.println("Ping");
                TimeUnit.MILLISECONDS.sleep(2000);
                ball.ping();        //ping = true, notify
                ball.waitForPong(); //while (ping = true) wait
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
