 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

 <%@ taglib prefix="s" uri="/struts-tags" %>



<s:form action="backSlipSubmit.action" namespace="admin" method="post" tooltipConfig="%{'jsTooltipEnabled':'true'}" name="slipSubmit">
<s:head theme="ajax" />
<s:url id="jsonList" value="../json/seedsList.action"/>
<s:url id="buyerAccountsList" value="../json/accountIdsAndNamesList.action"/>

<%---- values from config --%>
<s:hidden name="cashCommissionRate"></s:hidden>
<s:hidden name="adthiRate"></s:hidden>
<s:hidden name="hamaliRate"></s:hidden>
<%--values from config--%>
<%--derived values --%>
<s:hidden name="qtls"></s:hidden>
<s:hidden name="grossTotal"></s:hidden>
<s:hidden name="totalHamali"></s:hidden>
<s:hidden name="totalCc"></s:hidden>
<s:hidden name="totalMf"></s:hidden>
<s:hidden name="netTotal"></s:hidden>
<%--derived values --%>
<s:hidden name="purchaseDate"></s:hidden>
<s:hidden name="seed"></s:hidden>
<s:hidden name="seedKey"></s:hidden>
<s:hidden name="bagwt"></s:hidden>
<s:hidden name="bags"></s:hidden>
<s:hidden name="smallBag"></s:hidden>
<s:hidden name="cost"></s:hidden>

<s:hidden name="buyerAccountId"></s:hidden>
<s:hidden name="buyerAccountIdKey"></s:hidden>
<s:hidden name="status"></s:hidden>

<s:hidden name="supplier"></s:hidden>
<s:hidden name="supplierKey"></s:hidden>
<s:hidden name="supplierCity"></s:hidden>
<s:hidden name="description"></s:hidden>

