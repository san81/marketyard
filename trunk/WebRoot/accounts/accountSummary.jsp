<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	double drTotal = 0.0;
	double crTotal =0.0;
 %>

	<s:if test="accountBTransactions.size <= 0">
		<tr><td>No transactions found.</td></tr>
	</s:if>
	<s:else>
		<table border="1">
		<tr>
			<td>Date</td>
			<td>Description</td>
			<td>Dr.</td>
			<td>Cr.</td>
		</tr>
		<s:iterator value="accountBTransactions" status="status" >
	     <tr class="<s:if test="status.odd == true ">odd</s:if><s:else>even</s:else>">
	         <td><s:property value="datetime" /></td>
	         <td><s:property value="description" /></td>
	         <td>
		         <s:if test="%{transFlow == 'DR'}">
		         	<s:property value="amount" />
		         	
		         </s:if>
	         </td>
	          <td>
		         <s:if test="%{transFlow == 'CR'}">
		         	<s:property value="amount" />	
		         </s:if>
	         </td>
	     </tr>
		 </s:iterator>
		 <tr>
		 	<td>Total</td>
		 	<td></td>
		 	<td><%=drTotal %></td>
		 	<td><%=crTotal %></td>
		 </tr>
		</table>
	</s:else>


