@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Display the user profile
    request.getRequestDispatcher("/userProfile.jsp").forward(request, response);
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Process user registration form
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    
    // Set user data as request attributes
    request.setAttribute("userName", name);
    request.setAttribute("userEmail", email);
    
    // Forward to JSP
    request.getRequestDispatcher("/userProfile.jsp").forward(request, response);
}