<s:hidden name="paymentMode"></s:hidden>
<s:hidden name="bankName"></s:hidden>
<s:hidden name="branchName"></s:hidden>
<s:hidden name="checkNumber"></s:hidden>
<s:hidden name="paymentAmount"></s:hidden>

	
<table width=100% border="0">
	 <s:if test="action!='confirm'" >
		 <tr>
			<td colspan="3">
				<b>SLIP ID: </b><span class="grandTotal">${slipId}</span>				 
			</td>
		 </tr>
		 <tr>
			<td colspan=3>
			  	<b><s:text name="label.slip.status"></s:text> :
				<span class="grandTotal">${status }</span><br/><br/>
			</td>
		</tr>
	 </s:if>	
	 <tr>
		<td colspan=3 class="subHead"><s:text name="label.purchaseDetails"></s:text><hr></td>
	  </tr>	
	  <tr><td>
			<table border=0>				
				<tr>
					<td> <s:text name="label.slip.purchaseDate"></s:text> </td> <td>:</td>
					<td> <div id="qtlsDiv" class="derivedInfo">${purchaseDate}</div> </td>
				</tr>	
				<tr>
					<td> <s:text name="label.slip.seeds"></s:text> </td> <td>:</td>
					<td> <div id="grossTotalDiv" class="derivedInfo">${seed }</div> </td>
				</tr>
				<tr>
					<td> <s:text name="label.slip.bagWeight"></s:text> </td> <td>:</td>
					<td> <span id="hamaliDiv" class="derivedInfo">${bagwt}</span> </td>
				</tr>
				<tr>
					<td> <s:text name="label.slip.bags"></s:text> </td> <td>:</td>
					<td> <span id="ccDiv" class="derivedInfo">${bags}</span> </td>
				</tr>
				<tr>
					<td> <s:text name="label.slip.costperQtl"></s:text> </td> <td>:</td>
					<td> <span id="mfDiv" class="derivedInfo">${cost}</span> </td>
				</tr>										
			</table>
		</td>
		<td>
			
		</td>
		<td>
			<table>	
				<tr>
					<td> <s:text name="label.slip.qtls"></s:text></td> <td>:</td>
					<td> <div id="qtlsDiv" class="derivedInfo">${qtls }</div> </td>
				</tr>	
				<tr>
					<td> <s:text name="label.slip.grossTotal"></s:text> </td> <td>:</td>
					<td> <div id="grossTotalDiv" class="grandTotal">${grossTotal }</div> </td>
				</tr>
				<tr>
					<td> <s:text name="label.slip.hamali"></s:text> </td> <td>:</td>
					<td> <span id="hamaliDiv" class="expensesColor">${totalHamali}</span> &nbsp;at ${hamaliRate} per bag</td>
				</tr>
				<tr>
					<td> <s:text name="label.slip.cc"></s:text> </td> <td>:</td>
					<td> <span id="ccDiv" class="expensesColor">${totalCc}</span> &nbsp;at ${cashCommissionRate}%  </td>
				</tr>
				<tr>
					<td> <s:text name="label.slip.mf"></s:text> </td> <td>:</td>
					<td> <span id="mfDiv" class="expensesColor">${totalMf}</span> &nbsp;at ${adthiRate}%</td>
				</tr>
				<tr>
					<td> <s:text name="label.slip.netTotal"></s:text> </td> <td>:</td>
					<td> <div id="netTotalDiv" class="grandTotal">${netTotal}</div> </td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td colspan=3 class="subHead"><br>
			<s:text name="label.buyerSupplierDetails"></s:text>
			<hr>
		</td>
	</tr>
	<tr>
		<td valign="top">
			<table>
				<tr>
					<td colspan=3 align="center" style="font-weight:bold"><s:text name="label.slip.purchaseParty"></s:text></td>
				</tr>
				<tr>
					<td align="right"> <s:text name="label.slip.buyer"></s:text></td>
					<td>:</td>
					<td colspan="1">
						${buyerAccountId}
					</td>
				</tr>
				<tr>
					<td><s:text name="label.slip.status"></s:text> </td>
					<td>:</td>
					<td colspan="1">
					${status }</td>
				</tr>
			</table>
		</td>
		<td>
			
		</td>
		<td>
			<table>
				<tr>
					<td colspan=3 align="center" style="font-weight:bold"><s:text name="label.slip.farmarDetails"></s:text> </td>
				</tr>
				<tr>
					<td align="left"> 
						<s:text name="label.slip.city"></s:text>
					</td>
					<td>:</td>
					<td colspan="1">
						${supplierCity}
					</td>
				</tr>				
				<tr>
					<td align="left"> <s:text name="label.slip.supplier"></s:text></td>
					<td>:</td>
					<td colspan="1">
							${supplier}
					</td>
				</tr>
				<tr>
					<td align="left"> <s:text name="label.slip.description"></s:text></td>
					<td>:</td>
					<td colspan="1">
						${description}
					</td>
				</tr>				
			</table>
		</td>
	</tr>	
	
	<s:if test="action!='load'">
		<tr>
			<td colspan=3 align=center> <hr>
			</td>
		</tr>
		<tr>
		<td>
			<table border=0>
				<tr>
					<td colspan=3 class="subHead"> 
						<s:text name="label.slip.paymentDetails"></s:text>
						<hr>
					</td>
				</tr>	
				<tr>
					<td>
						<s:label key="paymentMode"></s:label>
					</td>
				</tr>
				<s:label key="paymentAmount" ></s:label>
				<s:label key="checkNumber" ></s:label>				
			</table>
		</td>
	    <td>
	    </td>
	    <td>
	       <table>
	       		<tr>
	       			<td><br><br></td>
	       		</tr>
		    	<s:label key="bankName"></s:label>
				<s:label key="branchName"></s:label>				
			</table>
	    </td>
	</tr>
	</s:if>	
	<tr>
		<td colspan=3 align="center"> 
		<br/>
		</td>
	</tr>
	<s:if test="action=='load'" >
		<tr>
			<td colspan="3" align="left" class="subHead">
				
					<s:text name="label.viewPayemnts"></s:text>
					[ <a href="#" onclick="togglePaymentsDiv()"><span id="collapseDiv">+</span></a> ]
				<br>
				<hr>
			</td>
		</tr>
		<tr>
			<td colspan="3">
				<div id="paymentsDiv" style="display: none">				
					<jsp:include flush="true" page="/purchase/viewPayments.jsp"></jsp:include>
				</div>
			</td>
		</tr>
	</s:if>
	<tr>
	<s:if test="action=='confirm'" >
		<td colspan=3 align="center">
			<input type="submit" value="Edit Slip" />
				&nbsp; &nbsp;
			<input type="button" value="Save" onClick="document.slipSubmit.action='saveSlip.action';document.slipSubmit.submit();"/>
		</td>
	</s:if>
	<s:elseif test="action=='save'">
		<td colspan=3 align="center">
			<input type="button" value="Print" />
				&nbsp; &nbsp;
			<input type="button" value="Make Another Purchase"/>
		</td>
	</s:elseif>
	<s:elseif test="action=='load'">
		<td colspan=3 align="center">
			<input type="submit" value="Edit Slip" />
				&nbsp; &nbsp;
			<input type="button" value="Print"/>
		</td>
	</s:elseif>		
	</tr>
</table>
</s:form>
<script>
	var payments = ${paymentsJSON};
</script>