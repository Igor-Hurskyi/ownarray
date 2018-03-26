package com.epam.main;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        boolean continueOperations = true;
        boolean logging = true;

        int operation;
        int value;
        Object choice;

        System.out.print("Select array length: ");
        int size = reader.nextInt();

        MyArrayList<Integer> myList = new MyArrayList<>(size);


        System.out.println("Type 'help' to get operations list.");

        while (continueOperations == true) {
            System.out.print("Select operation: ");
            choice = reader.next();
            if (choice.equals("help")) {
                System.out.println("[0] = exit\n" +
                        "[1] = add to the start [value]\n" +
                        "[2] = add to the end [value]\n" +
                        "[3] = set element [index, value]\n" +
                        "[4] = delete element [index]\n" +
                        "[5] = extend to size [size]\n" +
                        "[6] = trim to size[size]\n" +
                        "[7] = display elements\n" +
                        "[8] = display elements reversed\n" +
                        "[9] = sort array\n" +
                        "[10] = is array empty\n" +
                        "[11] = element occurrences [value]");
                continue;
            } else {
                operation = Integer.parseInt((String) choice);
                if ((operation < 7 || operation > 10) && operation > 0 && operation < 12) {
                    System.out.print("Select parameters: ");
                    value = reader.nextInt();
                } else {
                    value = 0;
                }

                switch (operation) {
                    case 0: {
                        System.out.println("Program exit");
                        continueOperations = false;
                        break;
                    }
                    case 1: {
                        myList.addFirst(value);
                        break;
                    }
                    case 2: {
                        myList.addLast(value);
                        break;
                    }
                    case 3: {
                        System.out.print("Select new data for " + value + 1 + " element: ");
                        int data = reader.nextInt();
                        myList.set(value, data);
                        break;
                    }
                    case 4: {
                        myList.delete(value);
                        break;
                    }
                    case 5: {
                        myList.extendToSize(value);
                        break;
                    }
                    case 6: {
                        myList.trimToSize(value);
                        break;
                    }
                    case 7: {
                        myList.displayElements();
                        break;
                    }
                    case 8: {
                        myList.displayElementsReversed();
                        break;
                    }
                    case 9: {
                        myList.sort();
                        break;
                    }
                    case 10: {
                        if (myList.isArrayEmpty())
                            System.out.println("Array is empty");
                        else {
                            System.out.println("Array is not empty");
                        }
                        break;
                    }
                    case 11: {
                        System.out.println("Occurrences of " + value + ": " +
                                myList.elementOccurrences(value) + " times.");
                        break;
                    }
                    case 12: {
                        logging = !logging;
                        myList.enableLogs(logging);
                        String logStatus;
                        logStatus = logging ? "enabled" : "disabled";
                        System.out.println("Logging " + logStatus);
                        break;
                    }
                    default: {
                        System.out.println("Wrong argument");
                        break;
                    }
                }
            }
        }
    }
}
