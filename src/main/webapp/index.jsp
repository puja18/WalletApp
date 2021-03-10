<html>
<head>
<link href="./resources/css/myStyles.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="./resources/script/myScript.js"></script>
<title>WalletApp</title>
</head>
<body >
<div  id="mainCnt">
<h1 align="center" id="title">Capg Banking Application</h1>
<hr>

<div id="imgcnt">
<img alt="Currency" style="margin: 10px 10px 10px 10px;" src="./resources/images/currency_globe.jpg" width="250px" height="250px">
</div>
<fieldset style="width: 500px; margin-top:80px; margin-left: 200px;">
<legend>Login form</legend>
<form name="myform" method="post" 
 onsubmit="return validateForm()"
 action="validateLogin" >
	<table>
		<tr>
			<th colspan="3">Login Form </th>
		</tr>
		<tr>
			<td>Customer Id:</td>
			<td>
				<input type="text" name="customerId" size="20">
			</td>
			<td>
				<div id="userErrMsg" class="errMessage"></div>
			</td>
		</tr>
		<tr>
			<td>Password:</td>
			<td>
				<input type="password" name="customerPwd" size="20">
			</td>
			<td>
				<div id="pwdErrMsg" class="errMessage"></div>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="submit" id="login" name="login" value="Login">
			</td>
			
		</tr>
		
	</table>


</form>
</fieldset>
</div>
<hr>

<div>
	<div style="float: left;">Capgemini Flp 2018 </div>
	<div style="margin-left: 600px;">Java FLp</div>
</div>
<hr>
</body>
</html>
