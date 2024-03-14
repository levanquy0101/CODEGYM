<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <style>
        label {
            display: inline-block;
            width: 150px;
        }

        button {
            margin-left: 153px;
        }
    </style>
</head>
<body>
<h1>Simple Calculator</h1>
<fieldset>
    <legend>Calculator</legend>
    <form method="post" action="/calculate">
    <div><label>First Operand:</label> <input name="first"></div>
    <div><label>Operator:</label> <select name="operator">
        <option>Addition</option>
        <option>Subtraction</option>
        <option>Multiplication</option>
        <option>Division</option>
    </select></div>
    <div><label>Second Operand:</label> <input name="second"></div>
    <div>
        <button>Calculate</button>
    </div>
    </form>
</fieldset>
</body>
</html>
