<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<c:forEach items="${categories}" var="category">
	<a href="/retrieve-by-category.do?category=${category.name()}">${category.name()}</a>
	<br>
</c:forEach>

</body>
</html>