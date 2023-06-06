package c;
/*
     * states demonstrated in this file:
     * 
     * NEW - created but not yet started
     * RUNNABLE - started, able to perform tasks and active (isAlive would be true)
     * TERMINATED - thread reached end of run method, no longer active
     * WAITING - thread is paused for undefined amount of time due to wait(), join() or it isn't its turn to execute
     * TIMED WAITING - pauses because of sleep(), join(), or wait()
     * BLOCKED - waiting for another thread to release lock on a resource (not demonstrated until tomorrow!)
     */
public class ThreadStates {
    public static void main(String[] args) {
        // create threads
        Thread simpleThread1 = new SimpleThread();
        Thread simpleThread2 = new SimpleThread();

        // choose to name threads
        simpleThread1.setName("Simple Thread 1");
        simpleThread2.setName("Simple Thread 2");

        // various info checks and statements
        checkThreadInformation(Thread.currentThread(), simpleThread1, simpleThread2);
        simpleThread1.start();
        simpleThread2.start();

        checkThreadInformation(Thread.currentThread(), simpleThread1, simpleThread2);

        simpleThread1.interrupt();

        checkThreadInformation(Thread.currentThread(), simpleThread1, simpleThread2);


        checkThreadInformation(Thread.currentThread(), simpleThread1, simpleThread2);
        
    }

    public static void checkThreadInformation(Thread ...threads) {
        System.out.println("============== START OF A CHECK ==============");
        for (Thread thread : threads) {
            System.out.print("-----------------\n" + 
            "Name: " + thread.getName() + "\n" +
            "Thread: " + thread.threadId() + "\n" +
            "State: " + thread.getState() + "\n" +
            "isAlive: " + thread.isAlive() + "\n" +
            "Priority: " + thread.getPriority() + "\n" +
            "-----------------\n"
            );
        }
        System.out.println("============== END OF A CHECK ==============");
    }

}

class SimpleThread extends Thread {
    @Override
    public void run() {
        for(int i = 2; i <= 10; i = i + 2) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(this.getName() + " interrupted! and in state: "  + this.getState());
                return; 
            }
        }
    }
}



