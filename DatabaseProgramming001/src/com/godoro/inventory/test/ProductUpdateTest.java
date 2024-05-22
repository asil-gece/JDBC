package com.godoro.inventory.test;

import java.sql.SQLException;

import com.godoro.inventory.entity.Product;
import com.godoro.inventory.manager.ProductManager;

public class ProductUpdateTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Product product = new Product(9, "Notebook", 1200);
		ProductManager manager = new ProductManager();
		boolean updated= manager.update(product);
		System.out.println("updated?: " + updated);
	}
}
