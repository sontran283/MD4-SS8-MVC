<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/24/2023
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    a {
        text-decoration: none;
        color: #3498db;
    }

    a:hover {
        color: #207cca;
    }

    p {
        margin-bottom: 20px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    table, th, td {
        border: 1px solid #ddd;
    }

    th, td {
        padding: 10px;
        text-align: left;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    tr:hover {
        background-color: #e5e5e5;
    }

    td a {
        display: inline-block;
        padding: 5px 10px;
        background-color: #3498db;
        color: white;
        text-decoration: none;
    }

    td a:hover {
        background-color: #207cca;
    }

    button {
        background-color: #4CAF50;
        border: none;
        color: white;
        padding: 10px 20px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin: 4px 2px;
        cursor: pointer;
        border-radius: 4px;
    }

    button a {
        color: inherit;
        text-decoration: none;
    }

    button:hover {
        background-color: #45a049;
    }
</style>

<body>
<h2>Danh mục danh mục</h2>
<p>
    <button><a href="danh_muc?action=add">Thêm mới danh mục</a></button>
    <button><a href="/index.jsp">Back Home</a></button>
</p>
<table border="1" cellspacing="0">
    <tr>
        <td>STT</td>
        <td>ID</td>
        <td>Name</td>
        <td>Status</td>
        <td>P_Quantity</td>
        <td colspan="2">Action</td>
    </tr>
    <c:forEach items='${list}' var="item" varStatus="loop">
        <tr>
            <td>${loop.index+1}</td>
            <td>${item.categoryId}</td>
            <td>${item.categoryName}</td>
            <td>${item.categoryStatus ? "Active" : "Close"}</td>
            <td>${item.p_quantity}</td>
            <td><a href="/danh_muc?action=edit&id=${item.categoryId}">Edit</a></td>
            <td><a href="/danh_muc?action=delete&id=${item.categoryId}"
                   onclick="return confirm('Are you sure?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
