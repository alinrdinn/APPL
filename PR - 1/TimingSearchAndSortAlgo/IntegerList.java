package TimingSearchAndSortAlgo;
import java.util.*;
// ****************************************************************
// IntegerList.java
//
// Define an IntegerList class with methods to create, fill,
// sort, and search in a list of integers.
//
// ****************************************************************

public class IntegerList {

    int[] list; //values in the list
//-------------------------------------------------------
//create a list of the given size
//-------------------------------------------------------

    public IntegerList(int size) {
        list = new int[size];
    }
//-------------------------------------------------------
//fill array with integers between 1 and 100, inclusive
//-------------------------------------------------------

    public void randomize() {
        for (int i = 0; i < list.length; i++) {
            list[i] = (int) (Math.random() * 100) + 1;
        }
    }
//------------------------------------------------------------
// fillSorted -- fills the array with sorted values
//------------------------------------------------------------

    public void fillSorted() {
        for (int i = 0; i < list.length; i++) {
            list[i] = i + 2;
        }
    }
//-------------------------------------------------------
//print array elements with indices
//-------------------------------------------------------

    public void print() {
        for (int i = 0; i < list.length; i++) {
            System.out.println(i + ":\t" + list[i]);
        }
    }

    public void selectionSort() {
        long start = System.currentTimeMillis();
        int minIndex;
        for (int i = 0; i < list.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;
        }
        long end = System.currentTimeMillis();
        System.out.println("Time Selection Sort: "+(end-start));
    }
    
    public void insertionSort() {
        long start = System.currentTimeMillis();
        int n = list.length;
        for (int i = 1; i < n; ++i) {
            int key = list[i];
            int j = i - 1;
            while (j >= 0 && list[j] > key) {
                list[j + 1] = list[j];
                j = j - 1;
            }
            list[j + 1] = key;
        }
        long end = System.currentTimeMillis();
        System.out.println("Time Insertion Sort: "+(end-start));
    }
    
//-------------------------------------------------------
//return the index of the first occurrence of target in the list.
//return -1 if target does not appear in the list
//-------------------------------------------------------

    public int linearSearch(int target) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < list.length; i++) {
            if (list[i] == target) {
                return list[i];
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Time Linear Search: "+(end-start));
        return -1;
    }
    
    public int binarySearch(int target) {
        long start = System.currentTimeMillis();
        int l = 0, r = list.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (list[m] == target) {
                return list[m];
            }
            if (list[m] < target) {
                l = m + 1;
            }
            else {
                r = m - 1;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Time Binary Search: "+(end-start));
        return -1;
        
    }
}
