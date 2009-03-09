<%@ taglib prefix="s" uri="/struts-tags"%>

<s:form action="saveAccount" method="POST" >
	<table>
		<tr>
			<td colspan="3">
				<s:label key="label.account.createTitle" />				
				<s:fielderror />
			</td>
		</tr>
		<tr>
			<td>
				<s:textfield name="loginName" key="label.account.loginName" />
			</td>
		</tr>
		<tr>

			<td>
				<s:textfield name="name" key="label.account.name" />
			</td>
		</tr>
		<tr>

			<td>
				<s:textfield name="mobile" key="label.account.mobile" />
			</td>
		</tr>
		<tr>

			<td>
				<s:textfield name="address" key="label.account.address" />
			</td>
		</tr>
		<tr>

			<td>
				<s:textfield name="village" key="label.account.village" />
			</td>
		</tr>
		<tr>
			<td colspan="3" align="center">
				<s:submit></s:submit>
			</td>
		</tr>
	</table>
</s:form>
