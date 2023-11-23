<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/23/2023
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    body, h1, h2, p, form {
        margin: 0;
        padding: 0;
    }

    /* Apply some basic styling to the form */
    form {
        width: 300px;
        margin: 20px auto;
    }

    /* Style form labels for better readability */
    label {
        display: block;
        margin-bottom: 5px;
    }

    /* Style text input and textarea for consistency */
    input[type="text"],
    textarea {
        width: 100%;
        padding: 8px;
        margin-bottom: 10px;
        box-sizing: border-box; /* Ensures padding and border are included in width */
    }

    /* Style the submit button */
    input[type="submit"] {
        background-color: #4caf50;
        color: white;
        padding: 10px 15px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    /* Hover effect for the submit button */
    input[type="submit"]:hover {
        background-color: #45a049;
    }

    /* Apply some basic styling to the hidden action input */
    input[type="hidden"] {
        display: none;
    }
</style>
<body>
<h2>Create Product</h2>
<form action="/products" method="post">
    <input type="hidden" name="action" value="add">
    <label>Product Name:</label>
    <input type="text" name="name" required><br>
    <label>Price:</label>
    <input type="text" name="price" required><br>
    <label>Description:</label>
    <textarea name="description"></textarea><br>
    <label>Manufacturer:</label>
    <input type="text" name="manufacturer"><br>
    <input type="submit" value="Create">
</form>
</body>
</html>
