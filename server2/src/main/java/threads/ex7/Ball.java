package threads.ex7;

public class Ball {
    private boolean ping = false;


    //when we exite, if we want to call ping, then we assign ping to true
    //and by using method notifyAll we exite ping
    public synchronized void ping(){
        ping = true;
        notifyAll(); //?notify
    }


    //when ping is false we call method pong
    public synchronized void pong(){
        ping = false;
        notifyAll();
    }



    //while ping equals false it means that compiling pong (other method for pong)
    //and we ask ping for wait while other method do his work
    public synchronized void waitForPing()throws InterruptedException{
        while(!ping)
            wait();
    }

    public synchronized void waitForPong()throws InterruptedException{
        while(ping)
            wait();
    }
}
