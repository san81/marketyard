<%@ taglib prefix="s" uri="/struts-tags"%>

<table  width="100%">
		<tr>
			<td colspan=2>
				<span  class="subHead">
					${accountSummaryForm.accountName}&nbsp;&nbsp;&nbsp;
					<s:text name="label.accountSummary"></s:text>
				</span>
			<hr></td>
	    </tr>
		<tr>
			<td>
				<table>
					<tr>
						<td>
							Name 
						</td>
						<td>:</td>
						<td><b>${accountSummaryForm.accountName}</b></td>
					</tr>
					<tr>
						<td>
							City
						</td>
						<td>:</td>
						<td><b>${accountSummaryForm.city}</b></td>
					</tr>
					<tr>
						<td>
							Opening Balance <br>as on <b>${accountSummaryForm.startDateToDisplay}</b>
						</td>
						<td>:</td>
						<td class="gsumDisplay">${accountSummaryForm.openingBalanceToDisplay }</td>
					</tr>
				</table>
			</td>
			<td>
				<table>
					<tr>
						<td>
							Type
						</td>
						<td>:</td>
						<td><b>${accountSummaryForm.accountType}</b></td>
					</tr>
					<tr>
						<td>
							Duration
						</td>
						<td>:</td>
						<td><b>${accountSummaryForm.duration}</b></td>
					</tr>
					<tr>
						<td>
							Closing Balance <br>as on <b>${accountSummaryForm.endDateToDisplay}</b>
						</td>
						<td>:</td>
						<td class="gsumDisplay">${accountSummaryForm.closingBalanceToDisplay }</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan=2>				
				<hr>
			</td>
	    </tr>
		<tr>
			<td colspan=2>
				<div id="ledger-grid"></div>
			</td>
		</tr>
	</table>
<form name="hiddenValuesForm">
	<input type=hidden name="accountHolderCtrl" value="${accountSummaryForm.accountName}">
	<div id='ledgerJSONDiv' style="display:none">ledgerJSON=${ledgerJSON}</div>
	<input type=hidden name="openingBalCtrl" value="${openingBal}">
</form>