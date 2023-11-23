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
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
    }

    h2 {
        color: #333;
    }

    p {
        margin-bottom: 10px;
    }

    strong {
        font-weight: bold;
    }

    a {
        text-decoration: none;
        padding: 5px 10px;
        border: 1px solid #dddddd;
        margin: 2px;
        display: inline-block;
        background-color: #f2f2f2;
        color: #333;
    }

    a:hover {
        background-color: #ddd;
    }
</style>

<body>
<h2>Product Details</h2>
<p><strong>ID:</strong> ${product.id}</p>
<p><strong>Name:</strong> ${product.name}</p>
<p><strong>Price:</strong> ${product.price}</p>
<p><strong>Description:</strong> ${product.description}</p>
<p><strong>Manufacturer:</strong> ${product.manufacturer}</p>
<br>
<a href="products?action=list">Quay lại</a>
</body>
</html>
