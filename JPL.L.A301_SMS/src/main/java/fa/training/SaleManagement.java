package fa.training;

import fa.training.common.utils.InputValue;
import fa.training.dao.*;
import fa.training.dao.impl.*;
import fa.training.entities.*;

import java.util.Date;
import java.util.List;

public class SaleManagement {
    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        OrderDAO orderDAO = new OrderDAOImpl();
        ProductDAO productDAO = new ProductDAOImpl();
        LineItemDAO lineItemDAO = new LineItemDAOImpl();
        InputValue inputValue = new InputValue();
        // Add a customer
        Customer customer = new Customer(1, "Nghiem Van Nam");
        if(inputValue.testCustomer(customer)){
            System.out.println("Da co Customer co id " + customer.getCustomerId());
        }
        else customerDAO.addCustomer(customer);

        // Add a product
//        Product product = new Product(1, "Laptop", 1000.0);
//        productDAO.addProduct(product);

//         Create an order
//        Order order = new Order(3, new Date(), 1, 1, 0.0);
//        orderDAO.addOrder(order);
//
//        // Add a line item
//        LineItem lineItem = new LineItem(1, 1, 2, 1000.0);
//        lineItemDAO.addLineItem(lineItem);

        // Update order total
        orderDAO.updateOrderTotal(1);

        // List all orders by customer ID
        List<Order> orders = orderDAO.getAllOrdersByCustomerId(1);
        for (Order o : orders) {
            System.out.println(o.getOrderId() + " - " + o.getOrderDate() + " - " + o.getTotal());
        }

        // List all line items for an order
        List<LineItem> items = lineItemDAO.getAllItemsByOrderId(1);
        for (LineItem i : items) {
            System.out.println(i.getOrderId() + " - " + i.getProductId() + " - " + i.getQuantity() + " - " + i.getPrice());
        }

        // List all customers
        List<Customer> customers = customerDAO.getAllCustomer();
        for (Customer c : customers) {
            System.out.println(c.getCustomerId() + " - " + c.getCustomerName());
        }

        // Compute order total
        Double total = orderDAO.computeOrderTotal(1);
        System.out.println("Order total: " + total);

        // Update a customer
//        customer.setCustomerName("Thu Ha");
//        customerDAO.updateCustomer(customer);

        // Delete a customer
//        customerDAO.deleteCustomer(1);
    }
}
