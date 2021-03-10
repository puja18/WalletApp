<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MainPage</title>
<link href="./resources/css/myStyles.css" rel="stylesheet" type="text/css">

</head>
<body>
<div id="bankCnt">
<h2 align="center"> Capg Banking Application </h2>
<div id="greetUser">Hello! ${custName}</div>

<hr>
<div id="menuCnt">
<ul>
	<li><a href="createAccount" target="cntFrame">Create Account</a></li>
	<li><a href="showBalance" target="cntFrame">Show Balance</a></li>
	<li><a href="depositWithdraw" target="cntFrame">Deposit/Withdraw</a></li>
	
	<li><a href="fundTransfer" target="cntFrame">FundTransfer</a></li>
	<li><a href="printTransaction" target="cntFrame">Transaction Summary</a></li>
	<li><a href="logout" target="_parent">Logout</a></li>
	
</ul>
</div>

<div id="content">
	<iframe name="cntFrame" id="frm" src="welcomePage.jsp" scrolling="no">
	
	</iframe>
</div>
<div id="footer">
<div style="float: left;">Capgemini Flp 2018 </div>
	<div style="margin-left: 700px;">Java FLp</div>
</div>
</div>
</body>
</html>