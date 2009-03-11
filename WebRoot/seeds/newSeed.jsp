<%@ taglib prefix="s" uri="/struts-tags"%>

<s:form action="saveSeed" method="POST" validate="true">
	<table>
		<tr>
			<td colspan="3">
				<s:label key="label.seed.createTitle" />				
				<s:fielderror />
			</td>
		</tr>
		<tr>
			<td>
				<s:textfield name="seedName" key="label.seed.seedName" />
			</td>
		</tr>
		<tr>
			<td colspan="3" align="center">
				<s:submit></s:submit>
			</td>
		</tr>
	</table>
</s:form>