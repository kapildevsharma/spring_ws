package com.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductComparator {
	public static void main(String[] args) {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "A", 10.0));
		list.add(new Product(2, "B", 20.0));
		list.add(new Product(3, "E", 50.0));
		list.add(new Product(4, "D", 30.0));
		list.add(new Product(5, "F", 40.0));
		Collections.sort(list, new NameComparator());
		list.stream().forEach(p -> System.out.println(p.getProductPrice()));
	}
}
