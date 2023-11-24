<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit customer</title>
</head>
<style>
    form {
        max-width: 400px;
        margin: 0 auto;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    label {
        display: block;
        margin-bottom: 8px;
    }

    input {
        width: 100%;
        padding: 8px;
        margin-bottom: 10px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        background-color: #4caf50;
        color: white;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }
</style>
<body>
<h1>Edit customer</h1>
<p>
    <a href="/customers">Back to customer list</a>
</p>
<form method="post">
    <label>ID: </label>
    <input type="text" name="id" value="${customer.id}" readonly disabled>
    <label>Name:</label>
    <input type="text" name="name" value="${customer.name}" required><br>
    <label>Email:</label>
    <input type="text" name="email" value="${customer.email}" required><br>
    <label>Address:</label>
    <input type="text" name="address" value="${customer.address}" required><br>
    <input type="submit" value="Save Changes">
</form>
</body>
</html>