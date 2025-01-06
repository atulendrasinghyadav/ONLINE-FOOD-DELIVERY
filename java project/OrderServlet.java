@WebServlet("/placeOrder")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String foodItem = request.getParameter("foodItem");
        String quantity = request.getParameter("quantity");
        String address = request.getParameter("address");

        // Call the service or DAO layer to place the order in the database
        boolean isOrderPlaced = OrderService.placeOrder(foodItem, quantity, address);

        if (isOrderPlaced) {
            response.sendRedirect("orderConfirmation.jsp");
        } else {
            request.setAttribute("errorMessage", "Failed to place order.");
            request.getRequestDispatcher("orderForm.jsp").forward(request, response);
        }
    }
}
