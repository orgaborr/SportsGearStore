<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container">
	<h4>New Product</h4>
	<form method="POST" action="/add-product">
		<fieldset>
			<label>Product ID #</label>
			<input type="text" name="productId"><br>
		
			<label>Name</label>
			<input type="text" name="name"><br>

			<label>Description</label>
			<textarea name="description"></textarea><br>
			
			<label>Category</label>
			<select name="category">
				<c:forEach items="${categories.getCategories()}" var="category">
						<option value="${category}">${category}</option>
				</c:forEach>
			</select><br>
			
			<label>Price</label>
			<input type="text" name="price"> &euro;<br>
			
			<label>In Stock</label>
			<input type="text" name="inStock"><br>
			
			<label>Image</label>
			<input type="text" name="img"><br>
			
			<input type="submit" class="btn btn-success" value="Add Product">
		</fieldset>
	</form>
	
	<c:if test="${errorMessage != null}">
		<p><font color="red">${errorMessage}</font></p>
	</c:if>
</div>

<%@ include file="../common/footer.jspf"%>