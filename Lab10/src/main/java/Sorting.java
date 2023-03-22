import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 * Class implementing sorting algorithms.
 *
 * @see <a href="https://cs125.cs.illinois.edu/lab/10/">Lab 10 Description</a>
 */

public class Sorting {

    /** Increment to sweep the sort. */
    private static final int SORT_INCREMENT = 10000;

    /** Total number of values to try. */
    private static final int TOTAL_SORT_VALUES = 100;

    /** Total data size. */
    private static final int TOTAL_INTEGER_VALUES = 1000000;

    /**
     * Bubble sort.
     *
     * @param array unsorted input array
     * @return the sorted array, or null on failure
     */
    @SuppressWarnings("unused")
    private static int[] bubbleSort(final int[] array) {
        return null;
    }

    /**
     * Selection sort.
     *
     * @param array unsorted input array
     * @return the sorted array, or null on failure
     */
    @SuppressWarnings("unused")
    private static int[] selectionSort(final int[] array) {
        return null;
    }

    /**
     * Merge sort.
     *
     * @param array array that needs to be sorted
     * @return the sorted array, or null on failure
     */
    @SuppressWarnings("unused")
    private static int[] mergeSort(final int[] array) {
        return null;
    }

    /**
     * Merge helper function that merges two sorted arrays into a single sorted array.
     * <p>
     * Implement an in place merge algorithm that repeatedly picks the smaller of two numbers from
     * passed arrays and copies it to the returned array to produce a bigger sorted array
     *
     * @param first the first array to merge
     * @param second the second array to merge
     * @return the sorted array, or null on failure
     */
    @SuppressWarnings("unused")
    private static int[] merge(final int[] first, final int[] second) {
        int total = first.length + second.length;
        int firstIndex = 0, secondIndex = 0;
        int[] returnArray = new int[total];
        for (int i = 0; i < total; i++) {
            if (firstIndex < first.length && secondIndex < second.length) {
                if (first[firstIndex] < second[secondIndex]) {
                    returnArray[i] = first[firstIndex];
                    firstIndex++;
                } else {
                    returnArray[i] = second[secondIndex];
                    secondIndex++;
                }
            } else if (firstIndex < first.length) {
                returnArray[i] = first[firstIndex];
                firstIndex++;
            } else if (secondIndex < second.length) {
                returnArray[i] = second[secondIndex];
                secondIndex++;
            }
        }
        return returnArray;
    }

    /**
     * Helper function to check if an array is actually sorted.
     *
     * @param array the array to check
     * @return true if the array is sorted, false otherwise
     */
    private static boolean isSorted(final int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Main method for testing.
     * <p>
     * This method reads numbers from input file of type specified by user, runs different sorting
     * algorithms on different sizes of the input and plots the time taken by each.
     *
     * @param unused unused input arguments
     * @throws FileNotFoundException thrown if the file is not found
     * @throws URISyntaxException thrown if the file is not found
     */
    @SuppressWarnings("checkstyle:magicnumber")
    public static void main(final String[] unused)
            throws FileNotFoundException, URISyntaxException {

        /*
         * Prompt for the input file.
         */
        Scanner userInput = new Scanner(System.in);
        String dataFilename = "";
        while (true) {
            System.out.println("Enter the type of data to sort "
                    + "(1 for sorted, 2 for almost sorted, 3 for reverse sorted, 4 for random): ");
            int datatype = userInput.nextInt();
            switch (datatype) {
                case 1 :
                    dataFilename = "sorted.txt";
                    break;
                case 2 :
                    dataFilename = "almostsorted.txt";
                    break;
                case 3 :
                    dataFilename = "reverse.txt";
                    break;
                case 4:
                    dataFilename = "random.txt";
                    break;
                default :
                    System.out.println("Please enter 1, 2, 3, or 4");
                    break;
            }
            if (!dataFilename.equals("")) {
                break;
            }
        }

        /*
         * Load the input file.
         */
        URL fileURL = Sorting.class.getClassLoader().getResource(dataFilename);
        if (fileURL == null) {
            System.out.println("Opening file failed");
            return;
        }
        String numbersFilePath = fileURL.getFile();
        numbersFilePath = new URI(numbersFilePath).getPath();
        File numbersFile = new File(numbersFilePath);
        Scanner numbersScanner = new Scanner(numbersFile, "UTF-8");
        int[] allnumbers = new int[TOTAL_INTEGER_VALUES];
        for (int i = 0; i < TOTAL_INTEGER_VALUES; i++) {
            allnumbers[i] = numbersScanner.nextInt();
        }
        numbersScanner.close();

        /*
         * Prompt for the algorithm to use.
         */
        int whichAlgorithm;
        while (true) {
            System.out.println("Enter the sorting algorithm that you want to use"
                    + " (1 for bubble sort, 2 for insertion sort, 3 for merge sort, 4 for built-in): ");
            whichAlgorithm = userInput.nextInt();
            if (whichAlgorithm > 0 && whichAlgorithm < 5) {
                break;
            }
        }

        int[] timeValues = new int[TOTAL_SORT_VALUES];
        boolean succeeded = true;
        for (int i = 1; i <= TOTAL_SORT_VALUES; i++) {
            /*
             * Sweep in increments of SORT_INCREMENT. Copy the array first. Clone doesn't work here
             * because we only want a certain number of values.
             */
            int[] unsortedArray = new int[i * SORT_INCREMENT];
            System.out.println("Sorting " + (i * SORT_INCREMENT) + " integers");

            System.arraycopy(allnumbers, 0, unsortedArray, 0, i * SORT_INCREMENT);

            /*
             * Sort the array using the algorithm requested. Measure and record the time taken.
             */
            int[] sortedArray;
            long startTime = System.currentTimeMillis();
            switch (whichAlgorithm) {
                case 1 :
                    sortedArray = bubbleSort(unsortedArray);
                    break;
                case 2 :
                    sortedArray = selectionSort(unsortedArray);
                    break;
                case 3 :
                    sortedArray = mergeSort(unsortedArray);
                    break;
                default:
                    sortedArray = unsortedArray;
                    Arrays.sort(sortedArray);
                    break;
            }
            if (sortedArray == null || !isSorted(sortedArray)) {
                succeeded = false;
                break;
            }
            long endTime = System.currentTimeMillis();
            timeValues[i - 1] = (int) (endTime - startTime);
        }
        userInput.close();

        if (!succeeded) {
            System.out.println("Sorting failed");
            return;
        }

        /*
         * Plot the results if the sorts succeeded.
         */
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new GraphPlotter(timeValues));
        f.setSize(400, 400);
        f.setLocation(200, 200);
        f.setVisible(true);
    }
}
