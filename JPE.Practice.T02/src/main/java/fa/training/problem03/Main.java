package fa.training.problem03;

import fa.training.problem03.dao.impl.OrderDaoImpl;
import fa.training.problem03.dao.impl.OrderDetailDaoImpl;
import fa.training.problem03.models.Order;
import fa.training.problem03.models.OrderDetail;
import fa.training.problem03.utils.DBConnection;
import fa.training.problem03.utils.ValueInput;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DBConnection db = new DBConnection();
        Connection connection = db.getConnection();

//        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/InventorySystem", "root", "nam01669383590.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return;
//        }
        ValueInput valueInput = new ValueInput();
        OrderDaoImpl orderDao = new OrderDaoImpl(connection);
        OrderDetailDaoImpl orderDetailDao = new OrderDetailDaoImpl(connection);

        while (true) {
            System.out.println("1. Create a new order");
            System.out.println("2. Create a new order detail");
            System.out.println("3. Total money");
            System.out.println("4. List order");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer id: ");
//                    String customerId = scanner.nextLine();
                    String customerId = valueInput.enterId();
                    System.out.print("Enter order date (yyyy-MM-dd): ");
                    String orderDateStr = valueInput.enterDate("order date").toString();
                    System.out.print("Enter required date (yyyy-MM-dd): ");
                    String requiredDateStr = valueInput.enterDate("required date").toString();
                    System.out.print("Enter shipped date (yyyy-MM-dd): ");
                    String shippedDateStr = valueInput.enterDate("shipped date").toString();
                    System.out.print("Enter ship address: ");
                    String shipAddress = scanner.nextLine();

                    try {
                        Date orderDate = new SimpleDateFormat("yyyy-MM-dd").parse(orderDateStr);
                        Date requiredDate = new SimpleDateFormat("yyyy-MM-dd").parse(requiredDateStr);
                        Date shippedDate = shippedDateStr.isEmpty() ? null : new SimpleDateFormat("yyyy-MM-dd").parse(shippedDateStr);

                        Order order = new Order();
                        order.setCustomerId(customerId);
                        order.setOrderDate(orderDate);
                        order.setRequiredDate(requiredDate);
                        order.setShippedDate(shippedDate);
                        order.setShipAddress(shipAddress);

                        String result = orderDao.saveOrder(order);
                        System.out.println("Save order result: " + result);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.print("Enter order id: ");
                    int orderDetailOrderId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter product id: ");
                    String productId = scanner.nextLine();
                    System.out.print("Enter unit price: ");
                    double unitPrice = scanner.nextDouble();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter discount: ");
                    float discount = scanner.nextFloat();

                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setOrderId(orderDetailOrderId);
                    orderDetail.setProductId(productId);
                    orderDetail.setUnitPrice(unitPrice);
                    orderDetail.setQuantity(quantity);
                    orderDetail.setDiscount(discount);

                    String detailResult = orderDetailDao.saveOrderDetail(orderDetail);
                    System.out.println("Save order detail result: " + detailResult);
                    break;
                case 3:
                    Map<String, Double> salesReport = orderDao.reportOfSale();
                    salesReport.forEach((customer, total) -> System.out.println("Customer: " + customer + ", Total: " + total));
                    break;
                case 4:
                    System.out.print("Enter customer id: ");
                    String customerIdForOrders = scanner.nextLine();
                    List<Order> orders = orderDao.findOrderByCustomer(customerIdForOrders);
                    orders.forEach(order -> System.out.println("Order ID: " + order.getOrderId() + ", Date: " + order.getOrderDate()));
                    break;
                case 5:
                    scanner.close();
                    try {
                        if (connection != null && !connection.isClosed()) {
                            connection.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
