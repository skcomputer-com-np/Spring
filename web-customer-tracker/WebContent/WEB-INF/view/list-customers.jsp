<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<title>List Of Customers</title>
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
			<!-- put button: Add Customer -->

			<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />

			<!-- add table -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>

				<!-- Loop over the print out customer -->
				<c:forEach var="tempCustomer" items="${customers}">

					<!-- construct an "Update" link with customer ID -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerID">${tempCustomer.id}</c:param>
					</c:url>

					<!--construct an "Delete" link with customer id  -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerID">${tempCustomer.id}</c:param>
					</c:url>

					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td><a href="${updateLink}">Update</a> 
							|
							<a href="${deleteLink}"
							  onclick=
								  "if(!(confirm('Are you sure want to delete this customer?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>





</body>
</html>