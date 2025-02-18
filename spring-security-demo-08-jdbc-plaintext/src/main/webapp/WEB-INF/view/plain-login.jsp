<%--
  Created by IntelliJ IDEA.
  User: Vadim_Zelenin
  Date: 02-Apr-21
  Time: 6:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Custom login page</title>
</head>
<body>
    <h3>My Custom Login Page</h3>

    <style>
        .failed {
            color: red;
        }
    </style>

    <!-- Check for login error -->

    <c:if test="${param.error != null}">
        <i class="failed">Sorry! You entered invalid username/password</i>
    </c:if>
    <form:form action="${pageContext.request.contextPath}/authenticateTheUser"
                        method="POST">
        <p>
            User name: <input type="text" name="username">
        </p>

        <p>
            Password: <input type="password" name="password">
        </p>

        <input type="submit" value="Login" />
    </form:form>
</body>
</html>
