package com.jsp.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.jsp.entity.Cart;
import com.jsp.entity.Product;
import com.jsp.service.Productservice;


public class CartDao {

	public SessionFactory sFactory() {
		Configuration cfg=new Configuration().configure().addAnnotatedClass(Cart.class).addAnnotatedClass(Product.class);
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		return sessionFactory;
	}
	public  void createCart(Cart cart) {
		Session session = sFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(cart);
		transaction.commit();
		session.close();
	}
	
	
	public  void addProductToCart(int cartId,int productId) {
		Session session = sFactory().openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("enter the cart number");
	    Cart cart = session.get(Cart.class,cartId);	
	    if(cart!=null) {
	    cart.setCartId(cartId);
	    System.out.println("select the product ID to add to cart");
		Product product= session.get(Product.class,productId);
	    if (product!=null) {
		cart.getProducts().add(product);
	    session.update(cart);}
	    else 
			System.out.println("Invalid product id");
	    }else 
			System.out.println("Ivalid cart id");
		
		transaction.commit();
		session.close();
	}
	
	public  void removeProductFromCart(int cartId,int productId) {
		Session session = sFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Cart cart = session.get(Cart.class,cartId);
		if(cart!=null) {
		Product product = session.get(Product.class,productId);
		if (product!=null) {
		cart.getProducts().remove(product);
		session.update(cart);
		} else 
		System.out.println("Invalid product id");
		}else 
		System.out.println("Ivalid cart id");
		
		transaction.commit();
		session.close();
		
	}
	
	public  void deleteTheCart(int cartId) {
		Session session = sFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Cart cart = session.get(Cart.class,cartId);
		session.delete(cart);
		transaction.commit();
		session.close();
		
	}
	
	
}





