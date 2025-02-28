<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h2>Login</h2>
        <form action="login" method="post">
            <input type="text" name="username" id="loginUsername" placeholder="Username" required>
            <input type="password" name="password" id="loginPassword" placeholder="Password" required>

            <button type="submit">Login</button>
        </form>
    </div>
</body>
</html>
