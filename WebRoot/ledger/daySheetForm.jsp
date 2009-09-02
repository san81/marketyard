
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/includes/jsInclude.jsp"></jsp:include>

<script>
	function getDaySheet(){
		var date = document.daySheetForm.date.value;
		var urlStr = "daySheet.action?date="+date+"&action=ajax";
		var pars = "";
		makeExtAjaxCall(urlStr,pars,successDaySheet);
	}
	
	function successDaySheet(response){
		var daySheetDiv = document.getElementById("daySheetDiv");
		daySheetDiv.innerHTML = response.responseText;
	}
	
</script>

<s:fielderror></s:fielderror>

<s:form cssStyle="width:100%" action="daySheet.action" namespace="admin" method="post" name="daySheetForm" onsubmit="return false;">
	<s:head theme="ajax" />
	<tr>
			<td colspan=2>
				<span  class="subHead">
					<s:text name="label.daySheet"></s:text>
				</span>
			<hr></td>
	 </tr>
	<s:datetimepicker label="Sheet For Date" name="date" value="today" required="true" />
	<s:submit key="label.submit" align="center" onclick="javascript:getDaySheet();"></s:submit>
</s:form>

<br />
<br />
<br />

<div id="daySheetDiv">
	<jsp:include flush="true" page="/ledger/daySheetContent.jsp"></jsp:include>
</div>