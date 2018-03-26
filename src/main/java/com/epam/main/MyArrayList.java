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

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class MyArrayList<E> {

	private static final Logger logger = Logger.getLogger(MyArrayList.class);

	private static final int DEFAULT_SIZE = 10;

	private Object[] elements; //Чому тут object, a не E[]?

	public MyArrayList() {
		logger.info("default size");
		elements = new Object[DEFAULT_SIZE];
	}

	public MyArrayList(int capacity) {
		logger.info(capacity);
		if (capacity > 0) {
			elements = new Object[capacity];
		} else {
			throw new IllegalArgumentException("Illegal Capacity: "
					+ capacity);
		}
	}

	public void addFirst(E obj) {
		logger.info(obj);
		elements[0] = obj;
	}

	public void addLast(E obj) {
		logger.info(obj);
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] != null) {
				continue;
			} else {
				elements[i] = obj;
				break;
			}
		}
	}

	public void set(int index, E obj) {
		logger.info(String.format("index: %s, object: %s", index, obj));
		elements[index] = obj;
	}

	public void delete(int index) {
		logger.info(index);
		elements[index] = null;
		System.arraycopy(elements, index + 1, elements, index, elements.length - (index + 1));
		trimToSize(elements.length - 1);
	}

	public void extendToSize(int size) {
		if (size < elements.length) return;
		logger.info(size);
		elements = Arrays.copyOf(elements, size);
	}

	public void trimToSize(int size) {
		if (size > elements.length) return;
		logger.info(size);
		elements = Arrays.copyOf(elements, size);
	}

	public void displayElements() {
		logger.info("no data");
		for (Object obj : elements) {
			System.out.print("[" + obj + "] ");
		}
		System.out.println();
	}

	public void displayElementsReversed() {
		logger.info("no data");
		for (int i = elements.length - 1; i >= 0; i--) {
			System.out.print("[" + elements[i] + "] ");
		}
		System.out.println();
	}

	public void sort() {
		logger.info("no data");
		Arrays.sort(elements);
	}

	public boolean isArrayEmpty() {
		logger.info("no data");
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
		logger.info(obj);
		int occurrences = 0;
		for (Object object : elements) {
			if (obj.equals(object)) {
				occurrences++;
			}
		}
		return occurrences;
	}

	public void enableLogs(boolean logging) {
		if (logging == false) {
			logger.setLevel(Level.FATAL);
		} else {
			logger.setLevel(Level.INFO);
		}
	}
}
