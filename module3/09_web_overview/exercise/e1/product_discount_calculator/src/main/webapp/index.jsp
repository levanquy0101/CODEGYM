<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        div{
            margin-bottom: 10px;
        }

        label{
            display: inline-block;
            width:150px;
        }

        input{
            width:80px;
        }

        form div:nth-child(3) input{
            width: 60px;
        }
    </style>
</head>
<body>
<form method="post" action="display-discount ">
    <div class="a">
        <label>Product Description1</label>
        <input name="description">
    </div>

    <div>
        <label>Price</label>
        <input name="price">
    </div>

    <div>
        <label>Discount Percent</label>
        <input name="discount">
        <span>%</span>
    </div>
    <button>Calculate</button>
</form>
</body>
</html>