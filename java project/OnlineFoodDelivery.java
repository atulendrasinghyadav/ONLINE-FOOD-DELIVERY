import java.sql.*;
import java.util.Scanner;

public class OnlineFoodDelivery {

    // JDBC URL, username, password
    private static final String DB_URL = "jdbc:mysql://localhost:3306/FoodDeliveryDB";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Anubhav@2007";

    // Main menu
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Welcome to Online Food Delivery System!");
            boolean exit = false;

            while (!exit) {
                System.out.println("\nMenu:");
                System.out.println("1. Add Contact Details");
                System.out.println("2. Place an Order");
                System.out.println("3. View All Orders");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        addContactDetails(connection, scanner);
                        break;
                    case 2:
                        placeOrder(connection, scanner);
                        break;
                    case 3:
                        viewOrders(connection);
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to add contact details
    private static void addContactDetails(Connection connection, Scanner scanner) {
        try {
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            System.out.print("Enter Phone Number: ");
            String phone = scanner.nextLine();

            String sql = "INSERT INTO ContactDetails (Name, Email, PhoneNumber) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, name);
                statement.setString(2, email);
                statement.setString(3, phone);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Contact details added successfully!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to place an order
    private static void placeOrder(Connection connection, Scanner scanner) {
        try {
            System.out.print("Enter Contact ID: ");
            int contactId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Food Item: ");
            String foodItem = scanner.nextLine();
            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();
            System.out.print("Enter Total Price: ");
            double totalPrice = scanner.nextDouble();

            String sql = "INSERT INTO OrderDetails (ContactID, FoodItem, Quantity, TotalPrice) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, contactId);
                statement.setString(2, foodItem);
                statement.setInt(3, quantity);
                statement.setDouble(4, totalPrice);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Order placed successfully!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to view all orders
    private static void viewOrders(Connection connection) {
        String sql = "SELECT o.OrderID, c.Name, o.FoodItem, o.Quantity, o.TotalPrice " +
                     "FROM OrderDetails o JOIN ContactDetails c ON o.ContactID = c.ContactID";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            System.out.println("\nOrder Details:");
            while (resultSet.next()) {
                int orderId = resultSet.getInt("OrderID");
                String name = resultSet.getString("Name");
                String foodItem = resultSet.getString("FoodItem");
                int quantity = resultSet.getInt("Quantity");
                double totalPrice = resultSet.getDouble("TotalPrice");

                System.out.printf("Order ID: %d, Name: %s, Food Item: %s, Quantity: %d, Total Price: %.2f%n",
                                  orderId, name, foodItem, quantity, totalPrice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
