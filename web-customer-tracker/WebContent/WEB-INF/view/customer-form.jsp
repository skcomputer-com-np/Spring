<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Add Customer</title>	

		<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css"
		>		

		<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"
		>
	</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	
	<div id="container">
		<h2>Save Customer</h2>
		
		<form:form method="POST" action="saveCustomer" modelAttribute="customer">
			<!-- need to associate data to customer id -->
			<form:hidden path="id"/>
		
			<table>
				<tbody>
					<tr>
						<td>First Name: </td>
						<td><form:input path="firstName"/> </td>
					</tr>
					
					<tr>
						<td>Last Name: </td>
						<td><form:input path="lastName"/> </td>
					</tr>
					
					<tr>
						<td>Email: </td>
						<td><form:input path="email"/> </td>
					</tr>
					
					<tr>
						<td><label></label> </td>
						<td><input type="submit"  value="Save" class="save"> </td>
					</tr>
				</tbody>
			</table>
		</form:form>
		
		<div style="clear; both;"> </div>

		<p>
			<a href="${pageContext.request.contextPath}/customer/list" >Back to list</a>
		</p>
	</div>
</body>
</html>