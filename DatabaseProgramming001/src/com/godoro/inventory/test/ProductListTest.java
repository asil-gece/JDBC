package com.godoro.inventory.test;

import java.sql.SQLException;
import java.util.List;

import com.godoro.inventory.entity.Product;
import com.godoro.inventory.manager.ProductManager;

public class ProductListTest {

	public static void main(String[] args) throws SQLException {
		ProductManager manager = new ProductManager();
		List<Product> productList = manager.list();
		for(Product product: productList) {
			System.out.println(product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice());
		}
	}
}
