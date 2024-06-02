package threads.ex9;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ball {
    private volatile boolean ping;
   private final Lock lock;
    private final Condition condition;

//    public Ball() {
//        this.ping = false;
//        this.lock = new ReentrantLock();
//        this.condition = lock.newCondition();
//    }


    public Ball(Lock lock) {
        this.ping = false;
        this.lock = lock;
        this.condition = lock.newCondition();
    }

    public void ping(){
        try{
            lock.lock();
            ping = true;
            condition.signalAll();
        } finally{
            lock.unlock();
        }
    }

    public void pong(){
        try{
            lock.lock();
            ping = false;
            condition.signalAll();
        } finally{
            lock.unlock();
        }
    }

    public void waitForPing()throws InterruptedException{
        try{
            lock.lock();
            while(!ping){
                condition.await();
            }
        }finally {
            lock.unlock();
        }
    }

    public void waitForPong()throws InterruptedException{
        try{
            lock.lock();
            while(ping){
                condition.await();
            }
        }finally{
            lock.unlock();
        }
    }
}
