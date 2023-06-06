package b;

/*  

interrupt() - threads have interrupt flags. 
    This sets the threads flag to true but doesn't stop thread!

*/

public class InterruptingThreads {
    public static void main(String[] args) {
        // create threads
        Thread evenThread = new DisplayEvensThread();
        Thread oddThread = new Thread(new DisplayOddsThread());

        // start threads
        evenThread.start();
        oddThread.start();

        

        // interrupt them
        evenThread.interrupt();
        oddThread.interrupt();

        System.out.println("Main thread statement #1");

        System.out.println("Main thread statement #2");
    }
}

class DisplayEvensThread extends Thread {

    public void run() {
        for (int i = 2; i < 21; i = i + 2) {
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // Note: you might see an interrupt() to change interrupt flag to true
                // interrupt();
                // System.out.println("Even thread was interrupted? " + isInterrupted());

                // e.printStackTrace();
                System.out.println("even thread interrupted!");
                return;
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
                // e.printStackTrace();
                System.out.println("odd thread interrupted!");
                return;
            }
        }
    }

}
