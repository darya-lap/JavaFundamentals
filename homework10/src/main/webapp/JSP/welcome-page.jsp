
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page session="true" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Welcome to Musse!</h1>
<form >
    <label>Логин</label><br>
    <input type="text" name="username" placeholder="Логин" size="20"/><br>
    <label >Пароль</label><br>
    <input type="password" name="password" placeholder="Пароль" size="20"/><br>
    <input type="submit" value="Войти"/>
    <input type="button" value="Зарегистрироваться"/>
</form>
<p>
    <%--<c:forEach var="user" items="${sessionScope.users}">--%>
        <%--<c:out value="${user}"/>--%>
        <%--<hr>--%>
    <%--</c:forEach>--%>
</p>
</body>
</html>