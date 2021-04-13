<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>vzelenin education Home page</title>
</head>
<body>
    <h2>Welcome vzelenin education Home page</h2>
    <hr>

    <p>
    Welcome to vzelenin education Home page!
    </p>

    <!-- Add a logout button -->
    <form:form action="${pageContext.request.contextPath}/logout"
               method="POST">

        <input type="submit" value="Logout" />
    </form:form>
</body>

</html>
