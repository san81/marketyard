<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<table border=0 width="100%">
	<tr id='paymentDetailsTitleRow'>
		<td colspan=2>
			<span class="subHead"> <s:text
					name="label.slip.paymentDetails"></s:text> </span>
			<hr>	
		</td>
	</tr>
	<tr>
		<td>
			<table>
				<s:select key="label.paymentMode" name="paymentMode"
					list="#{'CASH':'CASH', 'CHECK':'CHECK'}"
					onchange="setBankDetailsDiv(this)"></s:select>
				<tr>
					<td align="left">
						<s:text name="label.amount"></s:text>
						<span class="required">*</span>:
					</td>
					<td>						
						<input size="10" type="text" name="paymentAmount" class="grandTotal"
							value="${paymentAmount}">
					</td>
				</tr>
			</table>
		</td>
		<td>
			<div id="bankDetailsDiv" style="display: none">
				<table>
					<s:textfield key="label.bankName" name="bankName" required="true"></s:textfield>
					<s:textfield key="label.checkNumber" name="checkNumber"
						required="true"></s:textfield>
					<s:textfield key="label.branchName" name="branchName"
						required="true"></s:textfield>
				</table>
			</div>
		</td>
	</tr>
</table>
