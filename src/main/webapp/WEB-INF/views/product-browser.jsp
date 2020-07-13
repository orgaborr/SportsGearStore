<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sports Gear Store</title>
</head>
<body>
	<form method="POST" action="/retrieve-products.do">
		<input name="searchField" type="text" required><input type="submit" value="Search">
	</form>
	
	<p>
		<font color="red">${errorMessage}</font>
	</p>
	
	<h3>${product.getName()}</h3>
	<p>
		${product.getDescription()}<br>
		${product.getPrice()}<br>
		${product.getInStock()}<br>
	</p>
	
</body>
</html>