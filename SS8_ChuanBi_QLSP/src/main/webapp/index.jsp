<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<style>
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
<h2><%= "ADMIN MANAGEMENT" %>
</h2>
<br/>
<button><a href="danh_muc">Quản lí danh mục</a></button>
<button><a href="product">Quản lí sản phẩm</a></button>
<button><a href="user">Quản lí người dùng</a></button>
</body>
</html>