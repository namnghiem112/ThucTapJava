package fa.training.problem03.dao;

import java.util.List;
import fa.training.problem03.models.OrderDetail;

public interface OrderDetailDao {
    String saveOrderDetail(OrderDetail orderDetail);
    List<OrderDetail> findOrderDetailsByOrderId(int orderId);
}
