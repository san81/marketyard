<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>Struts 2 Login Application!</title>

		<link href="/css/main.css" rel="stylesheet" type="text/css" />

	</head>
	<body>
		<form action="acegiAuthentication" method="POST">
			<table border=1>
				<tr>
					<td colspan="2">
						Login
					</td>

				</tr>

				<%
				            String errorKey = request.getParameter("errorMsg");
				            if (errorKey != null) {
				%>
				<tr>
					<td colspan="2">
						error msg
						<s:i18n name="errorKey"></s:i18n>
					</td>

				</tr>
				<%
				}
				%>


				<s:textfield name="username" label="Login name" />
				<s:password name="password" label="Password" />
				<s:submit value="Login" align="center" />

			</table>

		</form>
	</body>
</html>

