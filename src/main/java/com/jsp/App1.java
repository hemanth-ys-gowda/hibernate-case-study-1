package com.jsp;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.jsp.service.Cartservice;
import com.jsp.service.Productservice;

public class App1 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Productservice Productservice = context.getBean(Productservice.class);
		Cartservice Cartservice = context.getBean(Cartservice.class);

		Scanner sc=new Scanner(System.in);
        System.out.print("1.To addProduct\n"+ "2.To get product by id\n"+ "3.To get All products\n"+ "4.To update product\n"
+ "5.To Delete product\n"+"6.To create cart\n"+"7.To add product to cart\n"+"8.To remove the product from cart\n"
        		+"9.To delete the cart\n");
        int choice=sc.nextInt();
        
        switch(choice)
        {
        	case 1:Productservice.addProduct();
        	break;
	        case 2: Productservice.getProductById();
        	break;
        	case 3: Productservice.getAllProduct();
        	break;
        	
        	case 4:Productservice.updateProduct();
        	break;
        	
        	case 5:Productservice.deleteProduct();
        	break;
        
        	case 6: Cartservice.createcart();
        	break;
        	
        	case 7: Cartservice.addProductToCart();
        	break;
        	
        	case 8:Cartservice.removeProductFromCart();
        	break;
        	
        	case 9:Cartservice.deleteTheCart();
        	break;
        
        	default:
        		System.err.println("Invalid Choice");
        }
		
	}
}
