package com.jsp.service;

import java.util.Scanner;

import com.jsp.dao.CartDao;
import com.jsp.entity.Cart;
public class Cartservice {

private	CartDao CartDao;

	public CartDao getCartDao() {
	return CartDao;
}

public void setCartDao(CartDao cartDao) {
	CartDao = cartDao;
}

	public void createcart() {
		Scanner scanner =new Scanner(System.in);
		Cart cart =new Cart();
		System.out.println("Enter the cart id");
		cart.setCartId(scanner.nextInt());
		try {
			CartDao.createCart(cart);
		} catch (Exception e) {
			System.out.println("duplicate cart id");
		}}
	
	public void addProductToCart() {
		Scanner scanner =new Scanner(System.in);
		
		System.out.println("Enter the cart ID");
		int cart=scanner.nextInt();
		System.out.println("Enter the product ID");
		int product=scanner.nextInt();
	try {
		CartDao.addProductToCart(cart, product);
	} catch (Exception e) {
		System.out.println("that product is not available");
	}}
	
	public  void removeProductFromCart() {
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter the cart ID");
		int cart=scanner.nextInt();
		System.out.println("Enter the product ID");
		int product=scanner.nextInt();
		try {
			CartDao.removeProductFromCart(cart, product);
		} catch (Exception e) {
			System.out.println("that product is not available");
		}}
	
	public void deleteTheCart() {
	
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter the cart ID");
		int cart=scanner.nextInt();
	    CartDao.deleteTheCart(cart);
		}}
	

	
	





