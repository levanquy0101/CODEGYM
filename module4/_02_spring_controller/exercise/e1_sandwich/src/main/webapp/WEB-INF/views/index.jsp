<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich condiments</h1>
<form action="save" method="post">
    <input type="checkbox" name="condiment" value="Lettuce">Lettuce
    <input type="checkbox" name="condiment" value="Tomato">Tomato
    <input type="checkbox" name="condiment" value="Mustard">Mustard
    <input type="checkbox" name="condiment" value="Sprouts">Sprouts
    <button>Save</button>
</form>

<c:if test="${not empty condiment}">
    Result: ${condiment}
</c:if>


<%--<form:form action="submit" method="post" modelAttribute="test">--%>
<%--<form:checkboxes  items="${condiments}" delimiter="|" path="c"></form:checkboxes>--%>
<%--<form:button>Submit</form:button>--%>
<%--</form:form>--%>
</body>
</html>
