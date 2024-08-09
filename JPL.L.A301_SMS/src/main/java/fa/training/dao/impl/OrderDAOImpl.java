package fa.training.dao.impl;

import fa.training.dao.OrderDAO;
import fa.training.entities.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/sms";
    private static final String USER = "root";
    private static final String PASSWORD = "nam01669383590.";

    @Override
    public List<Order> getAllOrdersByCustomerId(int customerId) {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Orders WHERE customer_id = ?")) {

            statement.setInt(1, customerId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int orderId = resultSet.getInt("order_id");
                Date orderDate = resultSet.getDate("order_date");
                int employeeId = resultSet.getInt("employee_id");
                double total = resultSet.getDouble("total");
                orders.add(new Order(orderId, orderDate, customerId, employeeId, total));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public boolean addOrder(Order order) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Orders (order_id, order_date, customer_id, employee_id, total) VALUES (?, ?, ?, ?, ?)")) {

            statement.setInt(1, order.getOrderId());
            statement.setDate(2, new java.sql.Date(order.getOrderDate().getTime()));
            statement.setInt(3, order.getCustomerId());
            statement.setInt(4, order.getEmployeeId());
            statement.setDouble(5, order.getTotal());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateOrderTotal(int orderId) {
        // Assuming there's a method to calculate the total from the line items
        double total = calculateTotal(orderId);
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("UPDATE Orders SET total = ? WHERE order_id = ?")) {

            statement.setDouble(1, total);
            statement.setInt(2, orderId);
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private double calculateTotal(int orderId) {
        double total = 0.0;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT price, quantity FROM LineItem WHERE order_id = ?")) {

            statement.setInt(1, orderId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                total += price * quantity;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
    @Override
    public Double computeOrderTotal(int orderId) {
        double total = 0.0;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT price, quantity FROM LineItem WHERE order_id = ?")) {

            statement.setInt(1, orderId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                total += price * quantity;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

}
