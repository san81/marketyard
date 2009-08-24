<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:url id="accountsList" value="../json/accountIdsAndNamesList.action"></s:url>

<s:form action="confirmTransaction.action" namespace="admin" method="post"
	validate="true">
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
			<s:textfield name="amount" key="label.amount" required="true">
			</s:textfield>
		</tr>
		<tr>
			<td>
				<s:text name="label.paymentMode"></s:text>
				<span class="required">*</span>:
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
			<td>
				<div id="bankDetailsDiv" style="display: none">
					<table>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td>
								<s:text name="label.bankName"></s:text>
								<span class="required">*</span>:
							</td>
							<td>
								<input type="text" name="bankName">
							</td>
						</tr>
						<tr>
							<td>
								<s:text name="label.checkNumber"></s:text>
								<span class="required">*</span>:
							</td>
							<td>
								<input type="text" name="checkNumber">
							</td>
							<td>
								&nbsp;&nbsp;&nbsp;&nbsp;
							</td>
							<td>
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
		<tr>
			<td colspan=3 align=center>
				<s:submit key="label.submit"></s:submit>
			</td>
		</tr>
	</table>
</s:form>
