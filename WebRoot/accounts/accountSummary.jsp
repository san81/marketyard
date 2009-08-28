<%@ taglib prefix="s" uri="/struts-tags"%>

<table  width="100%">
		<tr class="acHeader">
			<td>
				<table>
					<tr>
						<td>
							Name: ${accountSummaryForm.accountName}
						</td>
					</tr>
					<tr>
						<td>
							City: ${accountSummaryForm.city}
						</td>
					</tr>
					<tr>
						<td>
							Opening Balance as on ${accountSummaryForm.startDate} : ${accountSummaryForm.openingBalance }
						</td>
					</tr>
				</table>
			</td>
			<td>
				<table>
					<tr>
						<td>
							Type : ${accountSummaryForm.accountType}
						</td>
					</tr>
					<tr>
						<td>
							Duration: CurrentMonth
						</td>
					</tr>
					<tr>
						<td>
							Closing Balance as on ${accountSummaryForm.endDate} : 4,000 CR
						</td>
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
