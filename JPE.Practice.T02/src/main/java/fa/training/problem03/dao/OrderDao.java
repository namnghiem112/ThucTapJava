package fa.training.problem03.dao;

import java.util.List;
import fa.training.problem03.models.Order;

public interface OrderDao {
    String saveOrder(Order order);
    List<Order> findOrderByCustomer(String customerId);
}
