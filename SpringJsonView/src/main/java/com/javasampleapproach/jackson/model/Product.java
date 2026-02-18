package com.javasampleapproach.jackson.model;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonView;

public class Product {
	@JsonView()
	private int id;
	
	@JsonView()
    private String name;
    
	@JsonView()
    private Company company;
	
    public Product(){
    }
    
    public Product(int id, String name){
    	this.id = id;
    	this.name = name;
    }
    
    public Product(String name, Company company){
    	this.name = name;
    	this.company = company;
    }
    
    public void setId(int id){
    	this.id = id;
    }
    
    public int getId(){
    	return this.id;
    }
    
    // name
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    // products
    public void setCompany(Company company){
    	this.company = company;
    }
    
    public Company getCompany(){
    	return this.company;
    }
    
	public String toString() {
		String info = "";
		try {
			JSONObject jsonInfo = new JSONObject();
			jsonInfo.put("name", this.name);

			JSONObject companyObj = new JSONObject();
			companyObj.put("name", this.company.getName());
			jsonInfo.put("company", companyObj);

			info = jsonInfo.toString();
		} catch (JSONException e) {}
		
		return info;
	}
}
