<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/24/2023
  Time: 3:53 PM
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
    <a href="/danh-muc">Back to customer list</a>
</p>
<div class="container">
    <div class="row">
        <div class="col-lg-6">
            <h1 class="text-center text-danger">Thêm mới danh muc </h1>
            <form action="<%=request.getContextPath()%>/danh-muc" method="POST">
                <div class="form-group">
                    <label for="categoryName">Ten danh muc</label>
                    <input type="text" class="form-control" id="categoryName" name="categoryName">
                </div>
                <div class="form-group">
                    <label for="Active">Status </label>
                    <input type="radio" id="Active" name="fav_language" checked value="1">
                    <label for="Active">Active</label>
                    <input type="radio" id="IsActive" name="fav_language" value="0">
                    <label for="IsActive">InActive</label><br>
                </div>
                <button type="submit" class="btn btn-primary">Add</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
