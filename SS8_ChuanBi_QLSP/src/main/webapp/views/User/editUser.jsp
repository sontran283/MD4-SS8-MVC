<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/24/2023
  Time: 4:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<body>
<p>
    <a href="/user">Back to customer list</a>
</p>
<h1 class="text-center text-danger">Sửa danh muc </h1>
<form action="<%=request.getContextPath()%>/user" method="POST">
    <div class="form-group">
        <input type="hidden" name="id" value="${user.id}">
        <label for="name">name: </label>
        <input type="text" class="form-control" id="name" name="name" value="${user.name}">
    </div>
    <div class="form-group">
        <label for="email">email: </label>
        <input type="text" class="form-control" id="email" name="email" value="${user.email}">
    </div>
    <div class="form-group">
        <label for="country">country: </label>
        <input type="text" class="form-control" id="country" name="country" value="${user.country}">
    </div>
    <button type="submit" class="btn btn-primary" value="edit" name="action">Edit</button>
</form>
</body>
</html>
