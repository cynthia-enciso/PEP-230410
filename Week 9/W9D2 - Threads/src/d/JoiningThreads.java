package d;
// https://docs.oracle.com/javase/tutorial/essential/concurrency/

/*
     * join() - https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html#join-long-int-
     * 
     */
public class JoiningThreads {
    public static void main(String[] args) throws InterruptedException {
        Thread simpleThread = new SimpleThread();

        System.out.println("first print statement from main thread");

        simpleThread.start();

        // without argument: allows the thread to run completely without interruption
        // with argument: runs without interruption for a certain amount of time
        simpleThread.join(3000);
        
        System.out.println("second print statement from main thread");

        System.out.println("third print statement from main thread");
    }
}

class SimpleThread extends Thread {
    @Override
    public void run() {
        for(int i = 1; i <= 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(this.getName() + " interrupted! and in state: "  + this.getState());
                return; 
            }
        }
    }
}
