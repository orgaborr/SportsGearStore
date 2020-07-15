<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<c:forEach items="${categories}" var="category">
	<a href="/retrieve-by-category.do?category=${category.name()}">${category.name()}</a>
	<br>
</c:forEach>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>