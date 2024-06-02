package threads.ex5;

import java.util.List;

public class ListManager {
    private final List<Integer> list;
    public ListManager(List<Integer> list) {
        this.list = list;
    }

    public synchronized void addToByThread() {
        System.out.println("List size is " + list.size() + " thread is -> " + Thread.currentThread().getName());
        list.add((int) (Math.random() * 10000));
        this.notify();
    }

    public synchronized void deleteFromByThread(){
        int elToDelete;
        while (list.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        elToDelete = (int) (Math.random() * list.size());
        System.out.println(Thread.currentThread().getName() + " size list is " + list.size() + " removed el have index " + elToDelete + "\n");
        list.remove(elToDelete);
    }
}
