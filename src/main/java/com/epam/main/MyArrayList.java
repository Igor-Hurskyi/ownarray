package com.epam.main;

/*
    1. Реализовать кастомний ArrayList( использовать массивы, клас Arrays).
    Для объектов класса ArrayList :
    1) добавление элементов(добавления элемента в начало списка,в конец списка).
    2) изменение/удаление элементов по индексу.
    3) увеличение листа на заданное количество элементов.
    4) уменьшение листа до заданного количество элементов.
    5) вывод элементов в консоль в прямом и обратном порядке.
    6) сортировка листа.
    7) определить операции проверки списка на пустоту.
    8) подсчет числа вхождений элемента в список.
    При удалении элемента не обнулять его, а удалять физически.
    Начальную размерность листа юзер вводит с консоли. Создать меню для работы с листом из консоли.
    Update:
      Организовать логирование операций. Формат логов: дата - название операции - данные
      В меню добавить пункт вывода логов в консоль
 */

import org.apache.commons.lang3.ArrayUtils;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class MyArrayList<E> {

    final static Logger logger = Logger.getLogger(MyArrayList.class);

    private Object[] elements; //Чому тут object, a не E[]?

    public MyArrayList(int capacity) {
        logger.info(capacity);

        if (capacity > 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "
                    + capacity);
        }
    }

    public void addToStart(E obj) {
        logger.info(obj);

        elements[0] = obj;
    }

    public void addtoEnd(E obj) {
        elements[elements.length - 1] = obj;
    }

    public void set(int index, E obj) {
        elements[index] = obj;
    }

    public void delete(int index) {
        elements[index] = null;
    }

    public void extendToSize(int size) {

    }

    public void trimToSize(int size) {
        //elements = size;
    }

    public void displayElements() {
        for (Object obj : elements) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    public void displayElementsReversed() {
        for (int i = elements.length; i >= 0; i--) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    public void sort() {
        Arrays.sort(elements);
    }

    public boolean isArrayEmpty() {
        for (Object obj : elements) {
            if (obj == null) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public int elementOccurrences(E obj) {
        int occurrences = 0;
        for (Object object : elements) {
            if (obj.equals(object)) {
                occurrences++;
            }
        }
        return occurrences;
    }

    public void showElement(int index) {
        System.out.println(elements[index]);
    }

    public int arrayLength() {
        return elements.length;
    }


}
