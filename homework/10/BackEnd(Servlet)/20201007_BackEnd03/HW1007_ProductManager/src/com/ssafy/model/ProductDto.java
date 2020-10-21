package com.ssafy.model;

public class ProductDto {

	private int product_id;
	private String name;
	private String type;
	private int price;
	private int amount;

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ProductDto [product_id=" + product_id + ", name=" + name + ", type=" + type + ", price=" + price
				+ ", amount=" + amount + "]";
	}

}
