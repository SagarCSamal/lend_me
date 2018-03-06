<html>
<head>
<title>Being Java Guys | Spring DI Hello World</title>
<style>
body {
	font-size: 20px;
	color: teal;
	font-family: Calibri;
}

td {
	font-size: 15px;
	color: black;
	width: 100px;
	height: 22px;
	text-align: left;
}

.heading {
	font-size: 18px;
	color: white;
	font: bold;
	background-color: orange;
	border: thick;
}
</style>
</head>
<body>
	<center>
		<br /> <br /> <br /> <b>Being Java Guys | Registration Form </b> <br />
		<br />
		<div>
			<form:form method="post" action="/insert" modelAttribute="user">
				<table>
					<tr>
						<td>Product :</td>
						<td><form:input path="product" /></td>
					</tr>
					<tr>
						<td>MaxLoanAmount :</td>
						<td><form:input path="maxLoanValue" /></td>
					</tr>
					<tr>
						<td>MinimumLoanValue :</td>
						<td><form:input path="minimumLoanValue" /></td>
					</tr>
					<tr>
						<td>IntrestRate :</td>
						<td><form:input path="intrestRate" /></td>
					</tr>
					<tr>
						<td>Tenure :</td>
						<td><form:input path="tenure" /></td>
					</tr>
				</table>
			</form:form>
		</div>
	</center>
</body>
</html>
