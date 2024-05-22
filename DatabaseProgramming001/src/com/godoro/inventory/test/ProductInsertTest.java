package com.godoro.inventory.test;

import java.sql.SQLException;

import com.godoro.inventory.entity.Product;
import com.godoro.inventory.manager.ProductManager;

public class ProductInsertTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Product product = new Product(0, "Training Set", 100);
		ProductManager manager = new ProductManager();
		boolean inserted= manager.insert(product);
		System.out.println("Inserted: " + inserted);
	}
}
