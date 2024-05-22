package com.godoro.inventory.test;

import java.sql.SQLException;

import com.godoro.inventory.entity.Product;
import com.godoro.inventory.manager.ProductManager;

public class ProductFindTest {
	public static void main(String[] args) throws SQLException {
		ProductManager manager = new ProductManager();
		long productId = 11;
		Product product = manager.find(productId);

		if (product != null) {
			System.out.println(product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice());
		}else {
			System.out.println("Product has not been found " + productId );
		}
	}

}
