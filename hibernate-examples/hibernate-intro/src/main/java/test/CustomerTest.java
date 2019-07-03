package test;

import java.util.List;

import org.junit.Test;

import dao.CustomerDao;
import model.Customer;

public class CustomerTest {

	@Test
	public void testAdd() {
		Customer c = new Customer();
		c.setName("ggggg");
		c.setEmail("gggg@y111.com");
		c.setCity("gggg");
		// c.setDob(java.sql.Date.valueOf("1997-09-25"));
		CustomerDao dao = new CustomerDao();
		//dao.addInDatabase(c);
		dao.update(c);
	}

	@Test
	public void fetch() {
		//Customer c = new Customer();
		CustomerDao dao = new CustomerDao();
		dao.fetch();
		List<Customer> cu=dao.fetchCustomerByEmail("yahoo");
		for (Customer q:cu) {
			System.out.println(q.getId());
		System.out.println(q.getName());
		System.out.println(q.getCity());
		System.out.println(q.getEmail());
		System.out.println(q.getDob());
		}
	}
	@Test
	public void testUpdate() {
		
		CustomerDao dao = new CustomerDao();
		Customer c = (Customer) dao.fetch();
		c.setEmail("ssddd.i@gmail.com");
		c.setCity("Gujarat");
		
		dao.update(c);
	}

	@Test
	public void testDelete() {
		
		CustomerDao dao = new CustomerDao();
		List<Customer> c = dao.fetch();
		
		dao.delete(c);
	}

}
