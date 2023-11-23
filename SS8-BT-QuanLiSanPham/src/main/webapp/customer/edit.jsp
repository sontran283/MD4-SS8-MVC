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
    /* Reset some default styles for consistency */
    body, h1, h2, p, form {
        margin: 0;
        padding: 0;
    }

    /* Apply some basic styling to the form */
    form {
        width: 300px;
        margin: 20px auto;
    }

    /* Style labels for better alignment */
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
        background-color: #2196F3; /* Blue color */
        color: white;
        padding: 10px 15px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    /* Hover effect for the submit button */
    input[type="submit"]:hover {
        background-color: #0b7dda; /* Darker blue on hover */
    }

    /* Apply some basic styling to the hidden action and id inputs */
    input[type="hidden"] {
        display: none;
    }

</style>
<body>
<h2>Edit Product</h2>
<form action="products" method="get">
    <input type="hidden" name="action" value="edit">
    <input type="hidden" name="id" value="${product.id}">
    <label>Product Name:</label>
    <input type="text" name="name" value="${product.name}" required><br>
    <label>Price:</label>
    <input type="text" name="price" value="${product.price}" required><br>
    <label>Description:</label>
    <textarea name="description">${product.description}</textarea><br>
    <label>Manufacturer:</label>
    <input type="text" name="manufacturer" value="${product.manufacturer}"><br>
    <input type="submit" value="Save Changes">
</form>
</body>
</html>
