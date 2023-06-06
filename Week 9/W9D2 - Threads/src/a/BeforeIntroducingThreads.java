package a;

public class BeforeIntroducingThreads {
    public static void main(String[] args) {
        displayEvenNumbers();
        displayOddNumbers();
    }

    public static void displayEvenNumbers() {
        for (int i = 2; i < 21; i = i + 2) {
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void displayOddNumbers() {
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
