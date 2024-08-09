package fa.training.problem03.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fa.training.problem03.dao.OrderDetailDao;
import fa.training.problem03.models.OrderDetail;

public class OrderDetailDaoImpl implements OrderDetailDao {
    private Connection connection;

    public OrderDetailDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public String saveOrderDetail(OrderDetail orderDetail) {
        try {
            String query = "INSERT INTO OrderDetails (order_id, product_id, unit_price, quantity, discount) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, orderDetail.getOrderId());
            pstmt.setString(2, orderDetail.getProductId());
            pstmt.setDouble(3, orderDetail.getUnitPrice());
            pstmt.setInt(4, orderDetail.getQuantity());
            pstmt.setFloat(5, orderDetail.getDiscount());
            pstmt.executeUpdate();
            return "success";
        } catch (SQLException e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public List<OrderDetail> findOrderDetailsByOrderId(int orderId) {
        List<OrderDetail> orderDetails = new ArrayList<>();
        try {
            String query = "SELECT * FROM OrderDetails WHERE order_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, orderId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderDetailId(rs.getInt("order_detail_id"));
                orderDetail.setOrderId(rs.getInt("order_id"));
                orderDetail.setProductId(rs.getString("product_id"));
                orderDetail.setUnitPrice(rs.getDouble("unit_price"));
                orderDetail.setQuantity(rs.getInt("quantity"));
                orderDetail.setDiscount(rs.getFloat("discount"));
                orderDetails.add(orderDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDetails;
    }
}
