
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- Common Styles for the extjs examples -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/ext-examples.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/grid-examples.css" />

<jsp:include page="/includes/jsInclude.jsp"></jsp:include>
<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/extAjaxCall.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/grid/ledger.js"></script>

<s:fielderror></s:fielderror>

<s:url id="accountsList" value="../json/accountIdsAndNamesList.action"></s:url>
<%--<s:url id="accountTransactions" value="/json/accountsList.action" />--%>

<s:form action="viewLedger.action" namespace="admin" method="post" name="viewLedger" onsubmit="return false;">
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
				<select name="accountSummaryForm.option">
					<option value="1">Current Month</option>
					<option value="2">Current and Last Month</option>
					<option value="4">Current Year</option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2"><br></td>
		</tr>
		<s:submit key="label.submit" align="center" onclick="loadAccountSummary()"></s:submit>
<%--		<img id="indicator" src="${pageContext.request.contextPath}/images/indicator.gif" alt="Loading..." style="display:none"/>--%>
<%--		<s:submit type="submit" theme="ajax" value="submit" targets="ledger-grid" href="%{accountTransactions}" align="center" indicator="indicator"/>--%>
				
	</table>

</s:form>
	<div id="accountSummaryDiv"></div>

<script>

var accountHolder='';	
var openingBal=0;
var ledgerJSON='';	

	function loadAccountSummary(){
		var formCtrl = document.viewLedger;
		var urlAction="viewLedger.action";
		var params=Ext.lib.Ajax.serializeForm(formCtrl);
		makeExtAjaxCall(urlAction,params,loadAccountSummaryGrid);		
	}
	function loadAccountSummaryGrid(response){
		$('accountSummaryDiv').innerHTML=response.responseText;
		var formCtrl = document.hiddenValuesForm;
		accountHolder=formCtrl.accountHolderCtrl.value;			
		eval(document.getElementById('ledgerJSONDiv').innerHTML);				
		openingBal=formCtrl.openingBalCtrl.value;
		renderGrid();
	}
</script>