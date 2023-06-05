package bubblesort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {52, 33, 99, 20, 11,55};
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
    }

    public static void bubbleSort(int[] array) {
        // outer loop
        for (int i = 0; i < array.length - 1; i++) {
            // because the current value will be compared to the next, our stopping condition will be
            // the second to last index
            for (int j = 0; j < array.length - i - 1; j++) {
            // inner loop
                // if current element is larger than next element
                if (array[j] > array[j + 1]) {
                    // swap array them
                    int temp = array[j]; 
					array[j] = array[j+1]; 
					array[j+1] = temp; 
                }
            }
        }
    }
}
