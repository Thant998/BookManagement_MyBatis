<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br>
<div style="color:red;">${error}</div>
	<form:form action="/bookspringmybatis/updateBook" method="post" modelAttribute="bean">
	<table>
		<tr>
			<td>Book Code</td>
			<td><form:input type="text" path="bookCode" /></td>
			<td><form:errors type="text" path="bookCode" /></td>
		</tr>
		
		<tr>
			<td>Book Title</td>
			<td><form:input type="text" path="bookTitle" /></td>
			<td><form:errors type="text" path="bookTitle" /></td>
		</tr>
		
		<tr>
			<td>Book Author</td>
			<td><form:input type="text" path="bookAuthor" /></td>
			<td><form:errors type="text" path="bookAuthor" /></td>
		</tr>
		
		<tr>
			<td>Book Price</td>
			<td><form:input type="text" path="bookPrice" /></td>
			<td><form:errors type="text" path="bookPrice" /></td>
		</tr>
		
		<tr>
			<td></td>
			<td><input type="submit" value="Update"></td>
		</tr>
	</table>
	</form:form>
</body>
</html>