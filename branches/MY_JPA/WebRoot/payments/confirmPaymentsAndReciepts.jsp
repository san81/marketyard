<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<s:form action="editTransaction.action" namespace="admin" method="post" name="editTransaction">
<s:head theme="ajax" />
<s:hidden name="account"></s:hidden>
<s:hidden name="accountKey"></s:hidden>
<s:hidden name="amount"></s:hidden>
<s:hidden name="paymentMode"></s:hidden>

<s:hidden name="checkNumber"></s:hidden>
<s:hidden name="bankName"></s:hidden>
<s:hidden name="branchName"></s:hidden>

<s:hidden name="action"></s:hidden>

	<table width="100%">
		<tr>
			<td> <s:text name="Account"></s:text> </td> <td>:</td>
			<td> <span id="accountDiv">${account}</span> </td>
		</tr>
		<tr>
			<td> <s:text name="label.amount"></s:text> </td> <td>:</td>
			<td> <span id="amountDiv" class="grandTotal">${amount}</span> </td>
		</tr>
		<tr>
			<td> <s:text name="label.paymentMode"></s:text> </td> <td>:</td>
			<td> <span id="paymentModeDiv">${paymentMode}</span> </td>
		</tr>
		<tr>
			<td colspan=3 align="center"> 
				<br/>
			</td>
		</tr>
		<tr>
			<td colspan=3 align="center">
				<input type="submit" value="Edit Transaction" />
				&nbsp; &nbsp;
				<input type="button" value="Make Transaction" onClick="document.editTransaction.action='makeTransaction.action';document.editTransaction.submit();"/>	
			</td>
		</tr>
	</table>
</s:form>