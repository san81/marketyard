<%@ taglib prefix="s" uri="/struts-tags"%>

<table  width="100%">
		<tr class="acHeader">
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
						<td class="gsumDisplay">${accountSummaryForm.openingBalance }</td>
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
						<td><b>CurrentMonth</b></td>
					</tr>
					<tr>
						<td>
							Closing Balance <br>as on <b>${accountSummaryForm.endDateToDisplay}</b>
						</td>
						<td>:</td>
						<td class="gsumDisplay">${accountSummaryForm.closingBalance }</td>
					</tr>
				</table>
			</td>
		</tr>
		
		<tr>
			<td colspan=2>
				<div id="ledger-grid"></div>
			</td>
		</tr>
	</table>
