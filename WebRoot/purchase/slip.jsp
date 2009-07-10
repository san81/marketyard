 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 <%@ taglib prefix="s" uri="/struts-tags" %>


<s:actionerror/>
<s:actionmessage/>
<s:fielderror />

<s:form action="admin/slipSubmit" method="post" tooltipConfig="%{'jsTooltipEnabled':'true'}">
<s:head theme="ajax" />
<s:url id="jsonList" value="../json/seedsList.action"/>
<input type=hidden name="qtls">
<input type=hidden name="grossTotal">
<input type=hidden name="hamali">
<input type=hidden name="cc">
<input type=hidden name="mf">
<input type=hidden name="netTotal">
<table width=100%>
	<tr><td>
			<table border=0>
				<tr>
						<td colspan=2> 
								<s:datetimepicker
						             tooltip="Select Date"
						             label="purchase date"
						             name="purchaseDate" />
						 </td>
				</tr>
				<tr>
					<td> Seeds  :</td>
					<td>
							<s:autocompleter name="state" theme="ajax" indicator="indicator" href="%{jsonList}" cssStyle="width: 200px;" autoComplete="false" searchType="substring"/>
							<img id="indicator" src="${pageContext.request.contextPath}/images/indicator.gif" alt="Loading..." style="display:none"/>
							

					</td>
				</tr>
				<tr>
					<td> Bag weight  :</td>
					<td> <input type=text name="bagwt" size=3 onBlur=makeSlip(document.purchaseSlip)> </td>
				</tr>
				<tr>
					<td> Bags :</td>
					<td> <input type=text name="bags" size=3 onBlur=makeSlip(document.purchaseSlip)> &nbsp;&nbsp; Kgs : <input type=text name="smallBag" size=3 onBlur=makeSlip(document.purchaseSlip)> </td>
				</tr>
				<tr>
					<td> Cost/Qtl :</td>
					<td> <input type=text name="cost" size=4 onBlur=makeSlip(document.purchaseSlip)> </td>
				</tr>								
			</table>
		</td>
		<td>
			
		</td>
		<td>
			<table>
					<tr>
					<td> Qtls </td> <td>:</td>
					<td> <div id="qtlsDiv">00-00</div> </td>
				</tr>	
				<tr>
					<td> Gross Total </td> <td>:</td>
					<td> <div id="grossTotalDiv">00.00</div> </td>
				</tr>
				<tr>
					<td> Hamali </td> <td>:</td>
					<td> <span id="hamaliDiv">00.00</span> </td>
				</tr>
				<tr>
					<td> CC </td> <td>:</td>
					<td> <span id="ccDiv">00.00</span> &nbsp;at 2%  </td>
				</tr>
				<tr>
					<td> MF </td> <td>:</td>
					<td> <div id="mfDiv">00.00</div> </td>
				</tr>
				<tr>
					<td> Net Total </td> <td>:</td>
					<td> <div id="netTotalDiv">00.00</div> </td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td colspan=3><hr></td>
	</tr>
	<tr>
		<td>
			<table>
				<tr>
					<td colspan=3>Purchased Party Details: </td>
				</tr>
				<tr>
					<td>Choose Account </td>
					<td>:</td>
					<td><select><option>MS</option></select></td>
				</tr>
				<tr>
					<td>PurchaseBy </td>
					<td>:</td>
					<td><select><option>CASH</option><option>CREDIT</option></select></td>
				</tr>
			</table>
		</td>
		<td>
			
		</td>
		<td>
			<table>
				<tr>
					<td colspan=3>Farmer Details : </td>
				</tr>
				<tr>
					<td>Farmer Name </td>
					<td>:</td>
					<td><input type=text name="fname"></td>
				</tr>
				<tr>
					<td>City </td>
					<td>:</td>
					<td><input type=text name="fcity"></td>
				</tr>
				<tr>
					<td>Description </td>
					<td>:</td>
					<td><textarea name=description></textarea></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td colspan=3 align=center> <br>
		</td>
	</tr>
	<tr>
		<td colspan=3 align=center> <input type=submit value="Make Purchase Entry" onClick="plProcess()">
		</td>
	</tr>
	
</table>
</s:form>
