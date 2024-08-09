package fa.training.common.utils;

import fa.training.dao.CustomerDAO;
import fa.training.dao.impl.CustomerDAOImpl;
import fa.training.entities.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InputValue {
    private CustomerDAO customerDAO = new CustomerDAOImpl();
    public boolean testDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    public boolean testCustomer(Customer customer) {
        if(customerDAO.getCustomerById(customer.getCustomerId())!=null) {
            System.out.println("Da co Customer co id " + customer.getCustomerId());
            return true;
        }
        return false;
    }
}
