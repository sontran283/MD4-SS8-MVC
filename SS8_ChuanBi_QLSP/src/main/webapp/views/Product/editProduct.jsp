<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/24/2023
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<body>
<p>
    <a href="/product">Back to customer list</a>
</p>
<h1 class="text-center text-danger">Sửa sản phẩm</h1>
<form action="<%=request.getContextPath()%>/product" method="POST">
    <input type="hidden" name="action" value="edit">
    <div class="form-group">
        <label for="id">id: </label>
        <input type="text" class="form-control" id="id" name="id" value="${product.id}" readonly>
    </div>
    <div class="form-group">
        <label for="name">name: </label>
        <input type="text" class="form-control" id="name" name="name" value="${product.name}">
    </div>
    <div class="form-group">
        <label for="price">price: </label>
        <input type="text" class="form-control" id="price" name="price" value="${product.price}">
    </div>
    <div class="form-group">
        <label for="category">Danh mục: </label>
        <select class="form-control" id="category" name="categoryId" value="${product.category.categoryId}">
            <c:forEach var="item" items="${list_category}">
                <option value="${item.categoryId}" ${item.categoryId eq product.category.categoryId ? 'selected' : ''}>${item.categoryName}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label for="p_quantity">p_quantity: </label>
        <input type="text" class="form-control" id="p_quantity" name="p_quantity" value="${product.category.p_quantity} "
               readonly>
    </div>
    <button type="submit" class="btn btn-primary">Edit</button>
</form>
</body>
</html>
