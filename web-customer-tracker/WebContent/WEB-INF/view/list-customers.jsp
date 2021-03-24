<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>List Customers</title>

<!--  reference our style sheet -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<!-- put new button: Add Customer -->
			<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />

			<!--  add html table here -->
			<table>
				<tr>
					<th>First name</th>
					<th>Last name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>

				<!--  loop over and print out customers -->
				<c:forEach var="tempCustomer" items="${customers}">
				
				<!--  construct update link -->
				<c:url var="updateLink" value="/customer/showFormForUpdate">
				<c:param name="customerId" value="${tempCustomer.id}" />
				</c:url>
				
                <!--  construct delete link -->
                <c:url var="deleteLink" value="/customer/showFormForDelete">
                <c:param name="customerId" value="${tempCustomer.id}" />
                </c:url>
				
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td><a href="${updateLink}">Update</a>
						|
						<td><a href="${deleteLink}"
						      onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
					</tr>
				</c:forEach>

			</table>

		</div>

	</div>

</body>

</html>