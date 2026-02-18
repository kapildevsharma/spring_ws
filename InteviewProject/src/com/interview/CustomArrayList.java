package com.interview;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;

public class CustomArrayList<E> extends AbstractList<E>{
	
	private static final int DEFAULT_CAPACITY = 10;
	private Object []elements;
	private int size = 0;
	
	public CustomArrayList() {
		elements = new Object[DEFAULT_CAPACITY];
	}
	
	public CustomArrayList(int capacity) {
		elements = new Object[capacity];
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		if(index>=size || index<0) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
		}
		return (E)elements[index];
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public void add(int index, E element) {
		if(index>size || index<0) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
		}
		ensureCapacity();
		
		for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
		
		elements[index] = element;
		size++;
	}
	
	private void ensureCapacity() {
		System.out.println(size+" and "+DEFAULT_CAPACITY+" element size="+elements.length);
		if(size>0 && size%10 == 0) {
			int newSize = elements.length*2;
			elements = Arrays.copyOf(elements, newSize);
		}
	}
	
	public static void main(String[] args) {
		List<Integer> list = new CustomArrayList<>();
		list.add(10);
		list.add(30);
		list.add(20);
		System.out.println(list);
	}

}
