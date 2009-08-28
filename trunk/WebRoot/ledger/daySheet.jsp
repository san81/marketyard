
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<s:fielderror></s:fielderror>

<s:form action="daySheet.action" namespace="admin" method="post">
	<s:head theme="ajax" />
	<s:datetimepicker value="today" label="Sheet For Date" name="date"
		required="true" />

	<s:submit key="label.submit"></s:submit>
</s:form>

<br />
<br />
<br />

<div id="daySheetDiv">
	<table border="0" width="100%"
		style="border: 0.1em solid rgb(202, 218, 231);">
		<tr>
			<td valign="top">
				<table border="0" width="100%">
					<s:iterator id="element" status="mapStatus"
						value="daySheet.creditsMap">
						<tr>
							<td>
								<B><s:property value="key" />
								</B>
							</td>
							<td align="center">
								<s:property value="value" />
							</td>
						</tr>
					</s:iterator>
				</table>
			</td>
			<td width="10%">
				<table border="0">
					<tr>
						<td width="49%"  height="100%">							
						</td>
						<td width="1%"  height="100%"><div style="border-right:2px solid #ccc; height:100px; width:1px"></div></td>
						<td width="50%">						
						</td>
					</tr>
				</table>
			</td>
			<td valign="top">
				<table border="0" width="100%">
					<s:iterator id="element" status="mapStatus"
						value="daySheet.debitsMap">
						<tr>
							<td>
								<B><s:property value="key" />
								</B>
							</td>
							<td align="center">
								<s:property value="value" />
							</td>
						</tr>
					</s:iterator>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="3">
				<hr class="horizontalRule" />
			</td>
		</tr>
		<tr>
			<td>
				Total Credits:
				<b>${daySheet.sumOfCredits}</b>
			</td>
			<td width="10%"></td>
			<td>
				Total Debits:
				<b>${daySheet.sumOfDebits}</b>
			</td>
		</tr>
		<tr>
			<td colspan="3">
				<hr class="horizontalRule" />
			</td>
		</tr>
		<tr>
			<td colspan="3" align="center">
				Total Balance:
				<b>${daySheet.balance} </b>
			</td>
		</tr>
		<tr>
			<td colspan="3">
				<hr class="horizontalRule" />
			</td>
		</tr>
	</table>
</div>
<script>
	
</script>
