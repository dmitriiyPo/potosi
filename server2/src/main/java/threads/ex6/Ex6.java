package threads.ex6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex6 {

    public static void main(String[] args) throws InterruptedException {

        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        System.out.println(" Main Threads is open " + Thread.currentThread() + " " + Thread.currentThread().getState());

        Thread threadAdd = new Thread(new AddThread(list));
        Thread threadDelete = new Thread(new DeleteThread(list));

        threadAdd.start();
        threadDelete.start();

        try{
            threadAdd.join();
            threadDelete.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(list);

        System.out.println(" AddThread Threads " + threadAdd.getState());
        System.out.println(" DeletedThread Threads " + threadDelete.getState());
    }
}
