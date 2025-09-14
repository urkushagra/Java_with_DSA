/*
 * Program: Advanced Array Concepts in Java
 * Author: Your Name
 * Description:
 *   This program demonstrates advanced array concepts in Java including:
 *   1. Multidimensional Arrays
 *   2. Jagged Arrays
 *   3. Utility methods from java.util.Arrays
 *   4. Enhanced For-Loop
 *   5. Streams API for processing arrays
 */

import java.util.Arrays;
import java.util.stream.IntStream;

public class AdvancedArrayConcepts {
    public static void main(String[] args) {
        
        /* ---------------------------------------------------
         * 1. MULTIDIMENSIONAL ARRAY (Matrix)
         * ---------------------------------------------------
         * A 2D array with fixed rows and columns.
         * Used for representing tabular data like matrices.
         */
        int[][] matrix = {
            {1, 2, 3}, 
            {4, 5, 6}, 
            {7, 8, 9}
        };

        System.out.println("Multidimensional Array:");
        for (int[] row : matrix) {          // For-each loop for each row
            for (int val : row) {           // For-each loop for each element
                System.out.print(val + " ");
            }
            System.out.println();
        }

        /* ---------------------------------------------------
         * 2. JAGGED ARRAY
         * ---------------------------------------------------
         * A 2D array where rows can have different lengths.
         * Example: useful for storing variable length records.
         */
        int[][] jagged = new int[3][];   // Only row size is defined
        jagged[0] = new int[]{1, 2};     // First row has 2 elements
        jagged[1] = new int[]{3, 4, 5};  // Second row has 3 elements
        jagged[2] = new int[]{6};        // Third row has 1 element

        System.out.println("\nJagged Array:");
        for (int[] arr : jagged) {
            System.out.println(Arrays.toString(arr));  // Print each row
        }

        /* ---------------------------------------------------
         * 3. ARRAYS UTILITY METHODS
         * ---------------------------------------------------
         * The Arrays class provides helpful methods such as
         * sort(), binarySearch(), copyOf(), etc.
         */
        int[] numbers = {5, 1, 7, 3, 9, 2};
        System.out.println("\nOriginal Array: " + Arrays.toString(numbers));

        Arrays.sort(numbers);  // Sort in ascending order
        System.out.println("Sorted Array: " + Arrays.toString(numbers));

        int index = Arrays.binarySearch(numbers, 7);  // Binary search requires sorted array
        System.out.println("Index of 7: " + index);

        int[] copied = Arrays.copyOf(numbers, 10);  // Extend array length to 10
        System.out.println("Copied and Extended Array: " + Arrays.toString(copied));

        /* ---------------------------------------------------
         * 4. ENHANCED FOR-LOOP
         * ---------------------------------------------------
         * A simplified loop for traversing arrays (read-only).
         */
        System.out.print("\nTraversing with Enhanced For-Loop: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        /* ---------------------------------------------------
         * 5. STREAMS API WITH ARRAYS
         * ---------------------------------------------------
         * Introduced in Java 8, Streams provide functional-style
         * operations like filtering, mapping, and reducing.
         */
        int sum = IntStream.of(numbers).sum();  // Sum of array elements
        double average = IntStream.of(numbers).average().orElse(0); // Average

        System.out.println("\n\nUsing Streams API:");
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);

        // Filtering even numbers
        System.out.println("Even Numbers: " + Arrays.toString(
            IntStream.of(numbers).filter(n -> n % 2 == 0).toArray()
        ));

        // Mapping each number to its square
        System.out.println("Squares: " + Arrays.toString(
            IntStream.of(numbers).map(n -> n * n).toArray()
        ));
    }
}
