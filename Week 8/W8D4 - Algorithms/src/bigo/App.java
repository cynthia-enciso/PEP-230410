package bigo;
public class App {
    public static void main(String[] args) {
        int[] array = {1 , 2, 3};
        
        // O(1)
        constant(array);

        System.out.println();
        // O(n)
        linear(array);
        System.out.println();
        // O(n^2)
        quadratic(array);
    }

    public static void constant(int[] array) {

        // if the array is not null AND it has at least one element
        if (array != null && array.length > 0) {
            System.out.println(array[0]);
        }
    }

    public static void linear(int[] array) {

        for (int element : array) {
            System.out.println(element);
        }

    }

    public static void quadratic(int[] array) {

        // {1 , 2, 3};
        // 1 * 1
        // 1 * 2
        // 1 * 3
        // 2 * 1
        // 2 * 2
        // 2 * 3
        // etc
        
        for (int element : array) {
            for (int elementAgain : array) {
                System.out.println(element * elementAgain);
            }
        }

    }

}
