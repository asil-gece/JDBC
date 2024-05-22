package com.godoro.inventory.test;

import java.sql.SQLException;
import java.util.List;

import com.godoro.inventory.entity.Product;
import com.godoro.inventory.manager.ProductManager;

public class ProductConditionTest {
	public static void main(String[] args) throws SQLException {
		ProductManager manager = new ProductManager();
		double salesPrice = 400;
		List<Product> productList = manager.listBySalesGretaer(salesPrice);
		for(Product product: productList) {
			System.out.println(product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice());
		}
	}
}
