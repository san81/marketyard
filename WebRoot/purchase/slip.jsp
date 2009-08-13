 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 <%@ taglib prefix="s" uri="/struts-tags" %>

<s:actionerror/>
<s:actionmessage/>
<s:fielderror />

<s:form action="admin/slipSubmit" method="post" tooltipConfig="%{'jsTooltipEnabled':'true'}" name="slipSubmit">
<s:head theme="ajax" />
<s:url id="jsonList" value="../json/seedsList.action"/>

<s:hidden name="qtls"></s:hidden>
<s:hidden name="grossTotal"></s:hidden>
<s:hidden name="hamali"></s:hidden>
<s:hidden name="cc"></s:hidden>
<s:hidden name="mf"></s:hidden>
<s:hidden name="netTotal"></s:hidden>

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
					<td align="right"> <s:text name="seeds"></s:text>:</td>
					<td>
							<s:autocompleter name="seed" theme="ajax" indicator="indicator" href="%{jsonList}" cssStyle="width: 200px;" autoComplete="false" searchType="substring"/>
							<img id="indicator" src="${pageContext.request.contextPath}/images/indicator.gif" alt="Loading..." style="display:none"/>
							

					</td>
				</tr>
				<tr>
					<td> <s:textfield name="bagwt" key="label.slip.bagWeight" onblur="makeSlip(document.slipSubmit)"> </s:textfield> </td>
				</tr>
				<tr>
					<td> <s:textfield name="bags" key="label.slip.bags" onblur="makeSlip(document.slipSubmit)"></s:textfield> &nbsp;&nbsp; <s:textfield name="smallBag" key="label.slip.kgs" onblur="makeSlip(document.slipSubmit)"> </s:textfield> </td>
				</tr>
				<tr>
					<td> <s:textfield name="cost" key="label.slip.costperQtl" onblur="makeSlip(document.slipSubmit)"></s:textfield> </td>
				</tr>								
			</table>
		</td>
		<td>
			
		</td>
		<td>
			<table>				
				<tr>
					<td> <s:text name="label.slip.qtls"></s:text> </td> <td>:</td>
					<td> <div id="qtlsDiv" class="derivedInfo">00-00</div> </td>
				</tr>	
				<tr>
					<td> <s:text name="label.slip.grossTotal"></s:text> </td> <td>:</td>
					<td> <div id="grossTotalDiv" class="grandTotal">00.00</div> </td>
				</tr>
				<tr>
					<td> <s:text name="label.slip.hamali"></s:text> </td> <td>:</td>
					<td> <span id="hamaliDiv" class="expensesColor">00.00</span> &nbsp;at ${hamali} per bag</td>
				</tr>
				<tr>
					<td> <s:text name="label.slip.cc"></s:text> </td> <td>:</td>
					<td> <span id="ccDiv" class="expensesColor">00.00</span> &nbsp;at ${cc}%  </td>
				</tr>
				<tr>
					<td> <s:text name="label.slip.mf"></s:text> </td> <td>:</td>
					<td> <span id="mfDiv" class="expensesColor">00.00</span> &nbsp;at ${mf}%</td>
				</tr>
				<tr>
					<td> <s:text name="label.slip.netTotal"></s:text> </td> <td>:</td>
					<td> <div id="netTotalDiv" class="grandTotal">00.00</div> </td>
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
					<td colspan=3><s:text name="label.slip.purchaseParty"></s:text></td>
				</tr>
				<tr>
					<td><s:text name="label.slip.chooseAccount"></s:text> </td>
					<td>:</td>
					<td><select><option>MS</option></select></td>
				</tr>
				<tr>
					<td><s:text name="label.slip.purchasedBy"></s:text> </td>
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
					<td colspan=3><s:text name="label.slip.farmarDetails"></s:text> </td>
				</tr>
				<tr>
					<td><s:text name="label.slip.farmarName"></s:text> </td>
					<td>:</td>
					<td><input type=text name="fname"></td>
				</tr>
				<tr>
					<td><s:text name="label.slip.city"></s:text> </td>
					<td>:</td>
					<td><input type=text name="fcity"></td>
				</tr>
				<tr>
					<td><s:text name="label.slip.description"></s:text> </td>
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
