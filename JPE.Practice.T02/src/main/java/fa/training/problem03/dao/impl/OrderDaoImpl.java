package fa.training.problem03.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fa.training.problem03.dao.OrderDao;
import fa.training.problem03.models.Order;

public class OrderDaoImpl implements OrderDao {
    private Connection connection;

    public OrderDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public String saveOrder(Order order) {
        try {
            String query = "INSERT INTO Orders (customer_id, order_date, required_date, shipped_date, ship_address) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, order.getCustomerId());
            pstmt.setTimestamp(2, new Timestamp(order.getOrderDate().getTime()));
            pstmt.setTimestamp(3, new Timestamp(order.getRequiredDate().getTime()));
            pstmt.setTimestamp(4, order.getShippedDate() != null ? new Timestamp(order.getShippedDate().getTime()) : null);
            pstmt.setString(5, order.getShipAddress());
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                order.setOrderId(rs.getInt(1));
            }
            return "success";
        } catch (SQLException e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public List<Order> findOrderByCustomer(String customerId) {
        List<Order> orders = new ArrayList<>();
        try {
            String query = "SELECT * FROM Orders WHERE customer_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, customerId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setOrderId(rs.getInt("order_id"));
                order.setCustomerId(rs.getString("customer_id"));
                order.setOrderDate(rs.getTimestamp("order_date"));
                order.setRequiredDate(rs.getTimestamp("required_date"));
                order.setShippedDate(rs.getTimestamp("shipped_date"));
                order.setShipAddress(rs.getString("ship_address"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
    public Map<String, Double> reportOfSale() {
        String query = "SELECT o.customer_id, SUM(od.quantity * od.unit_price * (1 - od.discount)) AS total " +
                "FROM Orders o " +
                "JOIN OrderDetails od ON o.order_id = od.order_id " +
                "GROUP BY o.customer_id";
        Map<String, Double> report = new HashMap<>();
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                report.put(resultSet.getString("customer_id"), resultSet.getDouble("total"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return report;
    }
}
