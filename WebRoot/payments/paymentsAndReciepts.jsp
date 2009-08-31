<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>



<s:form action="confirmTransaction.action" namespace="admin" method="post"
	validate="true">
<s:head theme="ajax" />
<s:hidden name="action"></s:hidden>
<s:url id="accountsList" value="../json/accountIdsAndNamesList.action"></s:url>
	<table width="100%" border="0">
		<tr>
			<td colspan=2 valign="top">
				<span  class="subHead">
					<s:if test="action=='Receipt'">
						<s:text name="label.receiptVoucher"></s:text>
					</s:if>
					<s:else>
						<s:text name="label.paymentVoucher"></s:text>
					</s:else>
				</span>
				<hr>
			</td>
	   </tr>
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
		
		<s:textfield name="amount" key="label.amount" required="true">
		</s:textfield>
		
		<tr>
			<td align="right">
				<s:text name="label.paymentMode"></s:text>
				<span class="required">*</span>:
			</td>
			<td>
				<select name="paymentMode" onchange="setBankDetailsDiv(this)">
					<option value="CASH" selected>
						CASH
					</option>
					<option value="CHECK">
						CHECK
					</option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<div id="bankDetailsDiv" style="display: none">
					<table border=0 width="100%">
						<tr>
							<td align="right">
								<s:text name="label.bankName"></s:text>
								<span class="required">*</span>:
							</td>
							<td>
								<input type="text" name="bankName">
							</td>
						</tr>
						<tr>
							<td align="right">
								<s:text name="label.checkNumber"></s:text>
								<span class="required">*</span>:
							</td>
							<td>
								<input type="text" name="checkNumber">
							</td>
						</tr>
						<tr>
							<td align="right">
								<s:text name="label.branchName"></s:text>
								<span class="required">*</span>:
							</td>
							<td>
								<input type="text" name="branchName">
							</td>
						</tr>
					</table>
				</div>
			</td>
		</tr>
		
				<s:submit key="label.submit"></s:submit>
			
	</table>
</s:form>
