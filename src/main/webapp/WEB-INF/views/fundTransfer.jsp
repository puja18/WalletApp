<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fund Transfer</title>
<link href="./resources/css/myStyles.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="./resources/script/myScript.js"></script>

</head>
<body>

<form:form name="fundForm" modelAttribute="txs" method="post" 
action="doFundTransfer">
<h3 align="center">Fund Transfer</h3>

<div id="accCnt">
	<div class="accRow">
	<div class="label" style="float: left;">From Account:</div>
	<div >
		<form:select path="fromAccount.accountNo" style=" padding-left: 10px;">
			<c:if test="${!empty accounts }">
				<c:forEach items="${accounts }" var="acc">
					<form:option value="${acc.accountNo}"> ${acc.accountNo} - ${acc.accountType} </form:option>
					
				</c:forEach>
			
			</c:if>
		</form:select>
	</div>
	
	<div class="accRow" style="margin-top: 15px;">
	<div class="label" style="float: left;">To Account:</div>
	<div >
		<form:select path="toAccount.accountNo" style=" padding-left: 10px;">
			<c:if test="${!empty otheracc }">
				<c:forEach items="${otheracc }" var="acc">
					<form:option value="${acc.accountNo}"> ${acc.accountNo} - ${acc.accountType} </form:option>
					
				</c:forEach>
			
			</c:if>
		</form:select>
	</div>
	
	
	</div>
	<div  class="accRow">
		<div class="label" style="float:left; padding-top: 5px; padding-right:10px; ">Amount:</div>
		<div>
			<form:input path="amount" value=" "/>
		</div>
	</div>
	
	<div  class="accRow">
		<div class="label" style="float:left; padding-top: 5px; padding-right:10px; ">Description:</div>
		<div>
			<form:input path="description" />
		</div>
	</div>
	
	
	
	
	<div style="margin-left: 150px;">
		<input type="submit" id="btnType" class="btn" value="Transfer">
	</div>
	
</div>
</div>

</form:form>

</body>
</html>