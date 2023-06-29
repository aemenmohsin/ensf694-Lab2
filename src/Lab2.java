
/**
 * Aemen Mohsin
 * ENSF 694
 * Lab 2
 * Lab2.java
 *
 * Class Name: Lab2
 * 
 * Class Implement the linear search algorithm and the interpolation algorithm 
 * (either iterative or recursive) for an integer array and search for a key in the array. 
 * Prompts the user for all inputs.
 * 
 */

import java.util.Arrays;
import java.util.Scanner;

public class Lab2 
{
	/**
	 *  Method to search an array using the linear search algorithm
	 *  @param int array and int key
	 *  @return i if in key or -1 if not in key
	 */
	public static int linSearch(int[] array, int key) 
	{
        for (int i = 0; i < array.length; i++) 
        {
            if (array[i] == key) 
            {
                return i;
            }
        }
        return -1;
    }
	/**
	 *  Method to search an array using the interpolation search algorithm
	 *  @param int array and int key
	 *  @return low, position or high if in key or -1 if not in key
	 */
	public static int interpolSearch(int[] array, int key) 
	{
	    int low = 0;
	    int high = array.length - 1;

	    while (low <= high && key >= array[low] && key <= array[high])
	    {
	    	if (low == high) 
	    	{
                if (array[low] == key) 
                {
                    return low;
                }
                return -1; // Key not found
            }
	    	double pos = (double) (key - array[low] / (array[high] - array[low]));
	        int mid = (int) (low + Math.abs((high - low) * pos));

	        if(key < array[mid])
	        {
	        	high = mid - 1;
	        }
	        else if(array[mid] < key)
	        {
	        	low = mid + 1;
	        }
	        else
	        {
	        	return mid;
	        }
	    }

	    return -1; // Key not found
	}

    /**
	 *  Main Method to implement scanner and take user input
	 */
	public static void main(String[] args) 
	{
	    Scanner scanner = new Scanner(System.in);
	
	    System.out.print("Enter the number of elements in the array: ");
	    int size = scanner.nextInt();
	
	    int[] array = new int[size];
	    System.out.println("Enter the elements in the array:");
	    for (int i = 0; i < size; i++) 
	    {
	        array[i] = scanner.nextInt();
	    }
	    
	    Arrays.sort(array);
	    
	    System.out.print("Enter the search key: ");
	    int key = scanner.nextInt();
	
	    int linearSearch = linSearch(array, key);
	    if (linearSearch != -1) 
	    {
	        System.out.println("Using Linear Search:");
	        System.out.println("Search key FOUND at index " + linearSearch + ".");
	    } 
	    else 
	    {
	        System.out.println("Using Linear Search:");
	        System.out.println("Search key NOT FOUND.");
	    }
	
	    int interpolationSearch = interpolSearch(array, key);
	    if (interpolationSearch != -1) 
	    {
	        System.out.println("\nUsing Interpolation Search:");
	        System.out.println("Search key FOUND at index " + interpolationSearch + ".");
	    } 
	    else 
	    {
	        System.out.println("Using Interpolation Search:");
	        System.out.println("Search key NOT FOUND.");
	    }
    }
}


