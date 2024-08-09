import static org.junit.Assert.*;

import fa.training.dao.CustomerDAO;
import fa.training.dao.LineItemDAO;
import fa.training.dao.OrderDAO;
import fa.training.dao.ProductDAO;
import fa.training.dao.impl.CustomerDAOImpl;
import fa.training.dao.impl.LineItemDAOImpl;
import fa.training.dao.impl.OrderDAOImpl;
import fa.training.dao.impl.ProductDAOImpl;
import fa.training.entities.Customer;
import fa.training.entities.LineItem;
import fa.training.entities.Order;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DatabaseTest {

    private CustomerDAO customerDAO;
    private OrderDAO orderDAO;
    private ProductDAO productDAO;
    private LineItemDAO lineItemDAO;

    @Before
    public void setUp() {
        customerDAO = new CustomerDAOImpl();
        orderDAO = new OrderDAOImpl();
        productDAO = new ProductDAOImpl();
        lineItemDAO = new LineItemDAOImpl();
    }

    @Test
    public void testAddCustomer() {
        Customer customer = new Customer(1, "John Doe");
        assertTrue(customerDAO.addCustomer(customer));
    }

    @Test
    public void testAddOrder() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse("2023-07-04");
        } catch (ParseException e) {
            e.printStackTrace();
            fail("Date parsing failed");
        }
        Order order = new Order(5, date, 1,1, 100.0);
        assertTrue(orderDAO.addOrder(order));
    }

    @Test
    public void testAddLineItem() {
        LineItem item = new LineItem(1, 1, 2, 50.0);
        assertTrue(lineItemDAO.addLineItem(item));
    }

    @Test
    public void testUpdateOrderTotal() {
        assertTrue(orderDAO.updateOrderTotal(1));
    }

    @Test
    public void testGetAllOrdersByCustomerId() {
        List<Order> orders = orderDAO.getAllOrdersByCustomerId(1);
        assertNotNull(orders);
        assertFalse(orders.isEmpty());
    }

    @Test
    public void testGetAllItemsByOrderId() {
        List<LineItem> items = lineItemDAO.getAllItemsByOrderId(1);
        assertNotNull(items);
        assertFalse(items.isEmpty());
    }

    @Test
    public void testGetAllCustomer() {
        List<Customer> customers = customerDAO.getAllCustomer();
        assertNotNull(customers);
        assertFalse(customers.isEmpty());
    }

    @Test
    public void testComputeOrderTotal() {
        Double total = orderDAO.computeOrderTotal(1);
        assertNotNull(total);
        assertEquals(100.0, total, 0);
    }

    @Test
    public void testUpdateCustomer() {
        Customer customer = new Customer(1, "John Doe Updated");
        assertTrue(customerDAO.updateCustomer(customer));
    }

    @Test
    public void testDeleteCustomer() {
        assertTrue(customerDAO.deleteCustomer(1));
    }
}
