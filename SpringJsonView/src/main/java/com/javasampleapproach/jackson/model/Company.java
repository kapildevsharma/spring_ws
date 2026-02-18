package com.javasampleapproach.jackson.model;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonView;

public class Company {
	@JsonView()
	private int id;
	
	@JsonView()
    private String name;

	@JsonView()
    private List<Product> products;
	
    public Company(){
    }
    
    public Company(int id, String name, List<Product> products){
    	this.id = id;
    	this.name = name;
    	this.products = products;
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
    public void setProducts(List<Product> products){
    	this.products = products;
    }
    
    public List<Product> getProducts(){
    	return this.products;
    }

    /**
     * 
     * Show Overal View
     */
	public String overalViewString() throws JSONException {
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("name", this.name);
        
        JSONArray productArray = new JSONArray();
        if(this.products != null){
            this.products.forEach(product->{
                JSONObject subJson = new JSONObject();
                try {
					subJson.put("name", product.getName());
				} catch (JSONException e) {}
                productArray.put(subJson);
            });
        }
        jsonInfo.put("products", productArray);
        
        return jsonInfo.toString();
	}
	
	/**
	 * 
	 * Show Detail View
	 */
	public String detailViewString() throws JSONException {
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("id",this.id);
        jsonInfo.put("name",this.name);
        
        JSONArray productArray = new JSONArray();
        if(this.products != null){
            this.products.forEach(product->{
                JSONObject subJson = new JSONObject();
                try {
                	subJson.put("id", product.getId());
					subJson.put("name", product.getName());
				} catch (JSONException e) {}
                productArray.put(subJson);
            });
        }
        jsonInfo.put("products", productArray);
        
        return jsonInfo.toString();
	}

}