package com.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Product implements Comparable<Product>{
	
	private int id;
	private String productName;
	private double productPrice;
	
	Product(int id, String productName, double productPrice){
		this.id = id;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}


	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}


	/**
	 * @return the productPrice
	 */
	public double getProductPrice() {
		return productPrice;
	}


	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


	@Override
	public int compareTo(Product o) {
		if(productPrice == o.getProductPrice()) {
			return 0;
		}else if(productPrice < o.getProductPrice()) {
			return 1;
		}else {
			return -1;
		}
	}
	
	public static void main(String[] args) {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "A", 10.0));
		list.add(new Product(2, "B", 20.0));
		list.add(new Product(3, "C", 50.0));
		list.add(new Product(4, "D", 30.0));
		list.add(new Product(5, "F", 40.0));
		Collections.sort(list);
		list.stream().forEach(p->System.out.println(p.getProductPrice()));
	}

}
