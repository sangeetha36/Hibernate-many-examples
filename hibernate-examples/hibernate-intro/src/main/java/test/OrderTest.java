package test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.lti.entity.Order;

import dao.CustomerDao;
import dao.GenericDao;
import model.Customer;

public class OrderTest {

	@Test
	public void placeOrder() {
		
		GenericDao dao = new GenericDao();
		Customer cust = (Customer) dao.fetchById(Customer.class, 23);
		
		Order o = new Order();
		
		o.setOrderDate(new Date());
		o.setAmount(4500);		 
		o.setCustomer(cust);
		dao.save(o);
	}

	
	@Test
	public void fetchOrders() {
		
		GenericDao dao = new GenericDao();
		List<Order> orders= dao.fetchAll(Order.class);
		
		for(Order order : orders) {

		System.out.println(order.getId());
		System.out.println(order.getOrderDate());
		System.out.println(order.getAmount());
		System.out.println(order.getCustomer().getEmail());
		System.out.println(order.getCustomer().getCity());
		System.out.println(order.getCustomer().getName());;
		
		}
	}
}
