// queues
// FIFO
// head, tail
//  offer == attempt to add
//  peek == attempt to look at head
//  poll == attempt to remove

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

class Mail {
  // state
  String description;
    
  // constructors
  public Mail() {}
   
  public Mail(String description) {
    this.description = description;
  }

  public String toString() {
    return description;
  }
}

public class UsingQueues {

  public static Queue<Mail> mailbox = new ArrayBlockingQueue<>(5);

  public static void main(String[] args) {
    mailmanDepositsMail(10);
    // 5 mail items are in the mailbox
    homeownerGetsMail(7);
    // mailbox.element();

    System.out.println(mailbox.peek());
  }
    
    //method for mailman
    public static void mailmanDepositsMail(int amount) {
      boolean wasDeposited = true;
      while (amount > 0) {
        wasDeposited = mailbox.offer(new Mail(String.valueOf(amount)));
        if (wasDeposited) {
          System.out.println("The mailman deposited a mail number: " + amount);
        }else{
          System.out.println("The mailman attempts to deposit mail number: " + amount + ", but mailbox's full!");
        }
        amount--;
      
      }}

    public static void homeownerGetsMail(int amount) {
      while (amount > 0) {
        amount--;
        if (mailbox.peek() != null) {
          System.out.println("The homeowner picked up a mail item number: " + mailbox.poll());
        } else {
          System.out.println("The attempts to grab some mail, but there isn't any!");
        }
      }

    }
  }
