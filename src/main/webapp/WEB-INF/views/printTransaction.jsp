<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Print Transactions</title>

<link href="./resources/css/myStyles.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="./resources/script/myScript.js"></script>

</head>
<body>

<form:form name="printForm" modelAttribute="txs" method="get" action="printTrans">
<h3 align="center">Print Transaction</h3>

<div id="accCnt1">
	
	From Date:
	<input type="date"   name="fromDate">
	
To Date:<input type="date"  name="toDate">

<div style="margin-left: 150px;">
		<input type="submit" id="btnType" class="btn" style="width: 150px;" value="Print Transactions">
		<input type="button" id="btnType" class="btn" value="Download PDF">
	</div>
</div>
</form:form>

<c:if test="${!empty txs }">
	<table>
		<tr>
			<th>Transaction Date</th>
			<th>Transaction Description</th>
			<th>Debit</th>
			<th>Credit</th>
		</tr>
		
		<c:forEach items="${txs}" var="tx">
		 	<tr>
		 		<td>${tx.transactionDate }</td>
		 		<td>${tx.fromAccount.accountNo} - ${tx.description }</td>
		 		<c:if test="${tx.transactionType eq 'debit' }">
		 			<td>${tx.amount}</td>
		 		</c:if>
		 		
		 		<c:if test="${tx.transactionType ne 'debit' }">
		 			<td> </td>
		 		</c:if>
		 		
		 		<c:if test="${tx.transactionType eq 'credit' }">
		 			<td>${tx.amount}</td>
		 		</c:if>
		 		<c:if test="${tx.transactionType ne 'credit' }">
		 			<td>${tx.amount}</td>
		 		</c:if>
		 		
		 	</tr>
		</c:forEach>
	</table>
</c:if>

</body>
</html>