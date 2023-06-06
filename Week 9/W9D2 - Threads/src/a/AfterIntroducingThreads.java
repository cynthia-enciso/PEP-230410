package a;

// https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html
/**
 * thread - thread, or line, of execution in a program
 * - have id, name, and priority. Think of priority as a suggestion to JVM scheduler.
 * Scheduler choose how to alternate between threads.
 * 
 * start() - creates a new process and then executes run
 * sleep() - pauses thread so other threads can run. can be interrupted.
 */
public class AfterIntroducingThreads {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        // create threads
        Thread evenThread = new DisplayEvensThread();
        Thread oddThread = new Thread(new DisplayOddsThread());

        // start threads
        evenThread.start();
        oddThread.start();
        
    }
}

class DisplayEvensThread extends Thread {

    public void run() {
        for (int i = 2; i < 21; i = i + 2) {
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } 
    }
}

class DisplayOddsThread implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i < 21; i = i + 2) {
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
