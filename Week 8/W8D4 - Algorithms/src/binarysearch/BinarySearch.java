package binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int result = binarySearch(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5);
        System.out.println(result);
    }

    public static int binarySearch(int[] array, int targetValue) {
        // create variables needed
			// beginning index
			int beginningIndex = 0;
			// end index
			int endIndex = array.length - 1;
		
		// WHILE we still have input to look through
        while (beginningIndex <= endIndex) {
            // find the midpoint
            int midIndex = (endIndex + beginningIndex)/ 2;
            // get value at midpoint
            int midValue = array[midIndex];

            // IF value of midpoint == target value THEN
            if (targetValue == midValue) {
				// RETURN midpoint
                return midIndex;
            }
			// ELSE IF value of midpoint < target value THEN
            else if (midValue < targetValue) {
				// change the beginning index to midpoint + 1
                beginningIndex = midIndex + 1;
            }
			// ELSE
            else {
                // change the end index to midpoint - 1
                endIndex = midIndex - 1;
            }
				
        }
		// END OF WHILE LOOP

		// RETURN -1 if target not found
        return -1;
    }
}
