<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new customer</title>
    <style>
        form {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: white;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<h1>Create new customer</h1>
<p>
    <a href="/customers">Back to customer list</a>
</p>
<form method="post">
    <label>Name:</label>
    <input type="text" name="name" required><br>
    <label>Email:</label>
    <input type="text" name="email" required><br>
    <label>Address:</label>
    <input type="text" name="address"><br>
    <input type="submit" value="Create">
</form>
</body>
</html>