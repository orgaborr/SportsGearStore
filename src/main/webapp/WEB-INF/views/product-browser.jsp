<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<c:if test="${errorMessage != null}">
<p><font color="red">${errorMessage}</font></p>
</c:if>

<c:if test="${product != null}">
	<%@ include file="../common/product.jspf"%>
</c:if>

<c:forEach items="${products}" var="product">
	<%@ include file="../common/product.jspf"%>
</c:forEach>

<%@ include file="../common/footer.jspf"%>