package threads.ex5;

public class AddDeleteThread implements Runnable{
    private final ListManager listManager;
    private final boolean isAdd;

    public AddDeleteThread(ListManager listManager, boolean isAdd) {
        this.listManager = listManager;
        this.isAdd = isAdd;
    }

    @Override
    public void run() {

        if (isAdd) {
            System.out.println(" AddThread Threads is open " + Thread.currentThread() + " " + Thread.currentThread().getState());

            for (int i = 0; i < 10000; i++) {
                listManager.addToByThread();
            }
        } else {
            System.out.println(" DeletedThread Threads is open " + Thread.currentThread() + " " + Thread.currentThread().getState());

            for (int i = 0; i < 10000; i++) {
                listManager.deleteFromByThread();
            }
        }
    }
}
