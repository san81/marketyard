
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:actionerror />
<s:actionmessage />
<s:fielderror />

<s:form action="slipConfigurations" method="post">
	<table width=100%>
		<tr>
			<td> Hamali Rate  :</td>
			<td> <input type=text name="hamaliRate" value="${hamaliRate}" size=3 > </td>
		</tr>
		<tr>
			<td> Adthi Rate  :</td>
			<td> <input type=text name="adthiRate" value="${adthiRate}" size=3 > </td>
		</tr>
		<tr>
			<td> Cash Commission Rate  :</td>
			<td> <input type=text name="cashCommissionRate" value="${cashCommissionRate}" size=3 > </td>
		</tr>
		<tr>
			<td colspan="3" align="center">
				<s:submit></s:submit>
			</td>
		</tr>

	</table>

</s:form>
