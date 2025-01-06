<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
    <h1>Register</h1>

    <form action="register" method="POST">
        <label for="firstName">First Name:</label><br>
        <input type="text" id="first-name" name="firstName"><br><br>
        
        <label for="lastName">Last Name:</label><br>
        <input type="text" id="last-name" name="lastName"><br><br>
        
        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email"><br><br>
        
        <input type="submit" value="Register">
    </form>

    <c:if test="${not empty errorMessage}">
        <div style="color:red">${errorMessage}</div>
    </c:if>
</body>
</html>
