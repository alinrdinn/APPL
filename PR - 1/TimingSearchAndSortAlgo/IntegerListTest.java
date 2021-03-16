/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimingSearchAndSortAlgo;
// ****************************************************************
// IntegerListTest.java
//
// Provide a menu-driven tester for the IntegerList class.
//
// ****************************************************************

import java.util.Scanner;

public class IntegerListTest {

    static IntegerList list = new IntegerList(10);
    static Scanner scan = new Scanner(System.in);
//-------------------------------------------------------
// Create a list, then repeatedly print the menu and do what the
// user asks until they quit
//-------------------------------------------------------

    public static void main(String[] args) {
        printMenu();
        int choice = scan.nextInt();
        while (choice != 0) {
            dispatch(choice);
            printMenu();
            choice = scan.nextInt();
        }
    }
//-------------------------------------------------------
// Do what the menu item calls for
//-------------------------------------------------------

    public static void dispatch(int choice) {
        int found;
        int size;
        switch (choice) {
            case 0:
                System.out.println("Bye!");
                break;
            case 1:
                System.out.println("How big should the list be?");
                size = scan.nextInt();
                list = new IntegerList(size);
                list.randomize();
                break;
            case 2:
                System.out.println("How big should the list be?");
                size = scan.nextInt();
                list = new IntegerList(size);
                list.fillSorted();
                break;
            case 3:
                list.selectionSort();
                break;
            case 4:
                list.insertionSort();
                break;
            case 5:
                System.out.println("Enter the value to look for (linear search): ");
                found = list.linearSearch(scan.nextInt());
                if (found != -1) {
                    System.out.println("Found: "+ found);
                } else {
                    System.out.println("Not in list");
                }
                break;
            case 6:
                System.out.println("Enter the value to look for (binary search): ");
                found = list.binarySearch(scan.nextInt());
                if (found != -1) {
                    System.out.println("Found: "+ found);
                } else {
                    System.out.println("Not in list");
                }
                break;
            case 7:
                list.print();
                break;
        }
    }

    //-------------------------------------------------------
    // Print the user's choices
    //-------------------------------------------------------
    public static void printMenu() {
        System.out.println("\n Menu ");
        System.out.println(" ====");
        System.out.println("0: Quit");
        System.out.println("1: Create new random list (** do this first!! **)");
        System.out.println("2: Create new sorted list (** or this!! **)");
        System.out.println("3: Sort the list using selection sort");
        System.out.println("4: Sort the list using insertion sort");
        System.out.println("5: Find an element in the list using linear search");
        System.out.println("6: Find an element in the list using binary search");
        System.out.println("7: Print the list");

        System.out.print("\nEnter your choice: ");
    }
}
