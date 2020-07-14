<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sports Gear Store</title>
</head>

<body>
	<nav>
		<ul>
			<li>
				<form method="GET" action="/retrieve-products.do">
					<input name="search" type="text" required><input type="submit" value="Search">
				</form>
				<label><font color="red">${errorMessage}</font></label>
			</li>
			<li><a href="/list-categories.do">Sports</a></li>
			<li><a href="/add-product.do">Add Product</a></li>
		</ul>
		<ul>
			<li><a href="/logout.do">Logout</a></li>
		</ul>
		
	</nav>
	
	<c:forEach items="${categories}" var="category">
		<a>${category.name()}</a><br>	
	</c:forEach>
	
</body>
</html>