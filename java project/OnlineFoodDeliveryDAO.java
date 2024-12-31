import java.sql.*;

public class OnlineFoodDeliveryDAO {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/FoodDeliveryDB";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    // Connection object
    private Connection connection;

    // Constructor to initialize the database connection
    public OnlineFoodDeliveryDAO() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish a connection
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Database connected successfully.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to the database.");
        }
    }

    // Method to insert contact details
    public boolean insertContactDetails(String name, String phone, String email) {
        String query = "INSERT INTO ContactDetails (name, phone, email) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, email);

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to insert order details
    public boolean insertOrderDetails(String foodItem, int quantity, double price, String contactPhone) {
        String query = "INSERT INTO OrderDetails (foodItem, quantity, price, contactPhone) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, foodItem);
            preparedStatement.setInt(2, quantity);
            preparedStatement.setDouble(3, price);
            preparedStatement.setString(4, contactPhone);

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to retrieve all contact details
    public void getAllContactDetails() {
        String query = "SELECT * FROM ContactDetails";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            System.out.println("Contact Details:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name") +
                        ", Phone: " + resultSet.getString("phone") + ", Email: " + resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all order details
    public void getAllOrderDetails() {
        String query = "SELECT * FROM OrderDetails";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            System.out.println("Order Details:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Food Item: " + resultSet.getString("foodItem") +
                        ", Quantity: " + resultSet.getInt("quantity") + ", Price: " + resultSet.getDouble("price") +
                        ", Contact Phone: " + resultSet.getString("contactPhone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Close the database connection
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        OnlineFoodDeliveryDAO dao = new OnlineFoodDeliveryDAO();

        // Insert sample contact details
        dao.insertContactDetails("John Doe", "1234567890", "john.doe@example.com");
        
        // Insert sample order details
        dao.insertOrderDetails("Pizza", 2, 15.99, "1234567890");

        // Retrieve and print all contact details
        dao.getAllContactDetails();

        // Retrieve and print all order details
        dao.getAllOrderDetails();

        // Close the connection
        dao.closeConnection();
    }
}