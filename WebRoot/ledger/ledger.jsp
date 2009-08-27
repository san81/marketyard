
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- Common Styles for the extjs examples -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/ext-examples.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/grid-examples.css" />

<jsp:include page="/includes/jsInclude.jsp"></jsp:include>
<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/grid/ledger.js"></script>

<s:fielderror></s:fielderror>

<s:url id="accountsList" value="../json/accountIdsAndNamesList.action"></s:url>

<s:form action="viewLedger.action" namespace="admin" method="post">
	<s:head theme="ajax" />
	<table width="100%">
		<tr>
			<td align="right">
				<s:text name="Account"></s:text>
				<span class="required">*</span>
			</td>
			<td colspan="2">
				<s:autocompleter name="account" theme="ajax" indicator="indicator"
					href="%{accountsList}" cssStyle="width: 200px;"
					autoComplete="false" searchType="" />
				<img id="indicator"
					src="${pageContext.request.contextPath}/images/indicator.gif"
					alt="Loading..." style="display:none" />
			</td>
		</tr>
		<tr>
			<td>
				<br/>
			</td>
		</tr>
		<s:submit key="label.submit" ></s:submit>		
	</table>

</s:form>
<div id="ledger-grid"></div>
<script>
	var ledgerJSON = ${ledgerJSON};
	//alert("ledgerJSON: "+ledgerJSON);
</script>
