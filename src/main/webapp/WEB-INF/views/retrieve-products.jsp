<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="POST" action="/retrieve-products.do">
		<input name="productId" type="text"><input name="Search" type="submit">
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