package com.godoro.inventory.test;

import java.sql.SQLException;

import com.godoro.inventory.manager.ProductManager;

public class ProductDeleteTest {
	public static void main(String[] args) throws SQLException {
		ProductManager manager = new ProductManager();
		long productId = 4;
		boolean deleted = manager.delete(productId);
		System.out.println("Deleted? " + deleted);


	}
}
