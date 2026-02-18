package com.interview;

import java.util.ArrayList;

public class EClinicWorksR3Interview {
	public static void main(String[] args) {
		ArrayList<Product> list = new ArrayList<Product>();
		
		list.add(new Product(1, "A", 10.0));
		list.add(new Product(2, "B", 20.0));
		list.add(new Product(3, "C", 30.0));
		list.add(new Product(4, "D", 40.0));
		
		for(Product product: list) {
			if(product.getId() == 2) {
				product.setProductName("BB");
			}
		}
		
		list.stream().map(p->{
			if(p.getId() == 1) {
				p.setProductName("AA");
			}
			return p;
		});
		
		list.stream().forEach(o->System.err.println(o.getProductName()));
		
	}
	
	
}
