package fa.training.dao;

import fa.training.entities.Customer;

import java.util.List;

public interface CustomerDAO {
    boolean addCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(int customerId);
    List<Customer> getAllCustomer();
    Customer getCustomerById(int customerId);
}
