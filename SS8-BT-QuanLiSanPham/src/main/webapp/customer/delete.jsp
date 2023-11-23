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
        background-color: #f44336; /* Red color */
        color: white;
        padding: 10px 15px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    /* Hover effect for the submit button */
    input[type="submit"]:hover {
        background-color: #d32f2f; /* Darker red on hover */
    }

    /* Apply some basic styling to the hidden action and id inputs */
    input[type="hidden"] {
        display: none;
    }

    /* Style paragraphs for better readability */
    p {
        margin-bottom: 10px;
    }

</style>
<body>
<h2>Delete Product</h2>
<p>Are you sure you want to delete this product?</p>
<form action="products" method="post">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="id" value="${product.id}">
    <p><strong>Product Name:</strong> ${product.name}</p>
    <p><strong>Price:</strong> ${product.price}</p>
    <p><strong>Description:</strong> ${product.description}</p>
    <p><strong>Manufacturer:</strong> ${product.manufacturer}</p>
    <input type="submit" value="Delete">
</form>
</body>
</html>
