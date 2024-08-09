package fa.training.dao.impl;

import fa.training.dao.LineItemDAO;
import fa.training.entities.LineItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LineItemDAOImpl implements LineItemDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/sms";
    private static final String USER = "root";
    private static final String PASSWORD = "nam01669383590.";

    @Override
    public boolean addLineItem(LineItem item) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO LineItem (order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)")) {

            statement.setInt(1, item.getOrderId());
            statement.setInt(2, item.getProductId());
            statement.setInt(3, item.getQuantity());
            statement.setDouble(4, item.getPrice());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<LineItem> getAllItemsByOrderId(int orderId) {
        List<LineItem> items = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM LineItem WHERE order_id = ?")) {

            statement.setInt(1, orderId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");
                items.add(new LineItem(orderId, productId, quantity, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
}
