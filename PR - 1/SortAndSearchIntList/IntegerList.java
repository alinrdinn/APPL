package SortAndSearchIntList;
// ****************************************************************
// IntegerList.java
//
// Define an IntegerList class with methods to create, fill,
// sort, and search in a list of integers.
//
// ****************************************************************

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

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
//-------------------------------------------------------
//print array elements with indices
//-------------------------------------------------------

    public void print() {
        for (int i = 0; i < list.length; i++) {
            System.out.println(i + ":\t" + list[i]);
        }
    }
//-------------------------------------------------------
//return the index of the first occurrence of target in the list.
//return -1 if target does not appear in the list
//-------------------------------------------------------

    public int search(int target) {
        int location = -1;
        for (int i = 0; i < list.length && location == -1; i++) {
            if (list[i] == target) {
                location = i;
            }
        }
        return location;
    }
//-------------------------------------------------------
//sort the list into ascending order using the selection sort algorithm
//-------------------------------------------------------

    public void selectionSort() {
        int minIndex;
        for (int i = 0; i < list.length - 1; i++) {
//find smallest element in list starting at location i
            minIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[minIndex]) {
                    minIndex = j;
                }
            }
//swap list[i] with smallest element
            int temp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;
        }
    }
    
    public void replaceFirst(int oldVal, int newVal){
     int len = list.length;
     for(int i = 0; i < len; i++){
         if (list[i] == oldVal) {
             list[i] = newVal;
             break;
         }
     }
    }
    public void replaceAll(int oldVal, int newVal){
     int len = list.length;
     for(int i = 0; i < len; i++){
         if (list[i] == oldVal) {
             list[i] = newVal;
         }
     }
    }
    public void sortDecreasing(){
        int minIndex;
        for (int i = 0; i < list.length - 1; i++) {
//find smallest element in list starting at location i
            minIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] > list[minIndex]) {
                    minIndex = j;
                }
            }
//swap list[i] with smallest element
            int temp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;
        }
    }
    public int binarysearchD(int target) {
        int l = 0, r = list.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (list[m] == target) {
                return list[m];
            }
            if (list[m] > target) {
                l = m + 1;
            }
            else {
                r = m - 1;
            }
        }
        return -1;
    }
}
