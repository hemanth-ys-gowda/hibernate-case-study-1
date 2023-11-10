package com.jsp.service;



import java.util.List;
import java.util.Scanner;

import org.hibernate.query.Query;

import com.jsp.dao.ProductDao;
import com.jsp.entity.Product;

public class Productservice {

private	ProductDao ProductDao;

	public ProductDao getProductDao() {
	return ProductDao;
}

public void setProductDao(ProductDao productDao) {
	ProductDao = productDao;
}

	public  void addProduct() {
		Scanner scanner =new Scanner(System.in);
		
		Product product=new Product();
		System.out.println("Enter the product id");
		product.setProductId(scanner.nextInt());
		System.out.println("Enter the product name");
		product.setProductName(scanner.next());
		System.out.println("Enter the product price");
		product.setProductPrice(scanner.nextDouble());
		System.out.println("Enter the product Quantity");
		product.setProductQuantity(scanner.nextInt());
		
		ProductDao.addProduct(product);
		}
	
	public  void getProductById() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the product id");
	Product productId = ProductDao.getProductById(scanner.nextInt());
	if(productId!=null) {
		System.out.println(productId.getProductId()+" "+productId.getProductName()+" "+productId.getProductPrice()+" "+productId.getProductQuantity());
	}
	else {
		System.out.println("id is not found");}
	
	}
	
	public   void getAllProduct() {
	
		  List<Product> list = ProductDao.getAllProduct();
		
		for(Product product:list) {
			System.out.println(product.getProductId()+" "+product.getProductName()+"  "+product.getProductPrice()+"  "+product.getProductQuantity());
		}
	}
	
	public  void updateProduct() {
		ProductDao.getAllProduct();
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the product id");
		Product product = ProductDao.getProductById(scanner.nextInt());
		if(product!=null)
		{
			System.out.println(product.getProductName()+"  "+product.getProductPrice()+"  "+product.getProductQuantity());
			
			
			System.out.println("Enter Product Name");
			String pName = scanner.next();
			
			System.out.println("Enter product price");
			double pPrice=scanner.nextDouble();
			
			System.out.println("Enter Quantity of Products");
			int pQnty=scanner.nextInt();
			
			product.setProductName(pName);
			product.setProductPrice(pPrice);
			product.setProductQuantity(pQnty);
			
			ProductDao.updateProduct(product);
			
		}
		else {
			System.err.println("product not present");}
		}
	
	public  void deleteProduct() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter product id");
		int pId = scanner.nextInt();

		Product product = ProductDao.getProductById(pId);

		if(product!=null)
		{
			
			System.out.println("product deleted successfully!!!");
		}
		else {
			System.err.println("product not present");
		}
	
	
}}













