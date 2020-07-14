<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<c:if test="${product != null}">
	<%@ include file="../common/product.jspf"%>
</c:if>

<c:forEach items="${products}" var="product">
	<%@ include file="../common/product.jspf"%>
</c:forEach>

</body>
</html>