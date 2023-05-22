// queues
    // head, tail
    // FIFO
    // offer = attempt to add
    // peek = attempt to look at head
    // poll = attempt to remove

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

class Mail {
    // state
    String description;

    // constructors
    public Mail(){}

    public Mail(String description) {
        this.description = description;
    }

    // toString
    public String toString() {
        return description;
    }
}

public class UsingQueues {

    public static ArrayBlockingQueue<Mail> mailbox = new ArrayBlockingQueue<>(5);
    public static void main(String[] args) {
        mailmanDepositsMail(10);

        // 5 mail items are in the mailbox

        homeownerGetsMail(7);

        // mailbox is empty!
        // mailbox.element();
        System.out.println(mailbox.peek());

    }

    // method for mailman
    public static void mailmanDepositsMail(int amount) {

        boolean wasDeposited = true;

        while (amount > 0) {
            wasDeposited = mailbox.offer(new Mail());
            amount--;

            if (wasDeposited) {
                System.out.println("The mailman deposited an item.");
            } else {
                System.out.println("The mailman attempts to deposit mail, but it's full!");
            }
        }
    }

    public static void homeownerGetsMail(int amount) {
        while (amount > 0) {
            amount--;
            if (mailbox.poll() != null) {
                System.out.println("The homeowner picked up a mail item.");
            } else {
                System.out.println("The attempts to grab some mail, but there isn't any!");
            }
        }
    }

}