/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortAndSearchIntList;
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
        int loc;
        switch (choice) {
            case 0:
                System.out.println("Bye!");
                break;
            case 1:
                System.out.println("How big should the list be?");
                int size = scan.nextInt();
                list = new IntegerList(size);
                list.randomize();
                break;
            case 2:
                list.selectionSort();
                break;
            case 3:
                System.out.print("Enter the value to look for: ");
                loc = list.search(scan.nextInt());
                if (loc != -1) {
                    System.out.println("Found at location " + loc);
                } else {
                    System.out.println("Not in list");
                }
                break;
            case 4:
                list.print();
                break;
            case 5:
                System.out.println("Masukkan nilai yang ingin diganti: ");
                int oldValue0 = list.list[list.search(scan.nextInt())];
                System.out.println("Masukkan nilai baru: ");
                list.replaceFirst(oldValue0, scan.nextInt());
                break;
            case 6:
                System.out.println("Masukkan nilai yang ingin diganti: ");
                int oldValue1 = list.list[list.search(scan.nextInt())];
                System.out.println("Masukkan nilai baru: ");
                list.replaceAll(oldValue1, scan.nextInt());
                break;
            case 7:
                System.out.println("Sorting list (decrease)...");
                list.sortDecreasing();
                list.print();
                break;
            case 8:
                System.out.println("Enter the value to find: ");
                int temp = list.binarysearchD(scan.nextInt());
                System.out.println("hasil: " + temp);
        }
    }

    //-------------------------------------------------------
    // Print the user's choices
    //-------------------------------------------------------
    public static void printMenu() {
        System.out.println("\n Menu ");
        System.out.println(" ====");
        System.out.println("0: Quit");
        System.out.println("1: Create a new list (** do this first!! **)");
        System.out.println("2: Sort the list using selection sort");
        System.out.println("3: Find an element in the list using linear search");
        System.out.println("4: Print the list");

        System.out.println("5: Replace First");
        System.out.println("6: Replace All");
        System.out.println("7: Sort Deacreasing");
        System.out.println("8: Binary Search");

        System.out.print("\nEnter your choice: ");
    }
}
