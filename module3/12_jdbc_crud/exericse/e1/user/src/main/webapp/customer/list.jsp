<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<%--<sql:query var="rs" dataSource="jdbc/quoc">--%>
<%--    select id, name, email from customer--%>
<%--</sql:query>--%>
<html>
<head>
    <title>Title</title>
    <style>
        td{
            border: 1px solid;
        }
        th{
            /*border-left: 1px solid;*/
        }
    </style>
</head>
<body>
<div style="text-align: center"><h1>Customer List</h1>
<%--<a href="customer?action=add">Create</a>--%>
    <a href="customer/add.jsp">Create</a>
</div>
<table style="width: 100%; border-collapse: collapse; background-color: red">
    <thead>
    <th>No</th>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Country</th>
    <th>Action</th>
    </thead>
    <tbody>
<%--    <c:forEach items="${rs.rows}" var="c">--%>
        <c:forEach items="${customers}" var="c" varStatus="no">
        <tr>
            <td>${no.count}</td>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.email}</td>
            <td>${c.country}</td>
            <td>
                <a href="customer?action=edit&id=${c.id}">Edit</a>
                <a href="customer?action=delete&id=${c.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
