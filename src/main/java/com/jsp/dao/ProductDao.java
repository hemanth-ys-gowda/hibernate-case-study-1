package com.jsp.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.entity.Product;

public class ProductDao {

	
	public  SessionFactory sFactory() {
		Configuration cfg=new Configuration().configure().addAnnotatedClass(Product.class);
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		return sessionFactory;
	}
	
	public  void addProduct(Product product) {
		Session session = sFactory().openSession();
		Transaction tr = session.beginTransaction();
		session.save(product);
		tr.commit();
		session.close();}
	
	
	public Product getProductById(int productId) {
		Session session = sFactory().openSession();
		Transaction tr = session.beginTransaction();
		System.out.println("Enter the product id");
		Product product = session.get(Product.class,productId);
		tr.commit();
		session.close();
		
		return product;
	}
	
	public  List<Product> getAllProduct() {
		Session session = sFactory().openSession();
		Transaction tr = session.beginTransaction();
		Query<Product> query = session.createQuery("From Product");
		List<Product> list = query.list();
		tr.commit();
		session.close();
	return list;	
	}
		
	public  void updateProduct(Product product) {
		Session session = sFactory().openSession();
		Transaction tr = session.beginTransaction();
		session.update(product);
		tr.commit();
		session.close();}
		
	public  void deleteProduct(Product product) {

		Session session = sFactory().openSession();
		Transaction tr = session.beginTransaction();
		session.delete(product);
		tr.commit();
		session.close();
	}	
}



















