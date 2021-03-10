<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Summary</title>
<link href="./resources/css/myStyles.css" rel="stylesheet" type="text/css">
</head>
<body>
<h3 align="center">Account Summary</h3>
<div id="accSummary">

	<table cellpadding="3">
		<tr>
			<th>AccountNumber</th>
			<th>Account Type</th>
			<th>Balance</th>
			<th>Status</th>
			
		</tr>
	
	<c:if test="${!empty accounts }">
		<c:forEach items="${accounts}" var="account">
			<tr>
				<td>${account.accountNo}</td>
				<td>${account.accountType}</td>
				<td>${account.updateBalance}</td>
				<td>${account.status}</td>
			</tr>
		</c:forEach>
	</c:if>
	
	
	</table>

</div>

</body>
</html>