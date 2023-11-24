<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<style>
    /*table, th, tr, td {*/

    /*    border-collapse: collapse;*/
    /*}*/
    table {
        padding: 8px;
        width: 80%;
        border-collapse: collapse;
    }

    th, td {
        padding: 5px;
        border: 1px solid #ddd;
        text-align: center; /* Căn giữa theo chiều ngang */
    }

    td {
        vertical-align: middle; /* Căn giữa theo chiều dọc */
    }

    a {
        margin: 5px;
        text-decoration: none;
    }
</style>
<body>
<h1>Customers</h1>
<p>
    <a href="customers?action=create">Thêm Thêm Thêm</a>
</p>

<form action="customers">
    <input type="text" name="search" value="${searchName}">
    <input type="submit" name="action" value="search">
</form>

<table border="1" cellspacing="0">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>
        <td colspan="2">Action</td>
    </tr>
    <c:forEach items='${customers}' var="customer" varStatus="loop">
        <tr>
            <td>${loop.index+1}</td>
            <td>${customer.name}</td>
            <td>${customer.email}</td>
            <td>${customer.address}</td>
            <td><a href="/customers?action=edit&id=${customer.getId()}">Edit</a></td>
            <td><a onclick="return confirm('ban co chac chan muon xoa khong?')"
                   href="/customers?action=delete&id=${customer.getId()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>