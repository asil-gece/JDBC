package com.godoro.inventory.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.godoro.inventory.entity.Product;
import com.godoro.library.database.DatabaseUtilities;

public class ProductManager {
	// Insertion
	public boolean insert(Product product) throws ClassNotFoundException, SQLException {
		// Connection to the database

		Connection connection = null;
		try {
			connection = DatabaseUtilities.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		// Insertion process
		String sql = "insert into Product(productName,salesPrice) values (?,?)";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, product.getProductName());
		statement.setDouble(2, product.getSalesPrice());
		int affected = statement.executeUpdate();

		// Closing Database
		connection.close();

		return affected == 1 ? true : false;
	}

	// Update
	public boolean update(Product product) throws ClassNotFoundException, SQLException {
		// Connection to the database

		Connection connection = null;
		try {
			connection = DatabaseUtilities.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		// Updating process
		String sql = "update Product set productName=?, salesPrice=? where productID=?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, product.getProductName());
		statement.setDouble(2, product.getSalesPrice());
		statement.setLong(3, product.getProductId());
		int affected = statement.executeUpdate();

		// Closing Database
		connection.close();

		return affected == 1 ? true : false;
	}

	// Finding product
	public Product find(long productId) throws SQLException {
		Product product = null;

		Connection connection = null;
		try {
			connection = DatabaseUtilities.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		String sql = "select * from Product where productId=?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, productId);

		// getting the features of the table
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {

			String productName = resultSet.getString("productName");
			double salesPrice = resultSet.getDouble("salesPrice");
			Long productId1 = resultSet.getLong("ProductId");
			product = new Product();
			product.setProductName(productName);
			product.setSalesPrice(salesPrice);
			product.setProductId(productId1);
		}
		// Closing Database
		connection.close();

		return product;

	}

	// Deleting product
	public boolean delete(long productId) throws SQLException {
		Connection connection = null;
		try {
			connection = DatabaseUtilities.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		String sql = "delete from Product where productId=?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, productId);
		int affected = statement.executeUpdate();
		return affected == 1 ? true : false;

	}

	public List<Product> list() throws SQLException {

		Connection connection = null;
		try {
			connection = DatabaseUtilities.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		List<Product> productList = new ArrayList<Product>();

		String sql = "select * from Product";

		PreparedStatement statement = connection.prepareStatement(sql);

		// getting the features of the table
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			Product product = new Product();
			String productName = resultSet.getString("productName");
			double salesPrice = resultSet.getDouble("salesPrice");
			Long productId = resultSet.getLong("ProductId");
			product = new Product();
			product.setProductName(productName);
			product.setSalesPrice(salesPrice);
			product.setProductId(productId);
			productList.add(product);
		}
		// Closing Database
		connection.close();
		return productList;
	}

	//Listing by condition
	public List<Product> listBySalesGretaer(double salesPrice) throws SQLException {

		Connection connection = null;
		try {
			connection = DatabaseUtilities.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		List<Product> productList = new ArrayList<Product>();

		String sql = "select * from Product where salesPrice>=?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setDouble(1, salesPrice);
		// getting the features of the table
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			Product product = new Product();
			product.setProductId(resultSet.getLong("productId"));
			product.setProductName(resultSet.getString("productName"));
			product.setSalesPrice(resultSet.getDouble("salesPrice"));
			productList.add(product);
		}
		// Closing Database
		connection.close();
		return productList;
	}
	
	//Listing with Like Operator
	public List<Product> listProductNameLike(String productNamePattern) throws SQLException {

		Connection connection = null;
		try {
			connection = DatabaseUtilities.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		List<Product> productList = new ArrayList<Product>();

		String sql = "select * from Product where productName like ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, productNamePattern);
		// getting the features of the table
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			Product product = new Product();
			product.setProductId(resultSet.getLong("productId"));
			product.setProductName(resultSet.getString("productName"));
			product.setSalesPrice(resultSet.getDouble("salesPrice"));
			productList.add(product);
		}
		// Closing Database
		connection.close();
		return productList;
	}

	//Filtering based on price and like operator
	public List<Product> listByFilter(String productNamePattern, double salesPrice) throws SQLException {

		Connection connection = null;
		try {
			connection = DatabaseUtilities.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		List<Product> productList = new ArrayList<Product>();

		String sql = "select * from Product where productName like ? or salesPrice>=?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, productNamePattern);
		statement.setDouble(2, salesPrice);
		// getting the features of the table
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			Product product = new Product();
			product.setProductId(resultSet.getLong("productId"));
			product.setProductName(resultSet.getString("productName"));
			product.setSalesPrice(resultSet.getDouble("salesPrice"));
			productList.add(product);
		}
		// Closing Database
		connection.close();
		return productList;
	}

}
