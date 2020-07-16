<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>
<div class="container">
	<h4>Current</h4>
	<table class="table-striped" style="width: 20%">
		<tr>
			<td>Product ID #</td>
			<td>${product.getId()}</td>
		</tr>
		<tr>
			<td>Name</td>
			<td>${product.getName()}</td>
		</tr>
		<tr>
			<td>Description</td>
			<td>${product.getDescription()}</td>
		</tr>
		<tr>
			<td>Category</td>
			<td>${product.getCategory()}</td>
		</tr>
		<tr>
			<td>Price</td>
			<td>${product.getPrice()} &euro;</td>
		</tr>
		<tr>
			<td>In Stock</td>
			<td>${product.getInStock()}</td>
		</tr>
	</table>
</div>

<div class="container">
	<h4>Update</h4>
	<form method="POST" action="/edit-product.do">
		<fieldset>
			<label>Name</label>
			<input type="text" name="newName"><br>

			<label>Description</label>
			<textarea name="newDescription">
				${product.getDescription()}
			</textarea><br>
			
			<label>Category</label>
			<select name="newCategory">
				<c:forEach items="${categories.getCategories()}" var="category">
					<c:choose>
						<c:when test="${category == product.getCategory()}">
							<option value="${category}" selected>${category}</option>
						</c:when>
						<c:otherwise>
							<option value="${category}">${category}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select><br>
			
			<label>Price</label>
			<input type="text" name="newPrice"> &euro;<br>
			
			<label>Increase stock by (can be negative value)</label>
			<input type="text" name="addStock"><br>
			
			<input type="submit" class="btn btn-warning" value="Save Changes">
		</fieldset>
	</form>
</div>

<%@ include file="../common/footer.jspf"%>