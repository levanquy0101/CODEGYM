<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/customer?action=save" method="post">
    <input type="hidden" name="id" value="${customer.id}">
    <div>
        <label>Name: </label>
        <input name="name" value="${customer.name}">
    </div>

    <div>
        <label>Email: </label>
        <input name="email" value="${customer.email}">
    </div>

    <div>
        <label>Country: </label>
        <input name="country" value="${customer.email}">
    </div>

    <button>Submit</button>
</form>
</body>
</html>
