
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<div>
	Day Sheet for the Day ${daySheet.date}
	<br/><br/>
	<span><b>Opening Balance : ${daySheet.openingBalanceFormatted}</b></span>
	<br/><br/>
	
	<s:if test="daySheet.creditsMap.size() == 0 && daySheet.debitsMap.size() == 0">
			<span  style="width:100%; align:center;" class="subHead">No Transactions Done on this Day</span>
	</s:if>
	<s:else>
			<table border="0" width="100%"
		style="border: 0.1em solid rgb(202, 218, 231);">
		
		<% String[] rowStyles = { "listRow", "listAltRow" };   %>		  
											
		<tr>
			<td valign="top" width="45%">
				<table border="0" width="100%">
					<tr class="subHead">
						<td align="center" colspan="2">
							<SPAN style="color:blue">Credits(CR)</SPAN>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<hr class="horizontalRule" />
						</td>
					</tr>
					<%int creditsCounter = 0; %>
					<s:iterator id="element" status="mapStatus"
						value="daySheet.creditsMap">
						<%String rowStyle = rowStyles[creditsCounter++ % 2]; %>
						<tr class="<%=rowStyle %>">
							<td>
								<B><s:property value="key" />
								</B>
							</td>
							<td align="right">
								<s:property value="value" />
							</td>
						</tr>
					</s:iterator>
				</table>
			</td>
			<td width="5%"></td>
			<TD style="border-left: 1px solid blue; padding: 5px;">
			<td width="5%"></td>
			<td valign="top" width="45%">
				<table border="0" width="100%">
					<tr class="subHead">
						<td align="center" colspan="2">
							<SPAN style="color:blue">Debits(DR)</SPAN>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<hr class="horizontalRule" />
						</td>
					</tr>
					<%int debitsCounter = 0; %>
					<s:iterator id="element" status="mapStatus"
						value="daySheet.debitsMap">
						<%String rowStyle = rowStyles[debitsCounter++ % 2]; %>
						<tr class="<%=rowStyle %>">
							<td>
								<B><s:property value="key" />
								</B>
							</td>
							<td align="right">
								<s:property value="value" />
							</td>
						</tr>
					</s:iterator>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table width="100%">
					<tr>
						<td colspan="2">
							<hr class="horizontalRule" />
						</td>
					</tr>
					<tr>
						<td>
							<B>Total Credits:</B>
						</td>
						<td align="right">
							<b>${daySheet.sumOfCreditsFormatted}</b>
						</td>
					</tr>
				</table>
			</td>
			<td width="4%"></td>
			<TD style="border-left: 1px solid blue; padding: 5px;">
			<td width="5%"></td>
			<td>
				<table width="100%">
					<tr>
						<td colspan="2">
							<hr class="horizontalRule" />
						</td>
					</tr>
					<tr>
						<td>
							<B>Total Debits:</B>
						</td>
						<td align="right">
							<b>${daySheet.sumOfDebitsFormatted}</b>
						</td>
					</tr>
				</table>
			</td>
		</tr>
<%--		<tr>--%>
<%--			<td colspan="5">--%>
<%--				<hr class="horizontalRule" />--%>
<%--			</td>--%>
<%--		</tr>--%>
<%--		<tr>--%>
<%--			<td colspan="5" align="center">--%>
<%--				Total Balance:--%>
<%--				<b>${daySheet.balanceFormatted} </b>--%>
<%--			</td>--%>
<%--		</tr>--%>
<%--		<tr>--%>
<%--			<td colspan="5">--%>
<%--				<hr class="horizontalRule" />--%>
<%--			</td>--%>
<%--		</tr>--%>
	</table>	
	</s:else>

	<br/><br/>
	<span><b>Clossing Balance : ${daySheet.closingBalanceFormatted}</b></span>
</div>
