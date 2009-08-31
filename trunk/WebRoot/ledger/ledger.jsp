
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- Common Styles for the extjs examples -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/ext-examples.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/grid-examples.css" />

<jsp:include page="/includes/jsInclude.jsp"></jsp:include>
<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/grid/ledger.js"></script>

<s:fielderror></s:fielderror>

<s:url id="accountsList" value="../json/accountIdsAndNamesList.action"></s:url>
<%--<s:url id="accountTransactions" value="/json/accountsList.action" />--%>

<s:form action="viewLedger.action" namespace="admin" method="post">
	<s:head theme="ajax" />
	<table width="100%" border=0>
		<tr>
			<td colspan=2>
				<span  class="subHead">
					<s:text name="label.accountSummary"></s:text>
				</span>
			<hr></td>
	    </tr>	
		<tr>
			<td align="right">
				<s:text name="Account"></s:text>
				<span class="required">*</span>
			</td>
			<td>
				<s:autocompleter name="accountSummaryForm.accountId" theme="ajax" indicator="indicator"
					href="%{accountsList}" cssStyle="width: 200px;"
					autoComplete="false" searchType="" />
				<img id="indicator"
					src="${pageContext.request.contextPath}/images/indicator.gif"
					alt="Loading..." style="display:none" />
			</td>
		  </tr>
		  <tr>
			<td align="right">
				<s:text name="Duration"></s:text>
				<span class="required">*</span>
			</td>
			<td>
				<select name="accountSummaryForm.period">
					<option value="1">Current Month</option>
					<option value="2">Current and Last Month</option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2"><br></td>
		</tr>
		<s:submit key="label.submit" align="center"></s:submit>
<%--		<img id="indicator" src="${pageContext.request.contextPath}/images/indicator.gif" alt="Loading..." style="display:none"/>--%>
<%--		<s:submit type="submit" theme="ajax" value="submit" targets="ledger-grid" href="%{accountTransactions}" align="center" indicator="indicator"/>--%>
				
	</table>

</s:form>
	<jsp:include flush="true" page="/accounts/accountSummary.jsp"></jsp:include>

<% if(request.getAttribute("ledgerJSON")!=null){ %>
	<script> 
		var accountHolder='${accountSummaryForm.accountName} ';	
		var ledgerJSON = ${ledgerJSON}; 
		var openingBal= ${accountSummaryForm.openingBalance};
	</script>
<%}else{ %>
	<script> 
		var accountHolder='';	
		var ledgerJSON = '';
		var openingBal=0; 
	</script>
<%} %>
