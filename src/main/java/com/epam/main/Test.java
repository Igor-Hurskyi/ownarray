package com.epam.main;

import com.epam.main.MyArrayList;

public class Test {

    public static void main(String[] args) {
        MyArrayList<Integer> mylist = new MyArrayList<>(10);
        mylist.addToStart(6);
        mylist.displayElements();
        System.out.println();
    }
}
